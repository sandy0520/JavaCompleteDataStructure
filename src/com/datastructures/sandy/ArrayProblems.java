package com.datastructures.sandy;

public class ArrayProblems {

	public static void main(String[] args) {
		
		// Declaring and initializing an Array
		
		int[] arr = new int[5];
		
		//Inserting elements in to an array
		
		for(int i = 0; i<arr.length; i++) {
			
			arr[i]= i*2;
			
		}
		
		//Printing the elements in array
		
		for(int el : arr) {
			System.out.println(el);
		}
		
	}
}
