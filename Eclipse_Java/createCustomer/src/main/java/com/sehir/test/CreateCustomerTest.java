package com.sehir.test;

import com.sehir.services.CustomerService;

import sehir.com.model.RequestCustomer;

public class CreateCustomerTest {


	public static void main(String[] args) {
		CustomerService service = new CustomerService();
		RequestCustomer request = new RequestCustomer();
		request.setName("Murat");
		request.setSurname("Polat");
		request.setCity("istanbul");
		service.createCustomer(request);
	}

}
