package com.ui.tests;

import static com.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;


@Listeners({com.ui.listeners.TestListener.class})
public class InvalidCredLoginTest extends TestBase {
	
	
	Logger logger = LoggerUtility.getLogger(this.getClass()); 
	private static final String INVALID_EMAIL_ADDRESS = "ximoyi2745@ethsms.com";
	private static final String INVALID_PASSWORD = "password";

	
	@Test(description="verfies if the proper message is shown for the user when they enter invalid credentials", groups= {"sanity", "e2e"})

	public void loginTest() {
		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD).getErrorMessage(), "Authentication failed.");
	}
	
	

}
