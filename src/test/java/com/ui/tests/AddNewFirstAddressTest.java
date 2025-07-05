package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase{
	
	
	private MyAccountPage myAccountPage;
	private AddressPOJO address;

	@BeforeMethod(description="Valid first user log in to application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("ximoyi2745@ethsms.com", "password");
		address = FakeAddressUtility.getFakeAddress();
		
	}
	
	@Test
	public void addNewAddress() {
		Assert.assertEquals(myAccountPage.goToAddAddressPage().saveAddress(address), address.getAddressAlias().toUpperCase());
	}
}
