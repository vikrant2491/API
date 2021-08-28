package com.vikrant.test.framework.api.mainRunner;

import java.util.HashMap;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API3 {
	
	public static void main(String[] args){
//		postReq();
		
		putReq();
		patchReq();
		getReq();
	}
	
	public static void getReq(){
		RestAssured.baseURI = "http://localhost:3030";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		req.pathParam("id", 9999692);
		Response res = req.get("/products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.headers());
		System.out.println(res.cookies());
		System.out.println(res.body().asPrettyString());
	}
	
	public static void postReq(){
		RestAssured.baseURI = "http://localhost:3030";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		Product payload = new Product();
		payload.setName("Pandey");
		payload.setType("Human");
		payload.setPrice("101");
		payload.setShipping(0.0);
		payload.setUpc("None");
		payload.setManufacturer("God");
		payload.setModel("1990");
		payload.setDescription("indian breed");
		payload.setUrl("here.now");
		payload.setImage("Not found");
		
		req.body(payload);
		Response res = req.post("/products");
		System.out.println(res.statusCode());
		System.out.println(res.headers());
		System.out.println(res.contentType());
		System.out.println(res.header("content-length"));
		System.out.println(res.body().asPrettyString());
	}
	
	public static void putReq(){
		RestAssured.baseURI="http://localhost:3030";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		Product payload = new Product();
		payload.setName("Pandey1");
		payload.setType("Human1");
		payload.setPrice("100");
		payload.setShipping(1.0);
		payload.setUpc("None1");
		payload.setManufacturer("God");
		payload.setModel("1991");
		payload.setDescription("indian breed 1");
		payload.setUrl("here1.now");
		payload.setImage("Not found1");
		
		req.pathParam("id", 9999692);
		req.body(payload);
		Response res = req.put("/products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.contentType());
		System.out.println(res.header("content-length"));
		System.out.println(res.headers());
		System.out.println(res.body().asPrettyString());
		
	}
	
	public static void patchReq(){
		RestAssured.baseURI="http://localhost:3030";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		req.pathParam("id", 9999692);
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("name", "Vikrant Pandey");
		payload.put("type", "humanOnly");
//		Product payload = new Product();
//		payload.setName("Vikrant Pandey");
//		payload.setType("HumanOnly");
		req.body(payload);
		Response res = req.patch("products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.header("content-length"));
		System.out.println(res.headers());
		System.out.println(res.body().asPrettyString());
		
	}

}
