package com.vikrant.test.framework.api.mainRunner;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vikrant.test.framework.api.pojo.Library;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MainRunner {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://demoqa.com/";
//		curl -X GET "https://demoqa.com/BookStore/v1/Books" -H "accept: application/json"
		RequestSpecification req = RestAssured.given();
		Response res = req.get("BookStore/v1/Books");
//		System.out.println(res.body().asPrettyString());
		
		Gson gson = new Gson();
		HashMap<String, String> resMap1 = gson.fromJson(res.body().asString(), HashMap.class);
		System.out.println(resMap1);
		
		Library resMap2 = gson.fromJson(res.body().asString(), Library.class);
//		System.out.println(resMap2);
		
		ObjectMapper mapper = new ObjectMapper();
		Library resMap3 = mapper.readValue(res.body().asString(), Library.class);		
//		System.out.println(resMap3);
		
		JsonPath obj = new JsonPath(res.body().asString());
		Map<String, String> m = obj.getMap("books[0]");
		System.out.println(m);
		System.out.println(obj.getList("books"));
		
		
		JsonParser parser = new JsonParser();
		JsonElement js = parser.parse(res.body().asString());
		System.out.println(js.isJsonArray());
		System.out.println(js.isJsonObject());
		JsonObject jo = js.getAsJsonObject();
		System.out.println(jo.getAsJsonArray("books"));
		
		System.out.println(jo.getAsJsonArray("books").get(0).getAsJsonObject().get("isbn"));
		
		
		
		

	}

}
