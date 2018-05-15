package com.csot.gm.materialManage.service.impl.file;

import com.csot.gm.materialManage.dao.original.file.FileUploadMapper;
import com.csot.gm.materialManage.model.original.file.FileUpload;
import com.csot.gm.materialManage.model.original.file.FileUploadColumns;
import com.csot.gm.materialManage.model.original.file.FileUploadCriteria;
import com.csot.gm.materialManage.service.file.FileUploadService;
import com.csot.gm.rawMaterial.model.FileEntity;
import com.csot.gm.rawMaterial.service.PartNoAddService;
import com.csot.gm.rawMaterial.service.impl.ImportAndExportServiceImpl;
import com.csot.gm.util.FileUploadException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("fileUploadService")
public class FileUploadServiceImpl implements FileUploadService {
  private static final Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);
  private SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

  @Resource
  private FileUploadMapper fileUploadMapper;

  @Resource
  private PartNoAddService partNoAddService;

  private DecimalFormat decimalFormat = new DecimalFormat("#.0");

  @Override
  public MiniRtn2Grid<FileUpload> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<FileUpload> grid = new MiniRtn2Grid<FileUpload>();
    FileUploadCriteria criteria = new FileUploadCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andFileNameLike("%" + searchKey + "%");
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = FileUploadColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(fileUploadMapper.selectByExample(criteria));
    grid.setTotal(fileUploadMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public FileUpload getByPrimaryKey(String primaryKey) {
    return fileUploadMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(FileUpload fileUpload) {
    fileUpload.setId(UUID.randomUUID().toString().replace("-", ""));
    fileUploadMapper.insert(fileUpload);
  }

  @Override
  public void updateSelective(FileUpload fileUpload) {
    fileUploadMapper.updateByPrimaryKeySelective(fileUpload);
  }

  @Override
  public void remove(String primaryKey) {
    fileUploadMapper.deleteByPrimaryKey(primaryKey);
  }

  /**
   * 保存上传记录
   */
  @Transactional
  @Override
  public void upload(FileUpload file, FileEntity entity) {

    // 重命名文件带时间后缀
    String time = format.format(new Date());
    String oldName = entity.getFileName();
    String newName = time + oldName;
    entity.setFileName(newName);
    String path =
        ImportAndExportServiceImpl.getSysUploadPath(File.separator + "uploadedMess"
            + File.separator);
    entity.setFilePath(path);
    FileUpload upload = saveUpload(entity);
    if (upload == null) {
      throw new FileUploadException("文件上传失败！");
    }

    file.setId(UUID.randomUUID().toString().replace("-", ""));
    file.setCreateTime(new Date());
    file.setFileLocation(upload.getFileLocation());
    file.setFileName(upload.getFileName());
    file.setFileSize(upload.getFileSize());
    file.setFileType(upload.getFileType());
    fileUploadMapper.insert(file);

    // 对Excel进行检查处理
    partNoAddService.checkMess(path + file.getFileName());
  }

  @Override
  public FileEntity download(String id) throws IOException {

    FileUpload file = fileUploadMapper.selectByPrimaryKey(id);
    if (file == null) {
      throw new FileUploadException("File not found!");
    }
    String filePath = file.getFileLocation();
    return downloadFile(file.getId(), filePath);
  }

  /**
   * 下载文件
   * 
   * @param uploadId
   * @param path
   * @return
   * @throws IOException
   */
  public FileEntity downloadFile(String uploadId, String path) throws IOException {
    FileUpload file = fileUploadMapper.selectByPrimaryKey(uploadId);
    if (file == null) {
      throw new FileUploadException("File not found!");
    }

    FileEntity entity = new FileEntity();
    entity.setFilePath(path + file.getFileName());
    entity.setFileName(file.getFileName());
    return entity;
  }

  /**
   * 保存上传文件
   * 
   * @param file
   * @return
   */
  public FileUpload saveUpload(FileEntity file) {
    FileUpload upload = null;
    OutputStream os = null;
    String fileSize = "";
    try {
      File outfile = new File(file.getFilePath());
      if (!outfile.exists()) { // 如果目录不存在，则创建
        outfile.mkdir();
      }

      File toFile = new File(outfile, file.getFileName());
      // 创建一个输出流
      os = new FileOutputStream(toFile);
      // 设置缓存
      byte[] buffer = new byte[1024];
      int length = 0;
      // 读取myFile文件输出到toFile文件中
      while ((length = file.getInputStream().read(buffer)) > 0) {
        os.write(buffer, 0, length);
      }

      if (toFile.length() / 1024.0 > 1024) {
        fileSize = decimalFormat.format(toFile.length() / 1024.0 / 1024.0) + " MB";
      } else {
        fileSize = decimalFormat.format(toFile.length() / 1024.0) + " KB";
      }

    } catch (FileNotFoundException e) {
      logger.error(e.getMessage(), e);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    } finally {
      if (os != null)
        try {
          os.close();
        } catch (IOException e) {
          logger.error(e.getMessage(), e);
        }
    }
    logger.info("已上传文件：" + file.getFilePath() + file.getFileName());
    String randomName = UUID.randomUUID().toString().replace("-", "");
    // 存数据
    upload = new FileUpload();
    upload.setFileName(file.getFileName());
    upload.setFileType(file.getFileType());
    upload.setFileSize(fileSize);
    upload.setFileLocation(randomName);
    upload.setFileLocation(file.getFilePath());
    return upload;
  }

  /**
   * 删除记录和文件
   */
  @Transactional
  @Override
  public void delete(String id) {

    FileUpload file = fileUploadMapper.selectByPrimaryKey(id);
    if (file == null) {
      throw new FileUploadException("该文件不存在！");
    }
    // 删除数据库记录
    fileUploadMapper.deleteByPrimaryKey(id);

    // 删除文件
    String fullPathName = file.getFileLocation() + file.getFileName();
    File fileDelete = new File(fullPathName);
    if (!fileDelete.exists() || !fileDelete.isFile()) {
      logger.error("该文件不存在：" + fullPathName);
      return;
    }
    fileDelete.delete();
  }

}
