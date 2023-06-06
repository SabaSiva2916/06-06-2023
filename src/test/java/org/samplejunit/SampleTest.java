package org.samplejunit;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest {
	static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Before
	public void before() {
		Date date = new Date();
		System.out.println(date);
	}

	@Ignore
	@Test
	public void tc02() {
		WebElement btnLogin = driver.findElement(By.name("login"));
		btnLogin.click();
	}

	@Test
	public void tc0() {
		WebElement txtUserName = driver.findElement(By.id("email"));
		txtUserName.sendKeys("WelcomeJava");

		Assert.assertEquals("Verify username", txtUserName.getAttribute("value"), "WelcomeJava");

	}

	@Test
	public void tc01() {

		WebElement txtPassword = driver.findElement(By.id("pass"));
		txtPassword.sendKeys("hijava");

		Assert.assertEquals("verify password", txtPassword.getAttribute("value"), "hijava");

	}

	@After
	public void after() {
		Date date = new Date();
		System.out.println(date);

	}

	@AfterClass
	public static void afterClass() {
		driver.close();
	}
}
