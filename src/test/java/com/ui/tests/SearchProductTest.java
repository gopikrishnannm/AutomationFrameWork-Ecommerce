package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

public class SearchProductTest extends TestBase{
	
	MyAccountPage myAccountPage;
	private static final String SEARCH_TERM="Printed Summer Dress";
	
	@BeforeMethod(description="Valid user log in to application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("ximoyi2745@ethsms.com", "password");
	}
	
	@Test(description="verify if logged in user is able to search for a product and correct products search results are displayed"
			, groups= {"e2e","smoke","sanity"})
	public void verifyProductSearchTest() {
		boolean actualResult = myAccountPage.searchForAProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}

}
