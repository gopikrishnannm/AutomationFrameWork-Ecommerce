package com.ui.pages;

import static com.constants.Env.QA;
import static com.utility.JSONUtility.readJSON;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
import com.utility.PropertiesUtil;

public class HomePage extends BrowserUtility{
	
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	
	public HomePage(Browser browser, boolean isHeadless) {
		super(browser, isHeadless);
		goToWebsite(PropertiesUtil.readProperty(QA, "URL"));
		//goToWebsite(readJSON(QA).getUrl());
		maximizeWindow();
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
//		goToWebsite(readProperty(QA, "URL"));
		goToWebsite(readJSON(QA).getUrl());
		maximizeWindow();
	}
	
	public LoginPage goToLoginPage() {
		logger.info("Trying to perform click to go to sign in page");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	

	

}
