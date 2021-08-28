package com.vikrant.test.framework.runner;

import java.io.File;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class API2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File input = new File("input1.json");

		JsonPath ev = new JsonPath(input);
		List<Object> list = ev.getList("lotto.winners.numbers");
		for (Object ob : list) {
			List<Integer> num = (List) ob;
			System.out.println(num);
		}

	}

}
