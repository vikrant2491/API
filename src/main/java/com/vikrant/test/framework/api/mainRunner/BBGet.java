package com.vikrant.test.framework.api.mainRunner;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BBGet {

	public static void main(String[] args) throws Exception{
		
		RestAssured.baseURI = "http://localhost:3030/";
		RequestSpecification req = RestAssured.given();
		req.queryParam("$limit", "1");
		
		Response res = req.get("products");		
		String resStr = res.getBody().asPrettyString();
		System.out.println(resStr);
		
		JsonPath ev = new JsonPath(resStr);
		
//		System.out.println(ev.getList("data[0].categories"));
//		System.out.println(ev.getMap("data[0]"));
		
		JsonParser parser = new JsonParser();
		JsonElement el = parser.parse(resStr);
//		if(el.isJsonObject()){
//			System.out.println(el.getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject().get("categories").getAsJsonArray().get(0));
//		}
		
		
//		JSONParser parser = new JSONParser();
//		Object el = parser.parse(resStr);
//		JSONObject jo = (JSONObject)el;
//		System.out.println(jo.get("total"));
//		if(jo.containsKey("data")){
//			JSONArray ja = (JSONArray) jo.get("data");
//			System.out.println(((JSONObject)ja.get(0)).get("name"));
//		}
		
//		Gson gson = new Gson();
//		JsonParser parser = new JsonParser();
//		JsonElement el = parser.parse(resStr);
//		Map<String, String> map = gson.fromJson(el.getAsJsonObject().get("data").getAsJsonArray().get(0).getAsJsonObject(), Map.class);
//		System.out.println(map.keySet());
//		String json = gson.toJson(map);
//		System.out.println(json);
		
		
//		ObjectMapper mapper = new ObjectMapper();
//		Map<String, String> map = mapper.readValue(resStr, Map.class);
//		System.out.println(map.keySet());
//		System.out.println(mapper.writeValueAsString(map));
		
		System.out.println(res.getCookies());
		System.out.println(res.headers());
		System.out.println(res.time());
		
		
		
	}

}
