package org.sampletesng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest2 {
	WebDriver driver;

	@BeforeClass
	private void BeforeClass() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
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
