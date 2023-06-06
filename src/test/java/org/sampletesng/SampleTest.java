package org.sampletesng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
	WebDriver driver;

	@BeforeMethod
	private void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test(dataProvider = "getData")
	private void tc0(String s, String s2) {
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys(s);

		WebElement txtPass = driver.findElement(By.id("pass"));
		txtPass.sendKeys(s2);
	}

	@DataProvider(name = "getData")
	private Object[][] getData() {
		Object[][] data = new Object[3][2];
		data[0][0] = "java";
		data[0][1] = "selenium";
		data[1][0] = "java Selenium";
		data[1][1] = "junit";
		data[2][0] = "Testng";
		data[2][1] = "priority";
		return data;
	}
}
