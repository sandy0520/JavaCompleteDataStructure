package com.datastructures.sandy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum GraphType3{
	DIRECTED,
	UNDIRECTED
}
public class AdjacencyMatrixPractice1 {

	int numVertices;
	int[][] adjacentMatrix;
	GraphType3 graphType;
	
	public AdjacencyMatrixPractice1(int numVertices, GraphType3 graphType) {
			this.numVertices = numVertices;
			this.graphType = graphType;
			
			adjacentMatrix = new int[numVertices][numVertices];
			
			for(int i = 0; i<numVertices; i++) {
				for(int j = 0; j<numVertices; j++) {
					adjacentMatrix[i][j]=0;
				}
			}
	}
	
	public void addEdge(int src, int dst) {
		
		if(src<0||src>numVertices||dst<0||dst>numVertices) {
			throw new IllegalArgumentException("Invalid Vertex");
		}
		adjacentMatrix[src][dst]=1;
		if(graphType==GraphType3.UNDIRECTED) {
			adjacentMatrix[dst][src]=1;
		}
	}
	
	public List<Integer> getAdjacentVertices(int vertex){
		
		List<Integer> l = new ArrayList<>();
		
		
		for(int i = 0; i<numVertices;i++) {
			if(adjacentMatrix[vertex][i]==1) {
				l.add(i);
			}
		}
		Collections.sort(l);
		return l;	
		
	}
	
	public static void DFS(AdjacencyMatrixPractice1 g, int[] visited, int currentVertex) {
		
		//BaseCase
		if(visited[currentVertex]==1) return;
		
		visited[currentVertex]=1;
		
		List<Integer> l = g.getAdjacentVertices(currentVertex);
		
		for(int vertex: l) {
			DFS(g, visited, vertex);
		}
		
		System.out.print(currentVertex+ "->");
		//System.out.println();
	}
	
	public static void main(String[] args) {
		
		int N= 4;
		int[] visited = {0,0,0,0};
		AdjacencyMatrixPractice1 g = new AdjacencyMatrixPractice1(N, GraphType3.UNDIRECTED);
		
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		
		for(int i = 0; i<N; i++) {
			DFS(g,visited,i);
		}
		
		
		List<Integer>res = g.getAdjacentVertices(0);
		System.out.println();
		for(int el : res) {
			
			System.out.println(el);
		}
	}
}
