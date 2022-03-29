package com.datastructures.sandy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdjacencyMatrixGraph implements Graph {
	
	int[][] adjacencyMatrix;
	int numVertices;
	private GraphType graphType;
	
	AdjacencyMatrixGraph(int numVertices, GraphType graphType){
		
		this.numVertices = numVertices;
		this.graphType = graphType;
		
		adjacencyMatrix = new int[numVertices][numVertices];
		
		for(int i = 0; i< numVertices; i++) {
			for(int j = 0; j<numVertices; j++) {
				adjacencyMatrix[i][j]=0;
			}
		}
	}

	@Override
	public void addEdge(int src, int dst) {
		
		if(src>=numVertices||src<0||dst>=numVertices||dst<0) {
			throw new IllegalArgumentException("Vertex Number is not valid");
		}
		adjacencyMatrix[src][dst]=1;
		if(graphType==GraphType.UNDIRECTED) {
			adjacencyMatrix[dst][src]=1;
		}
		
	}

	@Override
	public List<Integer> getAdjacentVertices(int vertex) {
		
		List<Integer> l = new ArrayList<>();
		
		for(int i = 0; i<numVertices; i++) {
			if(adjacencyMatrix[vertex][i]==1) {
				l.add(i);
			}
		}
		Collections.sort(l);		
		return l;
	}
	
	public static void main(String[] args) {
		
		AdjacencyMatrixGraph g = new AdjacencyMatrixGraph(4, GraphType.UNDIRECTED);
		
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		
		List<Integer> res = g.getAdjacentVertices(3);
		
		for(int l : res) {
			System.out.println(l);
		}
		
	}

}
