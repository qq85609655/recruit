package com.csot.recruit.service.interview;

import org.apache.poi.ss.usermodel.Workbook;

public interface InterviewPrintService {

  Workbook getResumeWorkbook(String templatePath, String personCode);

  String dualZipPrint(String templatePath, String personCodes);

}