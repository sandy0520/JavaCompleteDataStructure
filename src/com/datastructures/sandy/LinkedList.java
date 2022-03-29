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
	public int countList() {
		int count=0;
		if(head == null) {
			System.out.println("List is Empty");
		}
		else {
			Node curr = head;
						while(curr!=null) {
				count++;
				curr=curr.next;				
			}
			System.out.println(count);
		}
		return count;
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
	
	//Print the list in reverse order
	public void printReverse(Node head) {
		
		if(head==null) {
			return;
		}
		printReverse(head.next);
		System.out.println(head.data);		
	
	}
	
	//Reverse the node of the linked list
	public void reversedList() {
		
		Node curr = head;
		Node nex = null;
		Node prev = null;
		
		if(head==null) {
			return;
		}else {
			while(curr!=null) {
				nex = curr.next;
				curr.next = prev;
				prev = curr;
				curr = nex;
			}
			head = prev;
		}
	}
	
	//Remove the element at certain index	
	public void removeNodeAtIndex(int index) {
		
		int i=0;
		if(head==null||index<0||index >= countList()) {
			System.out.println("Invalid index");
			return;
		}
		
		Node curr = head;
		
		
		if(index==0) {
			head = head.next;
		}
		else {
			
		while(i!=index-1) {
			if(curr!=null) {
				curr=curr.next;
				i++;
			}
		}		
		curr.next=curr.next.next;
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
		
//		System.out.println("Number of Nodes in the List are:");
//		l.countList();
		
		
//		l.removeHead();
		
		System.out.println("Number of Nodes in the List are:");
		l.countList();
		
//		System.out.println("Printing the list in reverse order without list Modification");
//		l.printReverse(l.head);
//		
//		l.reversedList();
//		
//		System.out.println("Reversed List");
//		l.printList();
//		
//		System.out.println("Printing the list in reverse order without list Modification");
//		l.printReverse(l.head);
		
		l.removeNodeAtIndex(0);
		System.out.println("Index removed and printed");
		l.printList();
	
	}
	

}
