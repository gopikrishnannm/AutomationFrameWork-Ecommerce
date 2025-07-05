package com.utility;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {
	
	public static void main(String[] args) {
		getFakeAddress();
	}

	public static AddressPOJO getFakeAddress() {
		Faker faker = new Faker();
		
		AddressPOJO addressPOJO = new AddressPOJO(faker.company().name(), faker.address().buildingNumber(), faker.address().streetAddress(), 
				faker.address().city(), faker.numerify("#####"), faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "other", 
				"office address", faker.address().state());
		
		return addressPOJO;
	}

}
