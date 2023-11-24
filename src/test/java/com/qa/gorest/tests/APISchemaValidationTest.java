package com.qa.gorest.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.constants.APIHttpStatus;
import com.qa.gorest.pojo.User;
import com.qa.gorest.utils.StringUtils;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class APISchemaValidationTest extends BaseTest {

	/*
	 * added in s3
	 */
	@BeforeMethod
	public void setUp() {
		restClient = new RestClient(prop, baseURI);
	}  
	//CODE ADDED IN S5
		//Schema valdiation
		@Test()
		public void createUserAPiSchemaTest() {
			User user = new User("tom", StringUtils.getRandomEmailId(), "male", "active");

			// post call
			// comment in s3
			// RestClient restClient= new RestClient(prop, baseURI);
			restClient.post(GOREST_ENDPOINT, "json", user, true, true)
			.then().log().all()
			.assertThat()
			.statusCode(APIHttpStatus.CREATED_201.getCode())
			.body(matchesJsonSchemaInClasspath("createuserschema.json"));


		}

}
