package com.vikrant.test.framework.api.mainRunner;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Api4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		getReq();
		postReq();

	}
	
	public static void getReq(){
		RestAssured.baseURI = "http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		req.pathParam("id", "43900");
		Response res = req.get("products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.timeIn(TimeUnit.SECONDS));
		System.out.println(res.contentType());
		System.out.println(res.header("content-length"));
		System.out.println(res.body().asPrettyString());		
	}
	
	public static void postReq(){
		RestAssured.baseURI="http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("name", "vikrant");
		payload.put("type", "Human");
		payload.put("price", 0);
		payload.put("shipping", 0);
		payload.put("upc", "NA");
		payload.put("description", "Human being");
		payload.put("manufacturer", "God");
		payload.put("model", "1990");
		payload.put("url", "vikrant.earth");
		payload.put("image", "NA");
		req.body(payload);
		Response res = req.post("products/");
		System.out.println(res.statusCode());
		System.out.println(res.time());
		System.out.println(res.headers());
		System.out.println(res.contentType());
		System.out.println(res.body().asPrettyString());
	}

}
