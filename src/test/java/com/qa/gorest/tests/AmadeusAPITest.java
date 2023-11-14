package com.qa.gorest.tests;



import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.gorest.base.BaseTest;
import com.qa.gorest.client.RestClient;
import com.qa.gorest.constants.APIHttpStatus;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AmadeusAPITest extends BaseTest{
	
	private String accessToken;

	@Parameters({"baseURI","grantType","clientId","clientSecret"})
	@BeforeMethod
	public void flightSetUp(String baseURI,String grantType,String clientId,String clientSecret) {
		RestClient restClient= new RestClient(prop, baseURI);
		accessToken=restClient.getAccessToken(ACCESS_TOKEN_ENDPOINT, grantType, clientId, clientSecret);
		System.out.println("Generated Access token"+accessToken);
	}
	
	
	@Test
	public void getFlighTInfoTest() {
		RestClient restClient= new RestClient(prop, baseURI);
		
		Map<String,String> headersMap= new HashMap<String,String>();
		headersMap.put("Authorization", "Bearer "+accessToken);
		
		Map<String,Object> queryParamMap= new HashMap<String,Object>();
		queryParamMap.put("origin", "PAR");
		queryParamMap.put("maxPrice", "200");
		
		Response flisghtDataresponse= restClient.get(FLIGHTBOOKING_ENDPOINT, headersMap, queryParamMap, false, true)
		.then().log().all()
		.assertThat()
			.statusCode(APIHttpStatus.OK_200.getCode())
			.and()
			.extract().response();
	
	  JsonPath js=flisghtDataresponse.jsonPath();
	  String type=js.get("data[0].type");
	  System.out.println("type"+type);//flight destinations
	  String origin=js.get("data[0].origin");
	  System.out.println("origin"+origin);
	
	}
	
	
	

}
