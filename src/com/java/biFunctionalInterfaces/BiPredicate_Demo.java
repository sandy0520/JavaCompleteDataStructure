package com.java.biFunctionalInterfaces;

import java.util.function.BiPredicate;

public class BiPredicate_Demo {

	public static void main(String[] args) {
		
		//Write a bi-predicate to check if sum of 2numbers is odd or even
		
		BiPredicate<Integer,Integer> p = (a,b)-> ((a+b)%2)==0;
		
		System.out.println(p.test(10, 30));
		System.out.println(p.test(10, 35));
	}
}
