package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.HomePage;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase{
	
	private static final String SEARCH_TERM = "printed summer dress";
	private SearchResultPage searchResultPage;
	
	@BeforeMethod(description="User logs into the application and searches the product")	
	public void setup() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("ximoyi2745@ethsms.com", "password").searchForAProduct(SEARCH_TERM);
	}

	@Test(description="verify if the logged in user is able to buy a dress", groups= {"e2e","smoke"})
	public void checkOutTest() {
		String data = searchResultPage.clickOnTheProductAtIndex(2).changeSize(L)
		.addProductToCart().proceedToCheckout().goToConfirmAddressPage()
		.goToShipmentPage().goToPaymentPage().PaymentByWire();
		
		Assert.assertTrue(data.contains("complete"));
	}
}
