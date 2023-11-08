package com.qa.gorest.tests;

import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;

public class ReqResAPITest extends BaseTest {
	
	@Test
	public void ReqResgetAllUsersTest() {
		restClient.get("/api/users?page=2",false, true)
				.then()
				.assertThat().log().all()
				.statusCode(200);	
	}
	

}
