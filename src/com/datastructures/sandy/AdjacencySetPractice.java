package com.datastructures.sandy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

enum GraphType4{
	DIRECTED,
	UNDIRECTED
}

class Node3{
	int vertexId;
	Set<Integer> adjacencySet = new HashSet<>();
	public int getVertexId() {
		return vertexId;
	}
	public Node3(int vertexId) {
		this.vertexId = vertexId;
	}
	
	public void addEdge(int vertexNumber) {
		adjacencySet.add(vertexNumber);
	}
	public List<Integer> getAdjacenctvertices() {
		
		List<Integer> sl = new ArrayList<>(adjacencySet);
		Collections.sort(sl);
		return sl;
	}	
	
}

public class AdjacencySetPractice {
	
	List<Node3> vertexList = new ArrayList<>();
	GraphType4 graphType;
	int numVertices;
	
	public AdjacencySetPractice(int numVertices, GraphType4 graphType) {
		this.numVertices = numVertices;
		this.graphType = this.graphType;
		
		for(int i = 0; i<numVertices; i++) {
			vertexList.add(new Node3(i));
		}
	}
	
   public void addEdge(int src, int dst) {
	   if(src<0||src>numVertices||dst<0||dst>numVertices) throw new IllegalArgumentException("Invalid Vertex Number");
	   
	   vertexList.get(src).addEdge(dst);
	   if(graphType == GraphType4.UNDIRECTED) {
		   vertexList.get(dst).addEdge(src);
	   }
   }
   
   public List<Integer> getAdjacentVertices(int vertex){
	   
	   if(vertex<0||vertex>numVertices) throw new IllegalArgumentException("Invalid Vertex");
	   
	   return vertexList.get(vertex).getAdjacenctvertices();
	   
   }
   
   public static void main(String[] args) {
	
	   AdjacencySetPractice g = new AdjacencySetPractice(4, GraphType4.UNDIRECTED);
	   
	   g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		
		List<Integer> res = g.getAdjacentVertices(3);
		for(int el : res) {
			System.out.println(el);
		}
	   
}

}
