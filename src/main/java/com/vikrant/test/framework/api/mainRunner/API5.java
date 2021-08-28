package com.vikrant.test.framework.api.mainRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API5 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		getReq();
//		postReq();
//		putReq();
//		patchReq(); 
//		headReq();
//		deleteReq();
	}
	public static void getReq() throws Exception{
		RestAssured.baseURI="http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		req.queryParam("id", 9999699);
		Response res = req.get("products/");
		System.out.println(res.statusCode());
		System.out.println(res.time());
		System.out.println(res.headers());
		System.out.println(res.contentType());
		System.out.println(res.body().asPrettyString());
		System.out.println(res.cookies());
		
		JsonPath ev = res.body().jsonPath();
		System.out.println(ev.getInt("total"));
		System.out.println(ev.getList("data.categories"));
		System.out.println(ev.getMap("data[0]"));
		
		JsonParser parser = new JsonParser();
		JsonElement elem = parser.parse(res.body().asString());
		JsonObject jo = elem.getAsJsonObject();
		System.out.println(elem.isJsonObject());
		System.out.println(jo.getAsJsonArray("data").get(0).getAsJsonObject().getAsJsonPrimitive("id").getAsString());
		
		JSONParser parser1 = new JSONParser();
		Object ob = parser1.parse(res.body().asString());
		JSONObject jo1 = (JSONObject) ob;
		System.out.println(jo1.get("id"));
		System.out.println(((JSONArray)jo1.get("data")));
		
		Gson gson = new Gson();
		System.out.println(gson.fromJson(res.body().asString(), HashMap.class));
		String jsonStr = gson.toJson(elem);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.readValue(res.body().asString(), HashMap.class);
		
		System.out.println(jsonStr);
		
	}
	
	public static void postReq(){
//		9999698
		RestAssured.baseURI="http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		Map<String, Object> payload = new HashMap<>();
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
		System.out.println(res.headers());
		System.out.println(res.header("content-length"));
		System.out.println(res.timeIn(TimeUnit.SECONDS));
		System.out.println(res.cookies());
		System.out.println(res.body().asPrettyString());		
	}
	
	public static void putReq(){
		RestAssured.baseURI="http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		req.pathParam("id", 9999698);
		Map<String, Object> payload = new HashMap<>();
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
		Response res = req.put("products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.timeIn(TimeUnit.SECONDS));
		System.out.println(res.headers());
		System.out.println(res.contentType());
		System.out.println(res.cookies());
		System.out.println(res.getHeader("content-length"));
		System.out.println(res.body().asPrettyString());
	}
	
	public static void patchReq(){
		RestAssured.baseURI = "http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		Map<String, Object> payload = new HashMap<>();
		payload.put("name", "vikrant007");
		payload.put("type", "Human007");
		req.body(payload);
		req.pathParam("id", 9999698);
		Response res = req.patch("products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.timeIn(TimeUnit.SECONDS));
		System.out.println(res.contentType());
		System.out.println(res.headers());
		System.out.println(res.cookies());
		System.out.println(res.asPrettyString());
		System.out.println(res.getHeader("Content-Length"));
	}
	
	public static void headReq(){
		RestAssured.baseURI="http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		req.pathParam("id", 9999698);
		Response res = req.head("products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.headers());		
		System.out.println(res.asPrettyString());
	}
	
	public static void deleteReq(){
		RestAssured.baseURI="http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		req.pathParam("id", 9999698);
		Response res = req.delete("products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.headers());
		System.out.println(res.time());
		System.out.println(res.contentType());
		System.out.println(res.cookies());
		System.out.println(res.getHeader("content-length"));
		System.out.println(res.asPrettyString());
	}

}
