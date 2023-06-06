package org.locator;

import org.libglobal.LibGlobal;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Login extends LibGlobal {

	public Login() {

		PageFactory.initElements(driver, this);
	}

	@FindBys({ @FindBy(id = "email"), @FindBy(xpath = "//input[@id='email']") })
	private WebElement txtUsername;

	@FindAll({ @FindBy(id = "pss"), @FindBy(xpath = "//input[@id='pass']") })
	private WebElement txtPassword;

	
	public WebElement getTxtUsername() {
		return txtUsername;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public void loginPage(String username, String password) {
		WebElement txtUsername2 = getTxtUsername();
		typeText(txtUsername2, username);

		WebElement txtPassword2 = getTxtPassword();
		typeText(txtPassword2, password);

	}

}
