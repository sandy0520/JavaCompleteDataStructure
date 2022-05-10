package com.java.methodreference;

@FunctionalInterface
interface Interf{	
	public void m1();
}

public class MethodReference_Demo {

	public static void m2() {
		System.out.println("Static Method Reference");
	}
	
	public static void main(String[] args) {
		
		Interf i = MethodReference_Demo::m2;
		
		i.m1();
	}
}
