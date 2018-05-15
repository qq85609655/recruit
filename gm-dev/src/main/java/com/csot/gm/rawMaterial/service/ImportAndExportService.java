package com.csot.gm.rawMaterial.service;

import javax.servlet.http.HttpServletResponse;

import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.springframework.web.multipart.MultipartFile;

public interface ImportAndExportService {
  
  String getImportPartTemp(HttpServletResponse response, String level);
  
  String uploadExcel(MultipartFile multipartFile, String level, SysUser sysUser);

  String downloadExcel(HttpServletResponse response);
 
  
}
