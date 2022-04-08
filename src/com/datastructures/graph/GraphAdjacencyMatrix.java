package com.datastructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.datastructures.sandy.AdjacencySetPractice;

//Need Enum To decide the type of graph
enum GraphType{
	DIRECTED,
	UNDIRECTED
}

public class GraphAdjacencyMatrix {

	//Need an 2d Array
	int[][] adjacencyMatrix;
	
	//Graphtype
	GraphType gtype;
	
	//No of vertices
	int numVertices;
	
	//Constructor to initialize
	
	public GraphAdjacencyMatrix(int numVertices, GraphType gtype) {
		this.numVertices = numVertices;
		this.gtype = gtype;
		
		//set the size of the array
		adjacencyMatrix = new int[numVertices][numVertices];
		
		//initialize the array
		for(int i=0; i<numVertices; i++) {
			for(int j=0; j<numVertices; j++) {
				adjacencyMatrix[i][j]=0;
			}
		}
	}
	
	//AddEdge Method	
	public void addEdge(int v1, int v2) {

		//check if vertices are correct
		if(v1<0||v1>=numVertices || v2<0||v2>=numVertices) {
			throw new IllegalArgumentException("Invalid Vertex");
		}
		
		//If vertices are correct then add an edge
		adjacencyMatrix[v1][v2]=1;
		
		//If graph type is undirected then we have to represent edge to both sides
		
		if(gtype==GraphType.UNDIRECTED) {
			adjacencyMatrix[v2][v1]=1;
		}
	}
	
   //Get Adjacent Vertices Method
   public List<Integer> getAdjacentVertices(int currVertex){
	   
	   //check if vertex is correct
	   if(currVertex<0||currVertex>=numVertices) {
		   throw new IllegalArgumentException("Invalid Vertex");
	   }
	   
	   //Create a list to hold result
	   List<Integer> l = new ArrayList<>();
	   
	   //Iterate through the currVertex
	   for(int i=0; i<numVertices; i++) {
		   
		   //If you find edge, add it to the list
		   
		   if(adjacencyMatrix[currVertex][i]==1) {
			   l.add(i);
		   }
	   }
	   
	   //return the List
	   return l;	   
   }
   
   //Depth-First Traversal
   public static void DFS(GraphAdjacencyMatrix g, int[] visited, int currVertex) {
	   
	   //Check if the current vertex is already visited
	   //Base case
	   if(visited[currVertex]==1) return;
	   
	   //Mark the node as visited
	   visited[currVertex]=1;
	   
	   //get Adjacent Vertices of current vertex
	   List<Integer> vertices = g.getAdjacentVertices(currVertex);
	   
	   //recursive to find remaining node
	   for(int vertex: vertices) {
		   DFS(g, visited, vertex);
	   }
	   
	   //Process the node
	   System.out.print(currVertex+"->");   
	   
	   
   }
   
  //Breadth-First Traversal
   public static void BFT(GraphAdjacencyMatrix g, int[] visited, int currVertex) {
	   
	   	   
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
   
   //Driver Code
   public static void main(String[] args) {
	int[] visited  = new int[8];
	int[] visited1 = new int[8];
	int N = 8;
	GraphAdjacencyMatrix graph = new GraphAdjacencyMatrix(N, GraphType.DIRECTED);
	
	graph.addEdge(1, 0);
    graph.addEdge(1, 2);
    graph.addEdge(2, 7);
    graph.addEdge(2, 4);
    graph.addEdge(2, 3);
    graph.addEdge(1, 5);
    graph.addEdge(5, 6);
    graph.addEdge(6, 3);
    graph.addEdge(3, 4);
    
    System.out.println("----------------------------");
    
    //Loop for unconnected graph 
    for(int k = 0; k<N; k++) {
    	 DFS(graph, visited, k);
    }
   
    System.out.println();
    System.out.println("----------------------------");
    
    //Loop for unconnected graph 
    for(int l=0; l<N; l++) {
    	 BFT(graph, visited1, l);
    }
   
    
    System.out.println("\n----------------------------");
}
   
}
