package com.java.biFunctionalInterfaces;

public class Employee {

	private String name;
	private int id;
	private double dailywage;
	private double salary;
	
	public Employee(String name, int id, double dailywage) {
		
		this.id = id;
		this.name = name;
		this.dailywage=dailywage;
	}
	
	//Getters
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public double getDailyWage() {
		return dailywage;
	}
	
	public double getSalary() {
		return salary;
	}
	
	//setters
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
