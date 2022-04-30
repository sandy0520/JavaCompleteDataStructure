package com.java.predicates;

import java.util.ArrayList;
import java.util.function.Predicate;

public class EmployeeUI {
	
	public static void addEmployees(ArrayList<Employee> elist) {

		elist.add(new Employee("Durga", "CEO", 50000, "Hyderabad"));
		elist.add(new Employee("Sandy", "CTO", 40000, "Bangalore"));
		elist.add(new Employee("Andy", "Manager", 35000, "Mumbai"));
		elist.add(new Employee("Brandy", "TeamLead", 30000, "Mumbai"));
		elist.add(new Employee("Candy", "Manager", 35000, "Bangalore"));
		elist.add(new Employee("Brice", "TeamLead", 30000, "Bangalore"));
		elist.add(new Employee("Jim", "Manager", 35000, "Hyderabad"));
		elist.add(new Employee("James", "TeamLead", 30000, "Hyderabad"));
		elist.add(new Employee("Lisa", "Software Developer", 25000, "Bangalore"));
		elist.add(new Employee("Stephanie", "Software Developer", 25000, "Bangalore"));
		elist.add(new Employee("Brie", "Software Developer", 25000, "Mumbai"));
		elist.add(new Employee("Love", "Software Developer", 25000, "Mumbai"));
		elist.add(new Employee("Soma", "Software Developer", 25000, "Hyderabad"));
		elist.add(new Employee("Zeele", "Software Developer", 25000, "Hyderabad"));
		elist.add(new Employee("Kale", "Tester", 20000, "Bangalore"));
		elist.add(new Employee("Seal", "Tester", 20000, "Bangalore"));
		elist.add(new Employee("Song", "Tester", 20000, "Mumbai"));
		elist.add(new Employee("Candice", "Tester", 30000, "Hyderabad"));

	}
	
	
	public static void display(Predicate p, ArrayList<Employee> elist) {
		
		  for(Employee emp : elist) {
			  if(p.test(emp)) System.out.println(emp.getName());
			   
		 }
		  System.out.println("***************"); 
	}
	public static void main(String[] args) {
		
		ArrayList<Employee> elist = new ArrayList<Employee>();
		addEmployees(elist);
		System.out.println(elist);
		
		//Write a predicate to find all the employees who are managers		
		Predicate<Employee> p1 = emp -> emp.getDesingation().equals("Manager");
		System.out.println("Manager are:");
		display(p1, elist);
		
		//Write a predicate to find all the employees located in bangalore		
		Predicate<Employee> p2 = emp -> emp.getCity().equals("Bangalore");
		System.out.println("Employees Located in Bangalore are: ");
		display(p2, elist);
		 
		//Write a predicate to find employees having  salary less than or equal to 20000
		Predicate<Employee> p3 = emp -> emp.getSalary()<=20000;
		System.out.println("Employees having  salary less than or equal to 20000 are: ");
		display(p3, elist);
		
		//Write a predicate to find all managers from bangalore: (Combination of two predicates)
		System.out.println("Employees who are Managers Located in Bangalore to terminate are: ");
		display(p1.and(p2),elist); //and operator
		
		//write a predicate to find employees who are Managers or employees whose salary is less than 20000
		System.out.println("Employees who are Managers or employees whose salary is less than 20000 are: ");
		display(p1.or(p3),elist); //or operator or method
		
		//Write a predicate to find Employees who are not Managers
		System.out.println("List of Employees who are not managers: ");
		display(p1.negate(),elist); //not operator
		
		//To test equality of two predicates then we should go for isEqual() in predicate Interface
		
		Predicate<String> p = Predicate.isEqual("Sandy");
		System.out.println(p.test("Sandy")); //True
		System.out.println(p.test("Andy")); //False
		
		
	}
} 
