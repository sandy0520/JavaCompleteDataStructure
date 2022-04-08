package com.datastructures.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

	private class Vertex{
		
		//Using Map To store Neighbors(one Vertex), Integer represents here cost
		
		HashMap<String, Integer> ngbrs = new HashMap<>();
		
	}
	
	//Vertices
	
	private HashMap<String, Vertex> vertices = new HashMap<>();
	
	public int numVertex() {
		return vertices.size();
	}
	
	public void addVertex(String vname) {
		Vertex vtx = new Vertex();
		vertices.put(vname, vtx);
	}
	
	public void addEdge(String vname1, String vname2, int cost) {
		
		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);
		
		//check if vertices are correct and if they are already connected
		
		if(vtx1==null||vtx2==null||vtx1.ngbrs.containsKey(vtx2)) {
			return;
		}
		
		vtx1.ngbrs.put(vname2, cost);
		vtx2.ngbrs.put(vname1, cost);
		
	}
	
	public void display() {
		System.out.println("----------------------");
		
		ArrayList<String> keys = new ArrayList<>(vertices.keySet());
		
		for(String key : keys) {
			Vertex vtx = vertices.get(key);
			String str = key + "->"+ vtx.ngbrs;
			System.out.println(str);
		}
				
	}
	
}
