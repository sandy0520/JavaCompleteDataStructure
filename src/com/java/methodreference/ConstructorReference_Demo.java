package com.java.methodreference;

public class ConstructorReference_Demo {

	public static void main(String[] args) {
		
		//Using Constructor Reference		
		ConstructirReferenceDemoInterface i = Sample::new;		
		Sample s2 = i.get();
		
		
		//Using Lamda Expression		
		ConstructirReferenceDemoInterface i2 = ()->{
			Sample s = new Sample();
			return s;
		};
		Sample s1 = i2.get();
	}
}
