package com.java.functions;

public class Employee {

	private String name;
	private double salary;
	
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}
	
	//Setters
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	//Getters
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	//Overriding toString()
	
	public String toString() {
		return name+" "+salary;
	}
}
