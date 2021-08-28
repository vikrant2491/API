package com.vikrant.test.framework.api.action;

import java.awt.image.BufferedImageFilter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIAction {

	public static boolean createRequest(String request) throws Exception{
		
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification req = RestAssured.given();
		Response res = req.get();
		
		System.out.println(res.getStatusCode());
		System.out.println(res.body().asPrettyString());
		File file = new File("result.json");
		FileWriter writer = new FileWriter(file);
		BufferedWriter buffer = new BufferedWriter(writer);
		buffer.write(res.body().asPrettyString());
		buffer.flush();
		buffer.close();
		return true;
	}

	public static boolean verifyJson() throws Exception{
		JsonPath jsonPathEvaluator = new JsonPath(new File("result.json"));
		System.out.println();
		
		return true;
	}
	
	

}
