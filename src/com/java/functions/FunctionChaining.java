package com.java.functions;

import java.util.function.Function;

public class FunctionChaining {

	public static void main(String[] args) {
		
		//Function to convert string to upper case		
		Function<String, String> f1 = s -> s.toUpperCase();
		
		//Function to find substring of first 9 characters
		Function<String, String> f2 = str -> str.substring(0,9); //0-9 returns from 0-8. begin to end-1
		
		//Calling Functions individually		
		System.out.println(f1.apply("Sandeep Is Sad"));
		System.out.println(f2.apply("Sandeep is Sad"));
		
		//Function Chaining
		
		//andThen()
		System.out.println(f1.andThen(f2).apply("Sandeep is Sad")); // Applies f1 first and then applies f2
		
		//compose()
		System.out.println(f1.compose(f2).apply("Sandeep is Sad")); // Applies f2 first and the applies f1
		
		//Difference between andThen() and compose()
		
		Function<Integer, Integer> fun1 = i->i+i; 	//returns double of i
		Function<Integer, Integer> fun2 = i->i*i*i; //return cube of i
		
		System.out.println("andThen(): "+fun1.andThen(fun2).apply(2)); //64 -> 2+2=4 ->4*4*4= 64
		
		System.out.println("compose(): "+fun1.compose(fun2).apply(2)); //16 -> 2*2*2 = 8 -> 8+8 = 16
	}
}
