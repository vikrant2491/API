package com.vikrant.test.framework.runner;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getReq();
//		postReq();
	}
	
	public static void getReq(){
		RestAssured.baseURI="http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		req.pathParam("id", 9999697);
		Response res = req.get("products/{id}");
		System.out.println(res.contentType());
		System.out.println(res.statusCode());
		System.out.println(res.time());
		System.out.println(res.headers());
		System.out.println(res.getBody().asPrettyString());
		System.out.println(res.jsonPath().getString("id"));
		
		JsonPath ev = new JsonPath(res.body().asString());
		System.out.println(ev.getList("categories"));
		
		JsonParser parser = new JsonParser();
		JsonElement elem = parser.parse(res.body().asString());
		
	}
	
	public static void postReq(){
//		9999697
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
		System.out.println(res.timeIn(TimeUnit.SECONDS));
		System.out.println(res.headers());
		System.out.println(res.getContentType());
		System.out.println(res.getHeader("content-length"));
		System.out.println(res.body().asPrettyString());
		System.out.println(res.cookies());
		String resBody = res.as(String.class);
		
	}

}
