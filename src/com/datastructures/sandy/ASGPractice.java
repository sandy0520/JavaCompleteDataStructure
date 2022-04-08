package com.datastructures.sandy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

import com.datastructures.graph.GraphAdjacencyMatrix;

//Need  enum for GraphType

enum Gtype{
	DIRECTED,
	UNDIRECTED
}

//class Node to hold the each vertex

class Node5{
	
	//Represents Unique Vertex in Graph
	int vertexID;
	
	//Set
	Set<Integer> adjacencySet = new HashSet<>();
	
	//Constructor to add vertices
	
	Node5(int vertexId){
		this.vertexID=vertexId;
	}
	
	//addEdge Method
	void addEdge(int vNum) {
		adjacencySet.add(vNum);
	}
	
	//return vertices method
	
	public List<Integer> getAdjacentVertices(){
		List<Integer> sl = new ArrayList<>(adjacencySet);
		
		Collections.sort(sl);
		
		return sl;
	}
}

public class ASGPractice {
	
	//No of vetices
	int numVertices;
	
	//List to add them to the nodes
	
	List<Node5> vertex = new ArrayList<>();
	
	Gtype gtype;
	
	//Constructor
	
	public ASGPractice(int numVertices, Gtype gtype) {
		
		this.numVertices = numVertices;
		this.gtype = gtype;
		
		//add all vertices to the set
		for(int i=0; i<numVertices;i++) {
			vertex.add(new Node5(i));
		}
	}
	
	public void addEdge(int src,int dst) {
		
		//check if src and dst are valid
		
		if(src<0||src>numVertices||dst<0||dst>numVertices) {
			throw new IllegalArgumentException();
		}
		
		vertex.get(src).addEdge(dst);
		if(gtype==Gtype.UNDIRECTED) {
			vertex.get(dst).addEdge(src);
		}
	}
	
	public List<Integer> getAdjacentVertices(int v) {
		
		return vertex.get(v).getAdjacentVertices();
	}
	
	//Depth-First Search
	
	public static void DFS(ASGPractice graph, int[] visited, int currVertex) {
//		System.out.println("Inside DFS");
		
		//BaseCase
		if(visited[currVertex]==1) {
			return;
		}
		
		visited[currVertex]=1;
		
		List<Integer> l = graph.getAdjacentVertices(currVertex);
		
		for(int vertex:l) {
			DFS(graph, visited, vertex);
		}
		
		System.out.print(currVertex+"->");
	}
	
	//Breadth-First Traversal
	   public static void BFS(ASGPractice g, int[] visited, int currVertex) {
		   
		   	   
		   LinkedList<Integer> queue = new LinkedList<>();
		   queue.addFirst(currVertex);
		   
		   while(!queue.isEmpty()) {
			   int vertex = queue.removeLast();		   
			   
			   if(visited[vertex]==1) continue;
			   
			   System.out.print(vertex+"->");		   
			   visited[vertex]=1;
			   
			 //Get adjacent vertices of current vertex
			   List<Integer> v = g.getAdjacentVertices(vertex);
			   
			   for(int vx: v) {			  
				   queue.addFirst(vx);
			   }
			   
		   }	   
		   
	   }
	public static void main(String[] args) {
		
		int[] visited = new int[8];
		int[] visited1 = new int[8];
		
		ASGPractice graph = new ASGPractice(8, Gtype.UNDIRECTED);
		 graph.addEdge(1, 0);
         graph.addEdge(1, 2);
         graph.addEdge(2, 7);
         graph.addEdge(2, 4);
         graph.addEdge(2, 3);
         graph.addEdge(1, 5);
         graph.addEdge(5, 6);
         graph.addEdge(6, 3);
         graph.addEdge(3, 4);
         
         List<Integer>res = graph.getAdjacentVertices(0);
         System.out.println(res);
         
         
         System.out.println("DFS");
         //for Unconnected graphs
              
         for(int j = 0; j<8; j++) {
        	 DFS(graph, visited1,j);
         }
         System.out.println();
         System.out.println("BFS");
         //For Unconnected Graphs
         
         for(int i = 0; i<8; i++) {
        	 BFS(graph, visited,i);
         }
         
         

	}

}
