package com.datastructures.sandy;

class Node{
	
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
		
}

public class LinkedList {

	Node head = null;
	
	//Inserting to a List	
	public void buildList(int data) {
		
		if(head==null) {
			head = new Node(data);
		}
		else {			
			Node curr = head;
			
			while(curr.next!=null) {
				//System.out.println("Entered here");
				curr=curr.next;
			}			
			curr.next=new Node(data);
		}		
	}
	
	//Counting List	
	public void countList() {
		
		if(head == null) {
			System.out.println("List is Empty");
		}
		else {
			Node curr = head;
			int count=0;
			while(curr!=null) {
				count++;
				curr=curr.next;
				
			}
			System.out.println(count);
		}
	}
	
	//Printing List	
	public void printList() {
		
		if(head == null) {
			System.out.println("List is Empty");
		}else {
			Node curr = head;
			while(curr!=null) {
				System.out.println(curr.data);
				curr=curr.next;
			}
		}
	}
	
	//Removing head element
	public void removeHead() {
		if(head==null) {
			System.out.println("List Is Empty: No Elements to remove");
		}else {
			int element = head.data;
			System.out.println("Removed Head Element Is: "+element);
			head = head.next;
		}
	}
	
	
	public static void main(String[] args) {
		
		LinkedList l = new LinkedList();
		System.out.println("Building List");
		l.buildList(10);
		l.buildList(20);
		l.buildList(30);
		l.buildList(40);
		
		System.out.println("Printing Elements in Linked List");
		l.printList();
		
		System.out.println("Number of Nodes in the List are:");
		l.countList();
		
		l.removeHead();
		
		System.out.println("Number of Nodes in the List are:");
		l.countList();
		
	}
	

}
