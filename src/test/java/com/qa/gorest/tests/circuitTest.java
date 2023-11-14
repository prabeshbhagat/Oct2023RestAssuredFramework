package com.qa.gorest.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.jayway.jsonpath.JsonPath;
import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.constants.APIHttpStatus;
import com.qa.gorest.utils.JsonPathValidator;

import io.restassured.response.Response;

public class circuitTest extends BaseTest {

	@BeforeMethod
	public void setUp() {
		restClient = new RestClient(prop, baseURI);
	}

	@Test
	public void getAllCircuitTest() {
		restClient.get(CIRCUIT_ENDPOINT + "/2019/circuits.xml", false, true).then().assertThat().log().all()
				.statusCode(APIHttpStatus.OK_200.getCode());
	}

	// added in s4

	@Test
	public void getAllCircuitWithJsonAPthValidatorTest() {
		Response circuitResponse = restClient.get(CIRCUIT_ENDPOINT + "/2017/circuits.json", false, true);
		int statusCode = circuitResponse.statusCode();
		Assert.assertEquals(statusCode, APIHttpStatus.OK_200.getCode());

		JsonPathValidator js = new JsonPathValidator();
		List<String> countryList = js.readList(circuitResponse, "$..Circuits..country");
		System.out.println(countryList.size());
		System.out.println("countryList"+countryList);
		//Assert.assertTrue(countryList.contains("Bahrain"));
		

//				.then()
//				.assertThat().log().all()
//				.statusCode(APIHttpStatus.OK_200.getCode());	
	}

}
