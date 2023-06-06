package org.main;

import org.libglobal.LibGlobal;
import org.locator.Login;
import org.openqa.selenium.WebElement;

public class MainCLass extends LibGlobal {

	public static void main(String[] args) throws Exception {
		// create Object for parent class, why because we need to access method of paret
		// class alone

		LibGlobal global = new LibGlobal();
		global.getDriver("chrome");
		global.getUrl("https://www.facebook.com/");

		Login log = new Login();
		log.loginPage("Welcome", "Welcome welcome");

	}
}
