package com.java.methodreference;

//Check notes for explanation
public class MethodReference_Demo2 {

	private int m2() {
		for(int i=0;i<10;i++) {
			System.out.println("Child Thread");	
			
		}	
		return 0;
	}
//	public void m1() {
//		for(int i=0;i<10;i++) {
//			System.out.println("Child Thread");	
//			
//		}	
//	}
	public static void main(String[] args) {
		
		System.out.println("Instance method reference");
		MethodReference_Demo2 m = new MethodReference_Demo2();
		
		Runnable r = m :: m2;
		
		Thread t = new Thread(r);
		
		t.start();
		
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");	
		}	
	}
}
