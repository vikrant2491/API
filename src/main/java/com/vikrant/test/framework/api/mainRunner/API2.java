package com.vikrant.test.framework.api.mainRunner;

import java.text.ParseException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		getReq();
//		ETag=W/"113-1ABzyjpCILlIhgQljiq92iMRgCE"
//		postReq();
//		putReq();
//		patchReq();
//		deleteReq();
//		headReq();
//		getReq();
		parseResponse();

	}
	
	public static String getReq(){
		RestAssured.baseURI = "http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
//		req.queryParam("id", 43900);
//		req.param("id", 43900);
		req.pathParam("id", 43900);
		
		Response res = req.get("products/{id}");
//		System.out.println("Status code "+res.statusCode());
//		System.out.println("Time "+res.timeIn(TimeUnit.SECONDS));
//		System.out.println("Headers are: "+res.headers());
//		System.out.println("Cookies "+res.cookies());
//		System.out.println(res.contentType());		
//		
//		System.out.println("Response "+res);
//		System.out.println("Response as hashmap "+res.as(HashMap.class));
//		System.out.println("Response as pretty string "+res.body().asPrettyString());
		
		return res.body().asPrettyString();
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
//		payload.put("shipping", 0);
		payload.put("upc", "NA");
		payload.put("description", "Human being");
//		payload.put("manufacturer", "God");
		payload.put("model", "1990");
		payload.put("url", "vikrant.earth");
		payload.put("image", "NA");
		req.body(payload);
		Response res = req.post("products");
//		9999687
		System.out.println(res.statusCode());
		System.out.println(res.contentType());
		System.out.println(res.time());
		System.out.println(res.getHeader("content-length"));
		System.out.println(res.body().asPrettyString());
		
	}
	
	public static void putReq(){
		RestAssured.baseURI="http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("name", "vikrant90");
		payload.put("type", "Humanbeing");
		payload.put("price", 0);
		payload.put("shipping", 0);
		payload.put("upc", "NA");
		payload.put("description", "Human being");
		payload.put("manufacturer", "God");
		payload.put("model", "1990");
		payload.put("url", "vikrant.earth");
		payload.put("image", "NA");
		req.pathParam("id", 9999690);
		
		req.body(payload);
		Response res = req.put("products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.contentType());
		System.out.println(res.header("content-length"));
		System.out.println(res.time());
		System.out.println(res.body().asPrettyString());
		System.out.println(res.cookies());
		
	}
	
	public static void patchReq(){
		RestAssured.baseURI="http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("name", "vikrant1");
		payload.put("type", "HumanOnly");
		
		req.body(payload);
		
		req.pathParam("id", 9999690);
		Response res = req.patch("products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.body().asPrettyString());
	}
	
	public static void deleteReq(){
		RestAssured.baseURI="http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		req.pathParam("id", 9999687);
		Response res = req.delete("products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.body().asString());
		
	}
	
	public static void headReq(){
		RestAssured.baseURI="http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		req.pathParam("id", 9999690);
		Response res = req.head("products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.body().asString());
		System.out.println(res.headers());
	}
	
	public static void parseResponse() throws Exception{
		String res = getReq();
		System.out.println(res);
		
		JsonPath ev = new JsonPath(res);
		System.out.println(ev.getList("categories"));
		System.out.println(ev.getMap("categories[0]"));
		
		JsonParser parser = new JsonParser();
		JsonElement elem = parser.parse(res);
		
		
		System.out.println(elem.isJsonArray());
		System.out.println(elem.isJsonObject());
		System.out.println(elem.getAsJsonObject().getAsJsonPrimitive("price").getAsNumber());
		System.out.println(elem.getAsJsonObject().getAsJsonArray("categories").get(2));
		
		JSONParser parse = new JSONParser();
		Object ob = parse.parse(res);
		JSONObject jo = (JSONObject) ob;
		
		
		System.out.println(jo.get("categories"));
		
		System.out.println(ev.getList("categories.id"));
		System.out.println((ev.getList("categories.id")).contains("pcmcat303600050001"));
		
		
		
		
		
	}

}
