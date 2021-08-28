package com.vikrant.test.framework.api.mainRunner;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.skyscreamer.jsonassert.JSONAssert;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API1 {

	public static void main(String[] args) {
		String resBody = getReq();
//		postReq();
//		putReq();
//		patchReq();
//		deleteReq();
		
		hMap(resBody);
		
		
	}
	
	public static String getReq(){
		RestAssured.baseURI="http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
//		req.param("id", "43900");
//		req.queryParam("id", 43900);
		req.pathParam("id", "43900");
//		req.body("{\"id\":\"43900\"}");
//		Response res = req.get("products/");
		Response res = req.get("products/{id}");
		System.out.println("status code "+res.statusCode());
		System.out.println(res.headers());
		System.out.println("content type: "+res.contentType());
		System.out.println("Cookies are: "+res.cookies());
		System.out.println(res.body().asPrettyString());
		
		return res.body().asString();
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
		Response res = req.post("products");
		//9999685
		System.out.println(res.body().asPrettyString());
		System.out.println(res.headers());
		System.out.println(res.cookies());
		System.out.println(res.contentType());
		System.out.println(res.timeIn(TimeUnit.SECONDS));
		System.out.println(res.header("content-length"));
	}
	
	public static void putReq(){
		RestAssured.baseURI = "http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		HashMap<String, Object> payload = new HashMap<>();
//		payload.put("name", "vikrant3");
//		payload.put("type", "Human");
//		payload.put("price", 0);
//		payload.put("shipping", 0);
//		payload.put("upc", "NA");
//		payload.put("description", "Human being1");
//		payload.put("manufacturer", "God");
		payload.put("model", "1991");
//		payload.put("url", "vikrant.earth");
//		payload.put("image", "NA");
		req.pathParam("id", 9999685);
		req.body(payload);
		Response res = req.put("products/{id}");
		//9999685
		System.out.println(res.body().asPrettyString());
	}
	
	public static void patchReq(){
		RestAssured.baseURI = "http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		HashMap<String, Object> payload = new HashMap<>();
//		payload.put("name", "vikrant3");
//		payload.put("type", "Human");
//		payload.put("price", 0);
//		payload.put("shipping", 0);
//		payload.put("upc", "NA");
//		payload.put("description", "Human being1");
//		payload.put("manufacturer", "God");
		payload.put("model", "1991");
//		payload.put("url", "vikrant.earth");
//		payload.put("image", "NA");
		req.pathParam("id", 9999685);
		req.body(payload);
		Response res = req.patch("products/{id}");
		//9999685
		System.out.println(res.body().asPrettyString());
	}
	
	public static void deleteReq(){
		RestAssured.baseURI = "http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		Response res = req.delete("products/{id}", 9999685);
		System.out.println(res.body().asPrettyString());
		
	}
//	hashmap
//	pojo
//	jsonpath
//	jsonparser
	
	public static void gsonParser(String res){
		JsonParser parser = new JsonParser();
		JsonElement elem = parser.parse(res);
		System.out.println(elem);
		System.out.println(elem.getAsJsonObject().getAsJsonArray("categories").get(1));
		
	}
	
	public static void hMap(String res){
		LinkedHashMap<String, String> hMap = new LinkedHashMap<>();
		Gson gson = new Gson();
		hMap = gson.fromJson(res, LinkedHashMap.class);
		System.out.println(hMap);
	}

}
