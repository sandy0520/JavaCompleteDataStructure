package com.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Program to filter even numbers from ArrayList collection object

public class Example1 {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i= 0; i<=1000; i++) {
			list.add(i);
		}
		System.out.println(list);
		
		/*
		 * without Streams
		 * ArrayList<Integer> filteredList = new ArrayList<>();
		 * for(Integer I : list){
		 * if(I%2==0) filteredList.add(I);
		 * }
		 * System.out.println(I);
		 */
		
		//With Streams
		
		List<Integer> filteredList = list.stream().filter(I->I%2==0).collect(Collectors.toList());
		System.out.println(filteredList);
		
		//1. collect() Method
		list = (ArrayList<Integer>) list.stream().map(I->I*2).collect(Collectors.toList());
		System.out.println(list);
		
		//2. count() Method
		long count = list.stream().map(I->I*2).count(); //1001
		System.out.println(count);
		//or Directly perform on list object
		//System.out.println(list.stream().count());  /1001
		
		//3. sorted() Method DFNS order
		ArrayList<Integer> unSortedList = new ArrayList<>();
		unSortedList.add(0);
		unSortedList.add(15);
		unSortedList.add(25);
		unSortedList.add(5);
		unSortedList.add(6);
		unSortedList.add(10);
		
		System.out.println(unSortedList);
		List<Integer> sortedList = unSortedList.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		
		//sorted() method for customized sorting order (Comparator(I)) --compare method
		
		//In this case i am just reversing the ascending order using compareTo method from comparable interface
		
		List<Integer> customizedSortedList = unSortedList.stream().sorted((i1,i2)->i2.compareTo(i1)).collect(Collectors.toList());
											//or using negative symbol
		//List<Integer> customizedSortedList = unSortedList.stream().sorted((i1,i2)-> -i1.compareTo(i2)).collect(Collectors.toList());
		System.out.println(customizedSortedList);
		
		
		//4. min() method

		Integer min = unSortedList.stream().min((i1,i2)->i1.compareTo(i2)).get();
		System.out.println("Minimum Value"+ min);

		//5. max() method
		Integer max = unSortedList.stream().max((i1,i2)->i1.compareTo(i2)).get();
		System.out.println("Maximum Value"+ max);
		
		/*
		 * 5. For each method
		 * This method wont return anything
		 * This method can take lambda expression as argument and apply that lambda expression for
		 * each element present in stream
		 * Print elements present in stream
		 */
		
		ArrayList<String> names = new ArrayList<String>();
		names.add("Sandy");
		names.add("Candy");
		names.add("Randy");
		names.add("Andy");
		
		names.stream().forEach(s->System.out.println(s));
		
		//Instead of lambda expression we can use method reference as well
		
		names.stream().forEach(System.out::println);
		
		/*
		 * 6. toArray() Method
		 * To copy elements present in the stream into specified Array
		 */
		
		Integer[] Array = sortedList.stream().toArray(Integer[]::new); //Or toArray(I->new Integer[I])
		System.out.println("Elements in array");
		for(Integer ele: Array) {
			
			System.out.println(ele);
		}
		
		/*
		 * 7. Stream.of() method
		 * We can apply streams on group of values and also for arrays
		 */
		
		Stream<Integer> s = Stream.of(9,99,999,9999,99999);
		s.forEach(System.out::println);
		
		//For arrays
		Double[] d = {10.0,10.1,10.2,10.3};
		Stream s1 = Stream.of(d);
		s1.forEach(System.out::println);
		
	}
}
 