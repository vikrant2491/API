package com.vikrant.test.framework.api.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;

import io.restassured.path.json.JsonPath;

public class GetReq {

	public static void main(String[] args) throws Exception{
		System.out.println(getArticle("epaga"));
		
	}
	
	public static List<String> getArticle(String author) throws Exception{
		List<String> articles = new ArrayList<String>();
		String content = getResult(author, 1);
		JsonPath ev = new JsonPath(content);
		int pages = Integer.valueOf(ev.getString("total_pages"));
		
		List<HashMap<String, String>> data = ev.getList("data");
		for(int j=0;j<data.size();j++){
			String title = data.get(j).get("title");
			String story_title = data.get(j).get("story_title");
			if(title!=null){
				articles.add(title);
			}else if(story_title!=null){
				articles.add(story_title);
			}					
		}
		
			for(int i=2;i<=pages;i++){
				content = getResult(author, i);
				JsonPath ev2 = new JsonPath(content.toString());
				data = ev2.getList("data");
				for(int j=0;j<data.size();j++){
					String title = data.get(i).get("title");
					String story_title = data.get(i).get("story_title");
					if(title!=null){
						articles.add(title);
					}else if(story_title!=null){
						articles.add(story_title);
					}					
				}
				
			}		
		return articles;
	}
	
	public static String getResult(String author, int pageNum){
		StringBuffer content = new StringBuffer();
		try {
			URL url = new URL("https://jsonmock.hackerrank.com/api/articles?author="+author+"&page="+pageNum);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setConnectTimeout(5000);
			con.connect();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;			
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
		} catch (Exception e) {
			
		}
		return content.toString();
		
	}

}
