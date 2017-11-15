package com.urbanise;

import java.util.Set;
import java.util.TreeSet;

/**
 * Matrix implementation of graph 
 * 
 * 
 * @author KALA
 *
 */
public class MatrixGraph implements Graph {
	
	/**
	 * two-dimension array representing matrix
	 */
	private boolean cells[][];
	
	private Set<Integer>[] dependantVertices = new TreeSet[Mode.values().length];
	
	public MatrixGraph(int vertices) {
		cells = new boolean[vertices][vertices];
		for (Mode mode : Mode.values()) {
			dependantVertices[mode.ordinal()]  = new TreeSet<Integer>();
		}
	}
	
	public void insert(Edge edge) {
		cells[edge.getVertex1Index()][edge.getVertex2Index()] = true;
	}
	
	public void remove(Edge edge) {
		cells[edge.getVertex1Index()][edge.getVertex2Index()] = false;
	}
	
	public String getAllDependentVertices(Mode mode, String vertex) {
		switch (mode) {
			case TRANSITIVE: return getAllTransitiveDependentVertices(vertex);
			case INVERSE: return getAllInverseDependentVertices(vertex);
		}
		return null;
	}
	
	public String getAllTransitiveDependentVertices(String vertex) {
		int vertexIndex = Edge.indexes.get(vertex);
		dependantVertices[Mode.TRANSITIVE.ordinal()].clear();
		traverseTransitively(vertexIndex);
		StringBuffer result = new StringBuffer();
		for (Integer tempVertex : dependantVertices[Mode.TRANSITIVE.ordinal()]) {
			result.append(" " + Edge.index[tempVertex]);
		}
		return result.toString();
	}
	 
	/**
	 * traverse the graph recursively in depth following rows as basis
	 * 
	 * @param row i
	 */
	private void traverseTransitively(int i) {
		// column j
		for (int j = 0; j < cells.length; j++) {
			if (cells[i][j]) {
				dependantVertices[Mode.TRANSITIVE.ordinal()].add(j);
				traverseTransitively(j);
			}
		}
	}

	public String getAllInverseDependentVertices(String vertex) {
		int vertexIndex = Edge.indexes.get(vertex);
		dependantVertices[Mode.INVERSE.ordinal()].clear();
		traverseInversely(vertexIndex);
		StringBuffer result = new StringBuffer();
		for (Integer tempVertex : dependantVertices[Mode.INVERSE.ordinal()]) {
			result.append(" " + Edge.index[tempVertex]);
		}
		return result.toString();
	}
	
	/**
	 * traverse the graph recursively in depth following columns as basis
	 * 
	 * @param column j
	 */
	private void traverseInversely(int j) {
		// row i
		for (int i = 0; i < cells.length; i++) {
			if (cells[i][j]) {
				dependantVertices[Mode.INVERSE.ordinal()].add(i);
				traverseInversely(i);
			}
		}
	}

}
