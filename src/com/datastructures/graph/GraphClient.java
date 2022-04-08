package com.datastructures.graph;

public class GraphClient {

	//Driver Code
	public static void main(String[] args) {
		
		Graph g = new Graph();
		
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
		
		g.addEdge("A", "B", 1);
		g.addEdge("A", "D", 10);
		g.addEdge("B", "C", 2);
		g.addEdge("C", "D", 3);
		g.addEdge("D", "E", 4);
		g.addEdge("E", "F", 5);
		g.addEdge("E", "G", 12);
		g.addEdge("F", "G", 4);
		
		g.display();
	}
}
