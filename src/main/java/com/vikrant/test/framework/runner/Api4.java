package com.vikrant.test.framework.runner;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedHashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.skyscreamer.jsonassert.JSONAssert;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Api4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		getReq();
//		createJson();
		
		LinkedHashMap<Object, Object> ob = new LinkedHashMap<>();
		ob.put("id", 123);
		ob.put("name", "vikrant");		
		System.out.println(ob);
		JSONObject jo = new JSONObject(ob);
		System.out.println(ob);
		System.out.println(jo.toJSONString());
		
		JsonObject go = new JsonObject();

		go.addProperty("id", "1234");
		go.addProperty("name", "vikrant");
		System.out.println(go);
		go.addProperty("id", 123);
		System.out.println(go);
		go.remove("id");
		
		JsonArray ar = new JsonArray();
		ar.add(go);
		ar.add(go);
		System.out.println(ar);
		
		
		

	}
	
	public static void getReq(){
		RestAssured.baseURI="http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		req.param("id", 43900);
		Response res = req.get("/products");
		System.out.println(res.asPrettyString());
		JsonPath ev = new JsonPath(res.body().asString());
		res.body();
		JsonSchemaValidator.matchesJsonSchemaInClasspath("");
//		Assert.assertTrue(JsonSchemaValidator.matchesJsonSchemaInClasspath(""));
		res.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(""));
	}
	
	public static void patchReq(){
		RestAssured.baseURI="";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		
	}
	
	public static void createJson(){
		JSONObject main = new JSONObject();
		main.put("id", 43900);
		main.put("name", "vikrant");
		JSONArray categories = new JSONArray();
		JSONObject elem = new JSONObject();
		elem.put("id", "B");
		elem.put("name", "Boy");
		categories.add(elem);
		elem = new JSONObject();
		elem.put("id", "M");
		elem.put("name", "Man");
		categories.add(elem);
		main.put("categories", categories);
		System.out.println(main.toString());
		
		//update
		main.put("name", "vikrant Pandey");
		System.out.println(main.toJSONString());
		elem = (JSONObject)((JSONArray)main.get("categories")).get(0);
		elem.put("id", "Bs");
		
		System.out.println(main.toString());
		
		//Delete
		elem.remove("id");
		((JSONArray)main.get("categories")).remove(1);
		
		System.out.println(main);
		
		
	}

}
