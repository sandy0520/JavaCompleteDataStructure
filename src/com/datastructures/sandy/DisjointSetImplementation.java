package com.datastructures.sandy;

public class DisjointSetImplementation {
	
	//Quick Find Disjoint Set
	
	int[] rootArray;
	
	//constructor to initialize the rootArray: Index act as vertices and Values act as root node for that vertex
	public DisjointSetImplementation(int size) {
		
		rootArray = new int[size];
		
		for(int i = 0; i<size; i++) {
			rootArray[i]=i;
		}
	}
	
	//Find Function: It just returns the root node of the given vertex. TC: O(1)
	public int find(int v) {
		return rootArray[v];
	}

	//Union Function: Connects the graph. TC: O(N)
	
	public void union(int v1, int v2) {
		
		int rootV1 = find(v1);
		int rootV2 = find(v2);
		
		if(rootV1!=rootV2) {
			
			//Basically assigning the root node directly for that particular vertex
			for(int i =0; i < rootArray.length;i++) {
				
				if(rootArray[i]==rootV2) {
					rootArray[i]=rootV1;
				}
			}
		}
	}
	
	//IS connected function to check there is an edge between v1 and v2. TC: O(1)
	public boolean isConnected(int v1, int v2) {
		return find(v1)==find(v2);
	}
	
	public static void main(String[] args) {
		
		DisjointSetImplementation d = new DisjointSetImplementation(9);
		//0 Root
		d.union(0, 1);
		d.union(0, 2);
		d.union(1, 3);
		d.union(3, 4);
		
		//5 root
		d.union(5, 6);
		d.union(5, 7);
		d.union(7, 8);
		
		System.out.println(d.isConnected(3, 1));
		System.out.println(d.isConnected(5, 8));
		System.out.println(d.isConnected(5, 3));
		
		System.out.println("The root node of vertex 4 is "+ d.find(4));
		System.out.println("The root node of vertex 8 is "+ d.find(8));
		System.out.println("The root node of vertex 0 is "+ d.find(0));
		System.out.println("The root node of vertex 5 is "+ d.find(5));
	}
}
