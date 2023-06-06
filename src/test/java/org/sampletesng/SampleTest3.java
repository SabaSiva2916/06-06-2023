package org.sampletesng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest3 {
	WebDriver driver;

	@BeforeClass
	private void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

	}

	@Test
	private void tc01() {
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("welcome Java");
	}

	@Test
	private void tc02() {
		WebElement txtPass = driver.findElement(By.id("pass"));
		txtPass.sendKeys("hijavaa");
	}

	@Test
	private void tc03() {
		WebElement btnLogin = driver.findElement(By.name("login"));
		btnLogin.click();
	}

	

}
