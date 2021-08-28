package com.vikrant.test.framework.api.mainRunner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FinalClass {
	
	public void display() throws Exception{
		Class c = this.getClass();
		for(Field field : c.getDeclaredFields()){
			String var = field.getName();
			System.out.println(var);
			System.out.println();
		}
		
		for(Method m: c.getDeclaredMethods()){
			if(m.getName().startsWith("get")){
				
				System.out.println(m.invoke(this, null));
			}
		}
	}

}
