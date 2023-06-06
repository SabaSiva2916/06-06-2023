package org.libglobal;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DateUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

//This class contains only reuseable codes

public class LibGlobal {
	public static WebDriver driver;

	// 1. Browser Configuration
	public void getDriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser Name");
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	// 2.Launch Url
	public void getUrl(String url) {
		driver.get(url);

	}

	// 3.Method for sendkeys
	public void typeText(WebElement element, String data) {
		element.sendKeys(data);

	}

	// 4.Method for click
	public void btnClick(WebElement element) {
		element.click();

	}

	public WebElement locators(String locator, String value) {
		WebElement findElement = null;
		switch (locator) {
		case "id":
			findElement = driver.findElement(By.id(value));

			break;
		case "name":
			findElement = driver.findElement(By.name(value));
			break;

		case "class":
			findElement = driver.findElement(By.className(value));
			break;
		case "xpath":
			findElement = driver.findElement(By.xpath(value));
			break;
		default:
			System.out.println("Invalid Locator");
			break;
		}
		return findElement;
	}

	public void enterTextByJs(String data, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "')", element);

	}

	public void scrollWebPage(String scrollView, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		switch (scrollView) {
		case "down":
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			break;
		case "up":
			js.executeScript("arguments[0].scrollIntoView(false)", element);
		default:
			break;
		}

	}

	public void dropDown(WebElement element, String option, String data) {
		Select select = new Select(element);
		switch (option) {
		case "value":
			select.selectByValue(data);
			break;
		case "text":
			select.selectByVisibleText(data);
			break;
		case "index":
			select.selectByIndex(Integer.parseInt(data));
			break;
		default:
			break;
		}
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(source, target).perform();

	}
	
	public static void elementClick(WebElement element) throws Exception {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 10);
			wb.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
			// e.printStackTrace();
			// throw new Exception("Element is not clickable");
			elementClickUsingJS(element);
		}
	}
	
	public static void elementClickUsingJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

}
