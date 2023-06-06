package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SampleTest {

	public static void main(String[] args) throws IOException {

		// 1. path of the excel
		File file = new File("C:\\Users\\sabas\\eclipse-workspace\\SampleMavenApril\\TestData\\testd.xlsx");
		// Reading data

		FileInputStream stream = new FileInputStream(file);

		Workbook workbook = new XSSFWorkbook(stream);
		// Worbook --->I , XSSFWorkbook --->c
		Sheet sheet = workbook.getSheet("Sheet3");

		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);

			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				DataFormatter dataFormatter = new DataFormatter();
				String f = dataFormatter.formatCellValue(cell);
				System.out.println(f);
			}

		}
	}
}