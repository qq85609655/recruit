package com.csot.recruit.service.impl.resumelibrary.addressbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import com.csot.recruit.dao.original.resumelibrary.addressbook.AddressbookMapper;
import com.csot.recruit.model.original.resumelibrary.addressbook.Addressbook;
import com.csot.recruit.model.original.resumelibrary.addressbook.AddressbookColumns;
import com.csot.recruit.model.original.resumelibrary.addressbook.AddressbookCriteria;
import com.csot.recruit.service.resumelibrary.addressbook.AddressbookService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service("addressbookService")
public class AddressbookServiceImpl implements AddressbookService {
  private static final Logger logger = LoggerFactory.getLogger(AddressbookServiceImpl.class);

  @Resource
  private AddressbookMapper addressbookMapper;

  @Override
  public MiniRtn2Grid<Addressbook> getGrid(MiniGridPageSort pageSort, String personName,
      String company, String remark) {
    MiniRtn2Grid<Addressbook> grid = new MiniRtn2Grid<Addressbook>();
    AddressbookCriteria criteria = new AddressbookCriteria();
    // 查询条件
    AddressbookCriteria.Criteria criter = criteria.or();
    if (StringUtils.hasText(personName)) {
      criter.andPersonNameLikeInsensitive("%" + personName + "%");
    }
    if (StringUtils.hasText(company)) {
      criter.andCompanyLikeInsensitive("%" + company + "%");
    }
    if (StringUtils.hasText(remark)) {
      criter.andRemarkLikeInsensitive("%" + remark + "%");
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = AddressbookColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(addressbookMapper.selectByExample(criteria));
    grid.setTotal(addressbookMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public Addressbook getByPrimaryKey(String primaryKey) {
    return addressbookMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(Addressbook addressbook) {
    addressbookMapper.insert(addressbook);
  }

  @Override
  public void updateSelective(Addressbook addressbook) {
    addressbookMapper.updateByPrimaryKeySelective(addressbook);
  }

  @Override
  public void remove(String primaryKey) {
    addressbookMapper.deleteByPrimaryKey(primaryKey);
  }

  @SuppressWarnings("resource")
  @Override
  public int importAddressbook(MultipartFile multipartFile, String basePath, String importer)
      throws Exception {
    String sourceName = multipartFile.getOriginalFilename();
    File file = new File(basePath);
    if (!file.exists()) {
      file.mkdirs();
    }
    String path = basePath + File.separator + sourceName;
    multipartFile.transferTo(new File(path));
    FileInputStream in = new FileInputStream(path);
    Workbook wb = null;
    int count = 0;
    if (path.endsWith(".xls")) {
      wb = new HSSFWorkbook(in);
    } else if (path.endsWith(".xlsx")) {
      wb = new XSSFWorkbook(in);
    } else {
      return count;
    }
    Sheet sheet = wb.getSheetAt(0);
    int rowNum = sheet.getLastRowNum();
    if (rowNum < 2) {
      logger.error("上传文件为空！");
    } else {
      for (int i = 2; i <= rowNum; i++) {
        Row row = sheet.getRow(i);
        String personName = row.getCell(0).getStringCellValue();
        String company = row.getCell(1).getStringCellValue();
        String organization = row.getCell(2).getStringCellValue();
        String currentPosition = row.getCell(3).getStringCellValue();
        String remark = row.getCell(4).getStringCellValue();
        String email = row.getCell(5).getStringCellValue();
        String phoneNo = row.getCell(6).getStringCellValue();
        String telNo = row.getCell(7).getStringCellValue();
        Addressbook ab = new Addressbook();
        ab.setCreateTime(new Date());
        ab.setCreateUserId(importer);
        ab.setPersonName(personName);
        ab.setCompany(company);
        ab.setOrganization(organization);
        ab.setCurrentPosition(currentPosition);
        ab.setRemark(remark);
        ab.setEmail(email);
        ab.setPhoneNo(phoneNo);
        ab.setTellphoneNo(telNo);
        ab.setId(UUID.randomUUID().toString().replace("-", ""));
        addressbookMapper.insert(ab);
        count++;
      }
    }
    return count;
  }
}
