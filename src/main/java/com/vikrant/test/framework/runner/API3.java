package com.vikrant.test.framework.runner;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API3 {
	
	public static void main(String[] args){
		String str = "12vikr29";
		for(String s: str.split("")){
			System.out.print(s+" ");
		}
		StringBuilder chars = new StringBuilder();
		StringBuilder num = new StringBuilder();
		for(char c: str.toCharArray()){
			String c1 = String.valueOf(c);
			if(c1.matches("[0-9]")){
				num.append(c);
			}else{
				chars.append(c);
			}
			
		}
		System.out.println(chars.append(num).toString());
		
		
		
	}
	
	public static void postReq(){
		RestAssured.baseURI="";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		HashMap<String, Object> payload = new HashMap<>();
//		payload.put(key, value);
		req.body(payload);
		Response res = req.post("");
		System.out.println(res.statusCode());
		System.out.println(res.contentType());
		System.out.println(res.headers());
		System.out.println(res.getHeader("content-length"));
		System.out.println(res.timeIn(TimeUnit.SECONDS));
		System.out.println(res.body().asPrettyString());
		
		JsonPath ev = res.jsonPath();
		System.out.println(ev.getList(""));
		ev.getMap("");
		
		JsonParser parser = new JsonParser();
		JsonElement elem = parser.parse(res.body().asString());
		
		elem.getAsJsonObject().getAsJsonPrimitive("").getAsJsonArray().get(0).isJsonArray();
		
		Gson gson = new Gson();
		gson.fromJson(res.body().asString(), HashMap.class);
		gson.toJson(elem);
		
		
		
		
		
	}

}
