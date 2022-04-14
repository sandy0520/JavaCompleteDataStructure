package com.java.lambda;

public class Employee {

	String name;
	int eno;
	
	Employee(String name, int eno){
		this.name = name;
		this.eno = eno;
	}
	
	public String toString() {
		return name+ ":"+eno;
	}
}
