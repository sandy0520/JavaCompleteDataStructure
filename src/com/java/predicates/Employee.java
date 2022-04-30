package com.java.predicates;

public class Employee {
	
	private String name;
	private String desingation;
	
	private double salary;
	private String city;
	
	public Employee(String name, String designation, double salary, String city) {
		
		this.name = name;
		this.desingation = designation;
		this.salary = salary;
		this.city = city;		
		
	}
	
	//Getters to retrieve object
	public String getName() {
		return name;
	}

	public String getDesingation() {
		return desingation;
	}

	public double getSalary() {
		return salary;
	}
	public String getCity() {
		return city;
	}
	
	//Overwrite toSting method to print employee object
	
	public String toString() {
		
		String s = String.format("(%s,%s,%.2f,%s)"+"\n", name,desingation,salary,city);
		return s;
	}
	

}
