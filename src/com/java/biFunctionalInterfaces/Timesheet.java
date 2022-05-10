package com.java.biFunctionalInterfaces;

public class Timesheet {
	
	private int id;
	private int no_of_days;
	
	public Timesheet(int id, int no_of_days) {
		this.id = id;
		this.no_of_days = no_of_days;
	}
	
	//getters
	public int getId() {
		return id;
	}
	
	public int getNoOfDays() {
		return no_of_days;
	}

}
