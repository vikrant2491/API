package com.vikrant.test.framework.api.mainRunner;

import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.http.conn.ssl.SSLSocketFactory;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API6 {

	public static void main(String[] args) throws Exception{
//		getReq();
//		postReq();
//		putReq();
//		patchreq();
		deleteReq();
		getReq();

	}
	
	public static void getReq() throws Exception{
		String password = "";
		RestAssured.baseURI="http://localhost:3030";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		KeyStore key = KeyStore.getInstance("PKCS12");
		key.load(new FileInputStream(new File("")), password.toCharArray());
		SSLSocketFactory socket = new SSLSocketFactory(key, password);
		SSLConfig config = new SSLConfig().with().sslSocketFactory(socket).and().allowAllHostnames();
		req.config(RestAssured.config.sslConfig(config));
		req.pathParam("id", 9999700);
//		req.queryParam("id", 9999699);
		Response res = req.get("/products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.contentType());
		System.out.println(res.header("content-length"));
		System.out.println(res.headers());
		System.out.println(res.getCookies());
		System.out.println(res.timeIn(TimeUnit.SECONDS));
		System.out.println(res.asPrettyString());
	}
	
	public static void postReq(){
//		9999700
		RestAssured.baseURI="http://localhost:3030";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("name", "vikranta");
		payload.put("type", "Humana");
		payload.put("price", 00);
		payload.put("shipping", 00);
		payload.put("upc", "NA");
		payload.put("description", "Humana being");
		payload.put("manufacturer", "God");
		payload.put("model", "1990");
		payload.put("url", "vikrant.earth");
		payload.put("image", "NA");
		
		req.body(payload);
		Response res = req.post("products/");
		System.out.println(res.statusCode());
		System.out.println(res.timeIn(TimeUnit.SECONDS));
		System.out.println(res.contentType());
		System.out.println(res.header("content-length"));
		System.out.println(res.getDetailedCookies());
		System.out.println(res.headers());
		System.out.println(res.asPrettyString());
	}
	
	public static void putReq(){
		RestAssured.baseURI="http://localhost:3030";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("name", "vikranta1");
		payload.put("type", "Humana1");
		payload.put("price", 00);
		payload.put("shipping", 00);
		payload.put("upc", "NA");
		payload.put("description", "Humana being");
		payload.put("manufacturer", "God");
		payload.put("model", "1990");
		payload.put("url", "vikrant.earth");
		payload.put("image", "NA");
		req.body(payload);
		req.pathParam("id", 9999700);
		Response res = req.put("products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.contentType());
		System.out.println(res.timeIn(TimeUnit.SECONDS));
		System.out.println(res.header("content-length"));
		System.out.println(res.headers());
		System.out.println(res.cookies());
		System.out.println(res.asPrettyString());
	}
	
	public static void patchreq(){
		RestAssured.baseURI="http://localhost:3030";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		
		HashMap<String, Object> payload = new HashMap<>();
		payload.put("name", "Vikranta007");
		payload.put("type", "Humana007");
		req.body(payload);
		req.pathParam("id", 9999700);
		Response res = req.patch("products/{id}");
		System.out.println(res.asPrettyString());
		
	}
	
	public static void deleteReq(){
		RestAssured.baseURI="http://localhost:3030";
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.relaxedHTTPSValidation();
		req.pathParam("id", 9999700);
		Response res = req.delete("products/{id}");
		System.out.println(res.statusCode());
		System.out.println(res.contentType());
		System.out.println(res.timeIn(TimeUnit.SECONDS));
		System.out.println(res.headers());
		System.out.println(res.cookies());
		System.out.println(res.body().asPrettyString());
	}

}
