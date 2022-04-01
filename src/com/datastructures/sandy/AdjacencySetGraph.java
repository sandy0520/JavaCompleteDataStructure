package com.datastructures.sandy;

import java.util.List;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


enum GraphType2{
	DIRECTED,
	UNDIRECTED
}

class Node1{
	
	int vertexNumber;
	Set<Integer> s = new HashSet<>();
	
	Node1(int vertexNumber){
		this.vertexNumber=vertexNumber;
	}
	
	int getVertex() {
		return vertexNumber;
	}
	
	void addEdge(int vertexNumber) {
		s.add(vertexNumber);
	}
	
	List<Integer> getAdjacentVertices(){
		List<Integer> sl = new ArrayList<>(s);
		Collections.sort(sl);
		return sl;
	}
}
public class AdjacencySetGraph {
	 List<Node1> vertexList = new ArrayList<>();
     GraphType2 graphType;
     int numVertices = 0;
     static int[] visited;

    public AdjacencySetGraph(int numVertices, GraphType2 graphType) {
        this.numVertices = numVertices;
        this.graphType = graphType;
        
        visited= new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            vertexList.add(new Node1(i));
        }
       
    }

    public void addEdge(int v1, int v2) {
        if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid: " + v1 + ", " + v2);
        }

        vertexList.get(v1).addEdge(v2);
        if (graphType == GraphType2.UNDIRECTED) {
            vertexList.get(v2).addEdge(v1);
        }
    }

 
    public List<Integer> getAdjacentVertices(int v) {
        if (v >= numVertices || v < 0) {
            throw new IllegalArgumentException("Vertex number is not valid: " + v);
        }

        return vertexList.get(v).getAdjacentVertices();
    }
    
    public static void DFS(AdjacencySetGraph g, int[] visited, int currentVertex) {
    	
    	//Base Case
    	if(visited[currentVertex]==1) return;
    	
    	visited[currentVertex]=1;
    	
    	List<Integer> l = g.getAdjacentVertices(currentVertex);
    	
    	for(int vertex : l) {
    		
    		DFS(g, visited, vertex);
    	}
    	
    	System.out.print(currentVertex+"->");
    }
    
    public static void main(String[] args) {
		
    	int N = 8;
    	AdjacencySetGraph graph = new AdjacencySetGraph(N, GraphType2.UNDIRECTED);
		
    	 graph.addEdge(1, 0);
         graph.addEdge(1, 2);
         graph.addEdge(2, 7);
         graph.addEdge(2, 4);
         graph.addEdge(2, 3);
         graph.addEdge(1, 5);
         graph.addEdge(5, 6);
         graph.addEdge(6, 3);
         graph.addEdge(3, 4);
		
      // This for-loop ensures that all nodes are covered even for an unconnected
         // graph.
		for(int i = 0; i<N; i++) {
			DFS(graph,visited,i);
		}
		
		List<Integer> res = graph.getAdjacentVertices(1);
		
		for(int l : res) {
			System.out.println(l);
		}
		
	}

}
