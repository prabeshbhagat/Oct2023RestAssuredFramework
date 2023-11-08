package com.qa.gorest.tests;

import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;

public class circuitTest extends BaseTest {
	
	
	@Test
	public void getAllCircuitTest() {
		restClient.get("/api/f1/2019/circuits.xml", false,true)
				.then()
				.assertThat().log().all()
				.statusCode(200);	
	}
	
	

}
