package com.qa.gorest.base;

import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.gorest.client.RestClient;
import com.qa.gorest.configurations.ConfigurationManager;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

public class BaseTest {
	
	//s3
	public static final String GOREST_ENDPOINT="/public/v2/users";
	public static final String REQRES_ENDPOINT="/api/users";
	public static final String CIRCUIT_ENDPOINT="/api/f1";
	public static final String ACCESS_TOKEN_ENDPOINT="v1/security/oauth2/token";
	public static final String FLIGHTBOOKING_ENDPOINT="/v1/shopping/flight-destinations";
	public static final String FAKESTOREAPI_ENDPOINT="/products";
	
	
	//s2
	protected ConfigurationManager config;
	protected Properties prop;
	protected RestClient restClient;
	protected String baseURI;
	
	
	@Parameters({"baseURI"})
	@BeforeTest
	public void setUp(String baseURI ) {
		
		RestAssured.filters(new AllureRestAssured());//allure report
		
		config= new ConfigurationManager();
		prop=config.initProp();
		this.baseURI=baseURI;
		//restClient= new RestClient(prop, baseURI);
		System.out.println(baseURI);
		

	}

}
