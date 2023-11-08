package com.qa.gorest.tests;

import org.testng.annotations.Test;


import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class GetUserTest extends BaseTest {
	
	
	
	@Test(enabled=true,priority=1)
	public void getAllUsersTest() {
		
		restClient.get("/public/v2/users",true, true)
				.then()
				.assertThat().log().all()
				.statusCode(200);	
	}
	
	
//	@Test(priority=2)
//	public void getSingleUSerTest() {
//		restClient.get("/public/v2/users/5685539", true)
//				.then()
//				.assertThat().log().all()
//				.statusCode(200)
//				.and()
//				.body("id", equalTo(5685539));
//				
//		
//	}
//	
//	@Test
//	public void getUserWithQueryParamTest() {
//		
//		Map<String,String> qMap= new HashMap<String,String>();
//		qMap.put("name", "Dron");
//		qMap.put("status", "active");
//		
//		restClient.get("/public/v2/users", null, qMap, true)
//				.then()
//				.assertThat().log().all()
//				.statusCode(200);
//				
//				
//		
//	}
	
	
	

}
