package org.sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteDataToExcel {

    public static void main(String[] args) throws IOException {
	// update of excel
	File file = new File("C:\\Users\\sabas\\eclipse-workspace\\SampleMavenApril\\TestData\\testd.xlsx");
	FileInputStream stream = new FileInputStream(file);
	Workbook workbook = new XSSFWorkbook(stream);
	// getting sheet from workbook
	Sheet sheet = workbook.getSheet("Sheet3");
	// getting Row from sheet
	Row row = sheet.getRow(2);
	// getting cell from Row
	Cell cell = row.getCell(1);
	// getiing value from cell
	String s = cell.getStringCellValue();
	System.out.println(s);
	if (s.equals("nopqr")) {
	    cell.setCellValue("Java Selenium");
	}

	FileOutputStream fileOutputStream = new FileOutputStream(file);
	workbook.write(fileOutputStream);

	System.out.println("Changes done successfully!!!!");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	WebElement txtuserName = driver.findElement(By.id("email"));
	txtuserName.sendKeys("Welcome");
    }

}
