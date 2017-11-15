package com.urbanise;

import java.util.HashMap;

/**
 * 
 * Graph edge containing two vertices i.e. edge(vertex1, vertex2)
 * 
 * @author KALA
 *
 */
public class Edge {
	 
	public static final String[] index = {"A", "B", "C", "D", "E", "F", "G", "H"};
	public static final HashMap<String, Integer> indexes = new HashMap<String, Integer>();
	// TODO: compute the index based on string values (e.g. hash function)
	static {
		indexes.put("A", 0);
		indexes.put("B", 1);
		indexes.put("C", 2);
		indexes.put("D", 3);
		indexes.put("E", 4);
		indexes.put("F", 5);
		indexes.put("G", 6);
		indexes.put("H", 7);
	}
	
	private String vertex1;
	private String vertex2;
	
	public Edge(String v1, String v2) {
		vertex1 = v1;
		vertex2 = v2;
	}

	public String getVertex1() {
		return vertex1;
	}
	
	public Integer getVertex1Index() {
		return indexes.get(vertex1);
	}

	public String getVertex2() {
		return vertex2;
	}
	
	public Integer getVertex2Index() {
		return indexes.get(vertex2);
	}

}
