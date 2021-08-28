package com.vikrant.test.framework.api.mainRunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.skyscreamer.jsonassert.JSONAssert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.vikrant.test.framework.api.pojo.Library;

import io.restassured.path.json.JsonPath;

public class MainRunner1 {

	public static void main(String[] args) throws Exception{
//		handleUsingJsonPath();
//		handleUsingSimpleJson();
//		handleUsingGSON();
//		handleUsingJackson();
		
//		JSONAssert.assertEquals("Matched", handleUsingGSON(), handleUsingJackson(), true);
//		assertion();
		String json = "{"
				+ "\"id\": 1,"
				+ "\"name\": \"Leanne Graham\","
				+ "\"username\": \"Bret\","
				+ "\"email\": \"Sincere@april.biz\","
				+ "\"address\": {"
				+ "			\"street\": \"Kulas Light\","
				+ "		    \"suite\": \"Apt. 556\","
				+ "		    \"city\": \"Gwenborough\","
				+ "		    \"zipcode\": \"92998-3874\","
				+ "		    \"geo\": {"
				+ "			      \"lat\": \"-37.3159\","
				+ "			      \"lng\": \"81.1496\""
				+ "				    }"
				+ "			},"
				+ "\"phone\": \"1-770-736-8031 x56442\","
				+ "\"website\": \"hildegard.org\","
				+ "\"company\": {"
				+ "		    \"name\": \"Romaguera-Crona\","
				+ "    		\"catchPhrase\": \"Multi-layered client-server neural-net\","
				+ "		    \"bs\": \"harness real-time e-markets\""
				+ "		  }"
				+ "	}";

				JsonPath ev = new JsonPath(json);
				String lat = ev.get("address.geo.lat");
				System.out.println(lat);
				
				JsonParser parser = new JsonParser();
				JsonElement js = parser.parse(json);
				System.out.println(js.getAsJsonObject().getAsJsonObject("address").getAsJsonObject("geo").get("lat").getAsString());
				System.out.println(js.getAsJsonObject().get("address.geo.lat"));
//				JsonElement el = js.get("address").get("geo").get(lat);
				
	}
	
	
	
	public static void assertion() throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(new File("result.json")));
		String line;
		StringBuilder str = new StringBuilder();
		while((line=reader.readLine())!=null){
			str.append(line.trim());
		}
		System.out.println(str.toString());
		BufferedReader reader2 = new BufferedReader(new FileReader(new File("result2.json")));
		String line2;
		StringBuilder str2 = new StringBuilder();
		while((line2=reader2.readLine())!=null){
			str2.append(line2.trim());
		}
		System.out.println(str2.toString());
		JSONAssert.assertEquals("UnMatched", str.toString(), str2.toString(), true);
		
		
		reader.close();
		reader2.close();
		
	}
	
	public static void handleUsingJsonPath(){
		try{
			JsonPath evaluator = new JsonPath(new File("result.json"));
			System.out.println(evaluator.getString("books[].title"));
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void handleUsingSimpleJson(){
		try{
			JSONObject obj = new JSONObject();
			
			JSONParser parser = new JSONParser();
			Object json = parser.parse(new FileReader(new File("result.json")));
			obj = (JSONObject) json;
			JSONArray books = (JSONArray) obj.get("books");
			System.out.println(obj.get("books"));
			System.out.println(books.size());
			System.out.println(books.get(0).toString());			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String handleUsingGSON(){
		Gson gson = new Gson();
		String res = "";
		try {
			Library lib = gson.fromJson(new FileReader(new File("result.json")), Library.class);
			
			res = lib.getBooks().get(0).toString();
			System.out.println(lib.getBooks().get(0).toString());
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	public static String handleUsingJackson(){
		ObjectMapper mapper = new ObjectMapper();
		String res = "";
		try {
			Library lib = mapper.readValue(new File("result.json"), Library.class);
			res = lib.getBooks().get(0).toString();
			System.out.println(lib.getBooks().get(0).toString());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

}
