package com.vikrant.test.framework.api.mainRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.restassured.path.json.JsonPath;

public class JSONCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		create();
	}
	
	public static JSONObject create(){
		JSONObject jo = new JSONObject();
		jo.put("id", 123);
		jo.put("name", "vikrant");
		
		JSONObject jo1 = new JSONObject();
		jo1.put("id", 123);
		jo1.put("name", "vikrant");
		
		JSONArray ja = new JSONArray();
		ja.add(jo1);
		jo.put("array", ja);
		
		System.out.println(jo.toString());
		return jo;
	}
	
	public static void update(JSONObject jo) throws Exception{
		JSONParser parser = new JSONParser();
		Object on = parser.parse("");
		
		JsonPath ev = new JsonPath("");
		List<String> ls = ev.getList("");
		
		Gson hson = new Gson();
		
		JsonParser p = new JsonParser();
		JsonElement elem = p.parse("");
		elem.isJsonObject();
		elem.getAsJsonObject().getAsJsonArray("").getAsJsonPrimitive().getAsDouble();
		
	}

}
