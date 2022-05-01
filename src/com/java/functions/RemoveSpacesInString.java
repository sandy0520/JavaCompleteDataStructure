package com.java.functions;

import java.util.function.Function;

public class RemoveSpacesInString {

	public static void main(String[] args) {
		
		String s = "How are you sandy?";
		
		Function<String,String> fun = str -> str.replaceAll(" ","");
		
		System.out.println(fun.apply(s));
		
		//Write a function to count number of spaces in the String		
		Function<String, Integer> f = s1 -> s1.length() - s1.replaceAll(" ","").length();
		System.out.println(f.apply(s));
		
	}
}
