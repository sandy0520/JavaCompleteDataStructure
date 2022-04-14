package com.java.lambda;
import java.util.ArrayList;
import java.util.Collections;
public class Test {

	

	public static void main(String[] args) {
		
		Employee e = new Employee("Durga", 101010);
		
		
		ArrayList<Employee> l = new ArrayList<Employee>();
		
		l.add(new Employee("Sunny", 201301));
		l.add(new Employee("Bunny", 334455));
		l.add(new Employee("Cinny", 668899));
		l.add(new Employee("Vinny", 111111));
		l.add(e);
		System.out.println(l);
		
		//lambda expression to sort ascending order based on eno
		Collections.sort(l,(e1,e2)->(e1.eno<e2.eno)?-1:(e1.eno>e2.eno)?1:0);
		System.out.println(l);
		
		//lambda expression to sort ascending order based on ename: using DFNS
		Collections.sort(l, (e1,e2)->(e1.name.compareTo(e2.name)));
		System.out.println(l);
		
		//lambda expression to sort descending order based on ename: using DFNS
		Collections.sort(l, (e1,e2)->(e2.name.compareTo(e1.name)));
		System.out.println(l);
		
	}
}
