package com.java.functions;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class EmployeeUI {
	
	public static void addEmployees(ArrayList<Employee> elist) {
		
		elist.add(new Employee("Durga",50000));
		elist.add(new Employee("Andy",40000));
		elist.add(new Employee("Randy",30000));
		elist.add(new Employee("Candy",2500));
		elist.add(new Employee("Brandy",1500));
		elist.add(new Employee("Lane",1000));
		elist.add(new Employee("Cane",2000));
		elist.add(new Employee("Pane",3000));		
	}

	public static void main(String[] args) {
		
		ArrayList<Employee> list = new ArrayList<>();
		
		addEmployees(list);
		
		//prints in the format of overrided toString method
		System.out.println(list);
		
		//Write a Function to count total salary of all Employees		
		Function<ArrayList<Employee>, Double> fun = s -> {
			double total = 0;
			for(Employee e : s) {
				total= total+e.getSalary();
			}
			return total;
		};			
		System.out.println("The total salary of all Employees is: "+ fun.apply(list));
		
		//Code to increment the salary of 477$ for employees having salary < 3500$ (Predicate and Function)		
		Predicate<Employee> p = s->s.getSalary() < 3500;
		Function<Employee, Employee> f = s-> {
				//double increment = 477;
				//double newSalary = s.getSalary()+ increment;
				s.setSalary(s.getSalary()+ 477);
				return s;
		};		
		ArrayList<Employee> updatedList = new ArrayList<Employee>();		
		for(Employee emp : list) {
			if(p.test(emp)) {
				f.apply(emp);
				updatedList.add(emp);
			}
		}		
		System.out.println("The Employees who got increment in salaries are: "+ updatedList);
		
	}
}
