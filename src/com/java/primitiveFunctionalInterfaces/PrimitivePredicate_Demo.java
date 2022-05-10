package com.java.primitiveFunctionalInterfaces;

import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

public class PrimitivePredicate_Demo {

	public static void main(String[] args) {
		
		int[] numbers = {0,5,10,15,20,25};
		
		long[] longnumbers = {1212121,5565652,895787895,1478956562,999965642};
		
		double[] doublenumbers = {10.0,20.0,30.0,40.0,45.0};
		
		IntPredicate p = num->num %2==0;
		
		for(int num:numbers) {
			if(p.test(num)) System.out.println(num);
		}
		
		//Primitive versions of Predicate

		IntPredicate p1 = num->num %2==0; //For integers
		LongPredicate p2 = num->num %2==0; //For Long
		DoublePredicate p3 = num->num%2==0; //For double
		
		
		
		for(long num:longnumbers) {
			if(p2.test(num)) System.out.println(num);
		}
		
		for(double num:doublenumbers) {
			if(p3.test(num)) System.out.println(num);
		}

	}
	
	//For Function check Notes
}

