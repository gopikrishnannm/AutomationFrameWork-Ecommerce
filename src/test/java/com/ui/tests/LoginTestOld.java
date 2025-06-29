package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

//public class LoginTest {
//
//	public static void main(String[] args) {
//		
//		WebDriver wd = new ChromeDriver(); // create a browser session / launch a browser tab
//		
//		
//		BrowserUtility browserUtility = new BrowserUtility(wd);
//		browserUtility.goToWebsite("http://www.automationpractice.pl/index.php?");
//		browserUtility.maximizeWindow();
//		
//		By signInLinkLocator = By.xpath("//a[contains(text(),'Sign in')]");
//		browserUtility.clickOn(signInLinkLocator);
//
//		
//		By emailTextBoxLocator = By.id("email");
//		browserUtility.enterText(emailTextBoxLocator, "abc");
//
//		By passwordTextBoxLocator = By.id("passwd");
//		browserUtility.enterText(passwordTextBoxLocator, "abc");
//		
//		By submitLoginButtonLocator = By.id("SubmitLogin");
//		browserUtility.clickOn(submitLoginButtonLocator);
//		
//
//	}
//
//}
