package com.java.biFunctionalInterfaces;

import java.util.ArrayList;
import java.util.function.BiFunction;

class Student{
	
	String name;
	int rollno;
	
	Student(String name, int rollno){
		this.name = name;
		this.rollno = rollno;
	}
}
public class BiFunction_Demo {

	public static void main(String[] args) {
		
		//Write a bi function to multiply two numbers
		
		BiFunction<Integer, Integer, Integer> f = (a,b)->a*b;
		
		System.out.println(f.apply(10, 20));
		
		System.out.println(f.apply(20, 30));
		
		//create a student object by taking name and roll_num as input by using BiFunction
		
		ArrayList<Student> al = new ArrayList<>();
		
		BiFunction<String,Integer,Student> bf = (name,rollno)->new Student(name,rollno);
		
		//apply this function
		
		al.add(bf.apply("Durga", 100));
		al.add(bf.apply("Datta", 101));
		al.add(bf.apply("Candy", 99));
		al.add(bf.apply("Sandy", 104));
		
		for(Student s : al) {
			System.out.println(s.name+s.rollno);
		}
		
		
	}
}
