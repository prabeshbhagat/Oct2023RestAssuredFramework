package com.qa.gorest.client;

import java.util.Map;
import java.util.Properties;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.qa.gorest.frameworkException.ApiFrameworkException;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient{

	private static RequestSpecBuilder specBuilder;
	
	/*
	 * used in s1 ,comment in s2
	 * private static final String BASE_URI = "https://gorest.co.in/"; private
	 * static final String BEARER_TOKEN =
	 * "d4176ed674fe764cb7b27dbf32d481b4fb0c8b4b0721a2aa12583d0d60c3d26b";
	 */
	
	/*
	 * used in s1 ,comment in s2
	 * static { specBuilder = new RequestSpecBuilder(); }
	 */
	
	
	//added in s2
	private Properties prop;
	private String baseURI;
	
	//added in s2
	public RestClient(Properties prop,String baseURI) {
		specBuilder = new RequestSpecBuilder();
		this.prop=prop;
		this.baseURI=baseURI;
	}
	
	
	
	private  void addAuthrizationHeader() {
		//bareare token code added in s2
		specBuilder.addHeader("Authorization", "Bearer " +prop.getProperty("tokenId"));
	}

	

	private void setRequestContentType(String contentType) {
		switch (contentType.toLowerCase()) {
		case "json":
			specBuilder.setContentType(ContentType.JSON);
			break;
		case "xml":
			specBuilder.setContentType(ContentType.XML);
			break;
		case "text":
			specBuilder.setContentType(ContentType.TEXT);
			break;
		case "multipart":
			specBuilder.setContentType(ContentType.MULTIPART);
			break;
		default:
			System.out.println("Please pass the corect contentType");
			throw new ApiFrameworkException("INVALIDCONTENTTYPE");

		}

	}

	private RequestSpecification createRequestSpec(boolean includeAuth) {
		specBuilder.setBaseUri(baseURI);
		if(includeAuth) {addAuthrizationHeader();}
		return specBuilder.build();
	}

	private RequestSpecification createRequestSpec(Map<String, String> headersMap,boolean includeAuth) {
		specBuilder.setBaseUri(baseURI);
		if(includeAuth) {addAuthrizationHeader();}
		if (headersMap != null) {
			specBuilder.addHeaders(headersMap);
		}
		return specBuilder.build();
	}

	private RequestSpecification createRequestSpec(Map<String, String> headersMap, Map<String, String> querParamsMap,boolean includeAuth) {
		specBuilder.setBaseUri(baseURI);
		if(includeAuth) {addAuthrizationHeader();}
		if (headersMap != null) {
			specBuilder.addHeaders(headersMap);
		}
		if (querParamsMap != null) {
			specBuilder.addQueryParams(querParamsMap);
		}
		return specBuilder.build();

	}

	private RequestSpecification createRequestSpec(Object requestBody, String contentType,boolean includeAuth) {
		specBuilder.setBaseUri(baseURI);
		if(includeAuth) {addAuthrizationHeader();}
		if (requestBody != null) {
			specBuilder.setBody(requestBody);
		}
		setRequestContentType(contentType);
		return specBuilder.build();
	}

	private RequestSpecification createRequestSpec(Object requestBody, String contentType,
			Map<String, String> headersMap,boolean includeAuth) {
		specBuilder.setBaseUri(baseURI);
		if(includeAuth) {addAuthrizationHeader();}
		if (headersMap != null) {
			specBuilder.addHeaders(headersMap);
		}
		if (requestBody != null) {
			specBuilder.setBody(requestBody);
		}
		setRequestContentType(contentType);
		return specBuilder.build();

	}

	// Http method Utils
	public Response get(String serviceUrl,boolean includeAuth, boolean log) {
		if (log) {
			 return RestAssured.given(createRequestSpec(includeAuth)).log().all()
			.when().
			get(serviceUrl);
		}
		return RestAssured.given(createRequestSpec(includeAuth))
		.when().
		get(serviceUrl);
	}
	
	public Response get(String serviceUrl,Map<String,String> headersMap,boolean includeAuth, boolean log) {
		if (log) {
			 return RestAssured.given(createRequestSpec(headersMap,includeAuth)).log().all()
			.when().
				get(serviceUrl);
		}
		return RestAssured.given(createRequestSpec(headersMap,includeAuth)).log().all()
		.when().
			get(serviceUrl);
	}
	
	public Response get(String serviceUrl,Map<String,String> headersMap,Map<String, String> queryParamsMap,
			boolean includeAuth,boolean log) {
		if (log) {
			 return RestAssured.given(createRequestSpec(headersMap, queryParamsMap,includeAuth)).log().all()
			.when().
				get(serviceUrl);
		}
		return RestAssured.given(createRequestSpec(headersMap, queryParamsMap,includeAuth)).log().all()
		.when().
			get(serviceUrl);
	}
	
	//post call
	public Response post(String serviceUrl,String contentType,Object requestBody,Map<String,String> headersMap,
			boolean includeAuth,boolean responseLog) {
		 if (responseLog) {
			 return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap,includeAuth)).log().all()
						.when()
						.post(serviceUrl);
		}
		 return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap,includeAuth))
					.when()
					.post(serviceUrl);
	
	}
	
	public Response post(String serviceUrl,String contentType,Object requestBody,
			boolean includeAuth,boolean log) {
		 if (log) {
			 return RestAssured.given(createRequestSpec(requestBody, contentType,includeAuth)).log().all()
						.when()
						.post(serviceUrl);
		}
		 return RestAssured.given(createRequestSpec(requestBody, contentType,includeAuth))
					.when()
					.post(serviceUrl);
	
	}
	
	//put call
		public Response put(String serviceUrl,String contentType,Object requestBody,Map<String,String> headersMap,boolean includeAuth,boolean log) {
			 if (log) {
				 return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap,includeAuth)).log().all()
							.when()
							.put(serviceUrl);
			}
			 return RestAssured.given(createRequestSpec(requestBody, contentType, headersMap,includeAuth))
						.when()
						.put(serviceUrl);
		
		}
		
		public Response put(String serviceUrl,String contentType,Object requestBody,boolean includeAuth,boolean log) {
			 if (log) {
				 return RestAssured.given(createRequestSpec(requestBody, contentType,includeAuth)).log().all()
							.when()
							.put(serviceUrl);
			}
			 return RestAssured.given(createRequestSpec(requestBody, contentType,includeAuth))
						.when()
						.put(serviceUrl);
		
		}
		
		//delete call
		
		public void delete(String serviceUrl,boolean includeAuth,boolean log) {
			if(log) {
				RestAssured.given(createRequestSpec(includeAuth)).log().all()
				.when()
				.delete(serviceUrl);
			}
			RestAssured.given(createRequestSpec(includeAuth))
			.when()
			.delete(serviceUrl);
		}
		

}