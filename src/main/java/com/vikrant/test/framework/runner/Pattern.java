package com.vikrant.test.framework.runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "abcabcabceeeeeee";
//		String p = "beca";
//		format(s, p);
//		output :  bbbeeeeeeecccaaa
//		System.out.println("strawberries".substring(2, 5));
		System.out.println("Nifty" instanceof String);
		List<Boolean> arr = new ArrayList<Boolean>();
		arr.add(Boolean.parseBoolean("FalSe"));
		System.out.println(arr);
//		main(null);
		String a = "Hello World!";
		System.out.println(a.substring(6, 12)+a.substring(12, 6));

	}
	
	public static void format(String str, String pattern){
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		for(int i=0;i<str.length();i++){
			if(freq.containsKey(str.charAt(i))){
				freq.put(str.charAt(i), freq.get(str.charAt(i))+1);
			}else{
				freq.put(str.charAt(i), 1);
			}
		}
		
		for(int i=0;i<pattern.length();i++){
			int times = freq.get(pattern.charAt(i));
			while(times>0){
				System.out.print(pattern.charAt(i));
				times--;
			}
		}
		
	}

}
