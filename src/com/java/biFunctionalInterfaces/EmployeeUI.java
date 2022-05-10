package com.java.biFunctionalInterfaces;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class EmployeeUI {

	public static void addEmployees(ArrayList<Employee> elist) {
		elist.add(new Employee("Durga",101,2000));
		elist.add(new Employee("Sandy",102,1000));
		elist.add(new Employee("Andy",103,1500));
		elist.add(new Employee("Candy",104,2500));
		elist.add(new Employee("Randy",105,1700));
	}
	
	public static void fillTimeSheet(ArrayList<Timesheet> tlist) {
		tlist.add(new Timesheet(101,30));
		tlist.add(new Timesheet(102,30));
		tlist.add(new Timesheet(103,30));
		tlist.add(new Timesheet(104,30));
		tlist.add(new Timesheet(105,30));
	}
	
	//Calculates Monthly salary and updates it in employee class using BiFunction
	public static void calculateMontlySalary(BiFunction<Employee, Timesheet, Double> fun, ArrayList<Employee> elist, ArrayList<Timesheet> tlist) {
		
		for(Employee e : elist) {
			
			for(Timesheet t: tlist) {
				
				if(t.getNoOfDays()!=0 && e.getDailyWage()!=0 && t.getId()==e.getId()) {
					
					double salary = (double)fun.apply(e, t);
					e.setSalary(salary);
					System.out.println("Montly Salaray of Employee "+e.getName()+" working "+ t.getNoOfDays()+" days is: "+ salary);
				}
			}
		}
		
	}
	
	//Increment Salary of all employees by 1800 using BiConsumer
	
	public static void incrementSalary(BiConsumer<Employee, Double> c, ArrayList<Employee> elist) {
		
		for(Employee e : elist) {
			c.accept(e, 1800.0);
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<Employee> elist = new ArrayList<Employee>();
		ArrayList<Timesheet> tlist = new ArrayList<Timesheet>();
		
		addEmployees(elist);
		fillTimeSheet(tlist);
		
		BiFunction<Employee, Timesheet, Double> fun = (e,t)->e.getDailyWage() * t.getNoOfDays();
		
		calculateMontlySalary(fun, elist, tlist);
		
		BiConsumer<Employee, Double> c = (e, increment)-> e.setSalary(e.getSalary()+increment);
		
		incrementSalary(c, elist);
		
		System.out.println(" *************************************************************************");
		for(Employee e : elist) {
			System.out.println("The updated salary of employee "+e.getName()+" is: "+e.getSalary());
		}
 	}
}
