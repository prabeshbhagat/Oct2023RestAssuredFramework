package com.qa.gorest.tests;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.pojo.User;
import com.qa.gorest.pojo.User04;
import com.qa.gorest.utils.StringUtils;

public class CreateUserTest extends BaseTest {
	

	/* 
	 * used in S1 ,comment in S2
	 * RestClient restClient= new RestClient(); */
	
	@Test
	public void  createUserTest() {
		User user = new User( "prabesh", StringUtils.getRandomEmailId(), "male", "active");
		
//		//post call
//		RestClient restClient= new RestClient();
//		Integer user_id= restClient.post("/public/v2/users", "json", user, true)
//						.then().log().all()
//							.assertThat()
//							.statusCode(201)
//							.and()
//							.extract().path("id");
//		
//		System.out.println("User Id :"+user_id);
//		
//		
//		//get call
//		RestClient restClientGet= new RestClient();
//		restClientGet.get("/public/v2/users/"+user_id, true)
//		.then().log().all()
//		.assertThat()
//		.statusCode(200)
//		.and()
//		.body("id", equalTo(user_id));
		
		
		
		
	}
	
	

}
