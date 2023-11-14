package com.qa.gorest.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.pojo.Products;

public class CreateFakeStoreTest extends BaseTest {
	
	
	@BeforeMethod
	public void setUp() {
		restClient= new RestClient(prop, baseURI);
	}
	
	@Test
	public void createProducsttest() {
		
		Products product =new Products("Products title01", 14, "lorem ipsum set", "https://i.pravatar.cc", "electronic");
		restClient.post(FAKESTOREAPI_ENDPOINT, "json", product, false, true)
		.then().log().all()
		.assertThat()
		.statusCode(200);
	}

}
