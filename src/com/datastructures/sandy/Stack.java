package com.datastructures.sandy;

class Element{
	
	int data;
	Element next;
	
	Element(int data, Element next){
		this.data = data;
		this.next = next;
	}
}
public class Stack {
	
	Element top = null;
	int MAX_SIZE = 40;
	int size=0;
	
	//Push operation
	public void push(int data) {
	
		if(size>MAX_SIZE) {
			System.out.println("Stack Overflow");
		}
		
		Element newEle = new Element(data,top);
		top = newEle;
		size++;
	}	

	//Pop Operation	
	public int pop() {
		
		if(size<=0) {
			System.out.println("Stack Underflow");
			}
		int data = top.data;
		top = top.next;
		size--;
		return data;
	}
	
	//peek Operation	
	public int peek() {
		if(size==0) {
			System.out.println("Stack Underflow");
		}
		return top.data;
	}
	
	//Size
	public int size() {
		return size;
	}
	
	//isEmpty	
	public boolean isEmpty() {
		return size == 0;
	}
	
	//isFull
	public boolean isFull() {
		return size == MAX_SIZE;
	}
	
	//Printing elements in Stack by removing one by  one
	public void printStack() {
		
		if(size==0) {
			System.out.println("No Elements to print in Stack");
		}
		while(size!=0) {
			System.out.println(top.data);
			top=top.next;
			size--;
			
		}
	}
	
	
	public static void main(String[] args) {
		Stack s = new Stack();
		
		//System.out.println("The top element removed from the stack is "+s.pop());
		
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		
		//s.printStack();
		
		System.out.println("The total size of the stack is "+s.size());
		
		System.out.println("The top element present in the stack is "+s.peek());
		
		System.out.println("The top element removed from the stack is "+s.pop());
		
		System.out.println("The top element present in the stack is "+s.peek());
		
		System.out.println("The total size of the stack is "+s.size());
		
		s.printStack();
		
		System.out.println("Calling second time to print");
		s.printStack();
	}
}
