package com.csot.gm.materialManage.service.file;

import java.io.IOException;

import com.csot.gm.materialManage.model.original.file.FileUpload;
import com.csot.gm.rawMaterial.model.FileEntity;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface FileUploadService {
  MiniRtn2Grid<FileUpload> getGrid(MiniGridPageSort pageSort, String searchKey);

  FileUpload getByPrimaryKey(String primaryKey);

  void create(FileUpload fileUpload);

  void updateSelective(FileUpload fileUpload);

  void remove(String primaryKey);
  
  void upload(FileUpload file, FileEntity entity);

  FileEntity download(String id) throws IOException;
  
  void delete(String id);
}