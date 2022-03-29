package com.datastructures.sandy;

import java.util.List;

public interface Graph {

	enum GraphType{
		DIRECTED,
		UNDIRECTED
	}
	
	void addEdge(int src, int dst);
	
	List<Integer> getAdjacentVertices(int vertex);
}
