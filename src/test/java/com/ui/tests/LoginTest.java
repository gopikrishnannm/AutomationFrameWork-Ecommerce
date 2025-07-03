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
public class LoginTest extends TestBase {
	
	
	Logger logger = LoggerUtility.getLogger(this.getClass());

	
	@Test(description="verfies login functionality", groups= {"sanity", "e2e"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
			dataProvider="LoginTestDataProvider")
	public void loginTest(User user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAdress(), user.getPassword()).getUsername(), "ema ma");
	}
	
	@Test(description="verfies login functionality with csv data", groups= {"sanity", "e2e"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
			dataProvider="LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAdress(), user.getPassword()).getUsername(), "ema ma");
	}
	
	@Test(description="verfies login functionality with excel data", groups= {"sanity", "e2e"},
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
			dataProvider="LoginTestExcelDataProvider")//retryAnalyzer=com.ui.listeners.MyRetryAnalyzer.class
	public void loginExcelTest(User user) {
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAdress(), user.getPassword()).getUsername(), "em ma");

	}
	

}
