package com.cucumber.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cucumber.base.BaseClass;

public class ExcelUtils extends BaseClass {
	static String value;

	public static String readData(String sheetname, String TestID, String HeaderValue) throws IOException {
		FileInputStream filelocation = new FileInputStream(TestDataUtils.excelpath);
		XSSFWorkbook workbook = new XSSFWorkbook(filelocation);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rowCount = sheet.getLastRowNum() + 1;
		// String value;
		for (int i = 0; i < rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			int columnCount = row.getLastCellNum();

			String TCID = sheet.getRow(i).getCell(0).getStringCellValue();
			if (TCID.equals(TestID)) {
				for (int j = 0; j < columnCount; j++) {
					String TestHeaderValueData = sheet.getRow(0).getCell(j).getStringCellValue();

					if (TestHeaderValueData.equals(HeaderValue)) {

						XSSFCell cell = sheet.getRow(i).getCell(j);

						int ctype = cell.getCellType();

						if (ctype == 1) {
							value = cell.getStringCellValue();
						} else if (ctype == 0) {
							double num = cell.getNumericCellValue();

							value = String.valueOf(num);

						} else {
							Date dateCell = cell.getDateCellValue();
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
							value = dateFormat.format(dateCell);
						}

					}
				}
			}
		}

		return value;
	}
}