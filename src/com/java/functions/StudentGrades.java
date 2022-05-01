package com.java.functions;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudentGrades {
	
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
		
		Function<Student,String> fun = s -> {
			
			int marks = s.getMarks();
			
			if(marks>=80) return "A[Distinction]";
			else if(marks>=60) return "B[First-Class]";
			else if(marks>=60) return "C[Second-Class]";
			else if(marks>=35) return "D[Third-Class]";
			else return "F[Fail]";
			
		};
		
		// Applying Function		
//		for(Student s : slist) {
//			System.out.println(s.getName()+":"+s.getMarks()+" Grade is "+fun.apply(s)+"  ");
//			System.out.println("*****************************************");
//		}
		
		//Combine function with predicate to print students having marks greater than 60
		
		Predicate<Student> p = s -> s.getMarks() >= 60;
		
		for(Student s : slist) {
			if(p.test(s)) { 			
			System.out.println(s.getName()+":"+s.getMarks()+" Grade is "+fun.apply(s)+"  ");
			System.out.println("*****************************************");
			
			}
		}
			
	}

}
