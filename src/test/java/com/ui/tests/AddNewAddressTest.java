package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;

public class AddNewAddressTest extends TestBase{
	
	
	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	private AddressPOJO address;

	@BeforeMethod(description="Valid user log in to application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("ximoyi2745@ethsms.com", "password");
		address = new AddressPOJO("company", "Address Line 1", "Address Line 2", 
				"CITY", "23456", "7548245745", "7548245745", "Random 1234", 
				"Home address", "California");
		
	}
	
	@Test
	public void addNewAddress() {
		myAccountPage.goToAddAddressPage().saveAddress(address);
	}
}
