package org.example.web;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@Controller
public class FileDownloadController
{
  @GetMapping("/download")
  @ResponseBody
  public void download(@RequestParam final String partyId, final HttpServletResponse response)
  {
    try
    {
      final XSSFWorkbook workbook = new XSSFWorkbook();
      final XSSFSheet sheet = workbook.createSheet("Invoice Templ");

      final Row rowTitle = sheet.createRow(0);
      final Cell cellTitle = rowTitle.createCell(0);
      cellTitle.setCellValue("Party ID");

      response.setContentType("application/vnd.ms-excel");
      response.setHeader("Content-Disposition", "attachment; filename=Invoice Templ" + partyId + ".xlsx");

      final OutputStream out = response.getOutputStream();
      workbook.write(out);
    }
    catch (final Exception ex)
    {
      ex.printStackTrace();
    }
  }
}
