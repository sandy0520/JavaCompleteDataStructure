package com.datastructures.sandy;

import java.util.ArrayList;
import java.util.List;

enum GraphType{
		DIRECTED,
		UNDIRECTED
}
public class AdjacencyMatrixGraphSecondVersion {

	String[][] adjacencyMatrix;
	int numVertices;
	GraphType graphType;
	
	 AdjacencyMatrixGraphSecondVersion(int numVertices, GraphType graphType) {
		
		 this.numVertices = numVertices;
		 this.graphType = graphType;
		 
		 adjacencyMatrix = new String[numVertices][numVertices];
		 
		 for(int i=0; i<numVertices; i++) {
			 for(int j = 0; j<numVertices; j++) {
				 adjacencyMatrix[i][j]="0";
			 }
		 }
	}
	 
	public void addEdge(int src, int dst) {
	//	if(Character.toString(src).matches("[a-zA-Z]")&&Character.toString(dst).matches("[a-zA-Z]")) {
			
			adjacencyMatrix[src][dst]="1";
			if(graphType==GraphType.UNDIRECTED) {
				adjacencyMatrix[dst][src]="1";
			//}
		}
		
	}
	
	public List<Integer> getAdjacentVertices(int vertex){
		
		List<Integer> l = new ArrayList<>();
		
		for(int i = 0; i<numVertices; i++) {
			if(adjacencyMatrix[vertex][i]=="1") {
				l.add(i);
			}
		}
		return l;
	}
	
	public static void main(String[] args) {
		
		AdjacencyMatrixGraphSecondVersion g = new AdjacencyMatrixGraphSecondVersion(4,GraphType.UNDIRECTED);
		
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		
		List<Integer> res = g.getAdjacentVertices(3);
		
		for(int s : res) {
			System.out.println(s);
		}
		
	}
	
}
