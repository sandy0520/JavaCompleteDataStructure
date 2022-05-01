package com.java.consumer;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.java.functions.Student;

public class StudentUI {

	public static void addStudents(ArrayList<Student> slist) {
		
		slist.add(new Student("Candy",95));
		slist.add(new Student("Aandy",75));
		slist.add(new Student("Randy",65));
		slist.add(new Student("Dube",80));
		slist.add(new Student("Clan",85));
		slist.add(new Student("Lane",55));
		slist.add(new Student("Sandy",30));
		slist.add(new Student("Pre",55));
		slist.add(new Student("Har",89));
		slist.add(new Student("Sha",100));
		
	}
	public static void main(String[] args) {
		
		ArrayList<Student> slist = new ArrayList<>();
			
		addStudents(slist);
		
		//Predicate to find marks greater than 60		
		Predicate<Student> p = s -> s.getMarks() >= 60;
		
		//Function to find grades		
		Function<Student,String> f = s ->{
			int marks = s.getMarks();
			if(marks>=80) return "A";
			else if(marks>=60) return "B"; 
			else if(marks>=50) return "C"; 
			else if(marks>=35) return "Pass"; 
			else return "Fail";
		};
		
		//Consumer to print the student information
		Consumer<Student> c = s -> {
			System.out.println("************************************");
			System.out.println("StudentName: "+s.getName() );
			System.out.println("StudentMarks: "+s.getMarks());
			System.out.println("StudentGrade: "+f.apply(s)); //This is important calling function to get grade (Function apply)
			System.out.println("************************************");
		};
		
		//Applying P, F and C for all students
		
		for(Student s : slist) {
			
			if(p.test(s)) { //Predicate test
				c.accept(s); //Consumer apply
			}
			
			//c.accept(s);  Prints all student information with grades
		}
		
	}
}
