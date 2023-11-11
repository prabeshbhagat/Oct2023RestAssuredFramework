package com.qa.gorest.base;

import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.gorest.client.RestClient;
import com.qa.gorest.configurations.ConfigurationManager;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

public class BaseTest {
	
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
