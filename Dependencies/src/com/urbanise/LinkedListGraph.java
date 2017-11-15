package com.urbanise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * Linked list implementation of graph
 * 
 * @author KALA
 *
 */
public class LinkedListGraph implements Graph {
	
	// key: vertex presented like rows, value: linked list of vertices presented like irregular columns
	private Map<String, Vertex>[] vertices = new HashMap[Mode.values().length];
	
	private Set<String>[] dependantVertices = new TreeSet[Mode.values().length];
	
	public LinkedListGraph() {
		for (Mode mode : Mode.values()) {
			vertices[mode.ordinal()] = new HashMap<String, Vertex>();
			dependantVertices[mode.ordinal()]  = new TreeSet<String>();
		}
	}
	 
	public void insert(Edge edge) {
		String vertex1 = edge.getVertex1();
		String vertex2 = edge.getVertex2();
		vertices[Mode.TRANSITIVE.ordinal()].put(vertex1, new Vertex(vertex2, vertices[Mode.TRANSITIVE.ordinal()].get(vertex1)));
		vertices[Mode.INVERSE.ordinal()].put(vertex2, new Vertex(vertex1, vertices[Mode.INVERSE.ordinal()].get(vertex2)));
	}

	public void remove(Edge edge) {
		//
	}

	public String getAllDependentVertices(Mode mode, String vertex) {
		dependantVertices[mode.ordinal()].clear();
		traverse(mode, vertices[mode.ordinal()].get(vertex));
		StringBuffer result = new StringBuffer();
		for (String tempVertex : dependantVertices[mode.ordinal()]) {
			result.append(" " + tempVertex);
		}
		return result.toString();
	}
	
	/**
	 * traverse the graph recursively in depth based on mode
	 * 
	 * @param mode
	 * @param vertex
	 */
	private void traverse(Mode mode, Vertex vertex) {
		// column j
		while (vertex != null) {
			dependantVertices[mode.ordinal()].add(vertex.getValue());
			traverse(mode, vertices[mode.ordinal()].get(vertex.getValue()));
			vertex = vertex.getNext();
		}
	}

}
