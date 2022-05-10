package com.java.biFunctionalInterfaces;

import java.util.function.BiConsumer;

public class BiConsumer_Demo {

	public static void main(String[] args) {
		
		BiConsumer<String ,String> s = (s1, s2)->System.out.println(s1+s2);
		
		s.accept("Sandy","GR");
	}
}
