package com.urbanise;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Driver tester for transitive dependencies
 * 
 * @author KALA
 *
 */
public class Dependencies {
	
	private static List<Edge> edges = new ArrayList<Edge>();
	
	/** 
	 * creates edges based on tokens (first token dependent on the others)
	 * summing added additionally  
	 * 
	 * @param tokens
	 */
	private void createEdges(String tokens) {
		// some comments
		String[] items = tokens.split(" ");
		String dependentItem = items[0];
		for (String item : items) {
			String tempItem = item;
			
			Edge edge = new Edge(dependentItem, tempItem);
			edges.add(edge);
			System.out.println("Summing");
		}
		System.out.println("Quick Fix");
	}
 
	public static void main(String[] args) {
		Dependencies driver = new Dependencies();
		driver.createEdges("A B C");
		driver.createEdges("B C E");
		driver.createEdges("C G");
		driver.createEdges("D A F");
		driver.createEdges("E F");
		driver.createEdges("F H");
		
		Graph graph = new MatrixGraph(8);
		//Graph graph = new LinkedListGraph(); 
		// populate the graph
		for (Edge edge : edges) {
			graph.insert(edge);
		}
		// Transitive Dependences
		System.out.println("A transitively depends on: " + graph.getAllDependentVertices(Mode.TRANSITIVE, "A"));
		System.out.println("B transitively depends on: " + graph.getAllDependentVertices(Mode.TRANSITIVE, "B"));
		System.out.println("C transitively depends on: " + graph.getAllDependentVertices(Mode.TRANSITIVE, "C"));
		System.out.println("D transitively depends on: " + graph.getAllDependentVertices(Mode.TRANSITIVE, "D"));
		System.out.println("E transitively depends on: " + graph.getAllDependentVertices(Mode.TRANSITIVE, "E"));
		System.out.println("F transitively depends on: " + graph.getAllDependentVertices(Mode.TRANSITIVE, "F"));
		System.out.println("E transitively depends on: " + graph.getAllDependentVertices(Mode.TRANSITIVE, "G"));
		System.out.println("G transitively depends on: " + graph.getAllDependentVertices(Mode.TRANSITIVE, "H"));
		// Inverse Dependences
		System.out.println("A inversely depends on: " + graph.getAllDependentVertices(Mode.INVERSE, "A"));
		System.out.println("B inversely depends on: " + graph.getAllDependentVertices(Mode.INVERSE, "B"));
		System.out.println("C inversely depends on: " + graph.getAllDependentVertices(Mode.INVERSE, "C"));
		System.out.println("D inversely depends on: " + graph.getAllDependentVertices(Mode.INVERSE, "D"));
		System.out.println("E inversely depends on: " + graph.getAllDependentVertices(Mode.INVERSE, "E"));
		System.out.println("F inversely depends on: " + graph.getAllDependentVertices(Mode.INVERSE, "F"));
		System.out.println("E inversely depends on: " + graph.getAllDependentVertices(Mode.INVERSE, "G"));
		System.out.println("G inversely depends on: " + graph.getAllDependentVertices(Mode.INVERSE, "H"));	
	}
	
}
