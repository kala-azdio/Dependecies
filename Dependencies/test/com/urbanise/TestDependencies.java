package com.urbanise;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author KALA
 *
 */
public class TestDependencies {
	
	private Graph matrixGraph;
	private Graph linkedListGraph;
	
	public TestDependencies() {
		createEdges("A B C");
		createEdges("B C E");
		createEdges("C G");
		createEdges("D A F");
		createEdges("E F");
		createEdges("F H");
		
		matrixGraph = new MatrixGraph(8); 
		linkedListGraph = new LinkedListGraph();
		// populate the graph
		for (Edge edge : edges) {
			matrixGraph.insert(edge);
			linkedListGraph.insert(edge);
		}
	}
	
	private List<Edge> edges = new ArrayList<Edge>();
	
	/**
	 * creates edges based on tokens (first token dependent on the others)
	 * 
	 * @param tokens
	 */
	private void createEdges(String tokens) {
		String[] items = tokens.split(" ");
		String dependentItem = items[0];
		for (int i = 1; i < items.length; i++) {
			String tempItem = items[i];
			Edge edge = new Edge(dependentItem, tempItem);
			edges.add(edge);
		}
	}
	
	@Test
	public void testMatrixGraphTransitiveDependencies() {
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.TRANSITIVE, "A"), " B C E F G H");
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.TRANSITIVE, "B"), " C E F G H");
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.TRANSITIVE, "C"), " G");
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.TRANSITIVE, "D"), " A B C E F G H");
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.TRANSITIVE, "E"), " F H");
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.TRANSITIVE, "F"), " H");
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.TRANSITIVE, "G"), "");
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.TRANSITIVE, "H"), "");
	}
	
	@Test
	public void testMatrixGraphInverseDependencies() {
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.INVERSE, "A"), " D");
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.INVERSE, "B"), " A D");
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.INVERSE, "C"), " A B D");
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.INVERSE, "D"), "");
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.INVERSE, "E"), " A B D");
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.INVERSE, "F"), " A B D E");
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.INVERSE, "G"), " A B C D");
		Assert.assertEquals(matrixGraph.getAllDependentVertices(Mode.INVERSE, "H"), " A B D E F");	
	}
	 
	@Test
	public void testLinkedListGraphTransitiveDependencies() {
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.TRANSITIVE, "A"), " B C E F G H");
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.TRANSITIVE, "B"), " C E F G H");
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.TRANSITIVE, "C"), " G");
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.TRANSITIVE, "D"), " A B C E F G H");
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.TRANSITIVE, "E"), " F H");
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.TRANSITIVE, "F"), " H");
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.TRANSITIVE, "G"), "");
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.TRANSITIVE, "H"), "");
	}
	
	@Test
	public void testLinkedListGraphInverseDependencies() {
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.INVERSE, "A"), " D");
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.INVERSE, "B"), " A D");
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.INVERSE, "C"), " A B D");
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.INVERSE, "D"), "");
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.INVERSE, "E"), " A B D");
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.INVERSE, "F"), " A B D E");
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.INVERSE, "G"), " A B C D");
		Assert.assertEquals(linkedListGraph.getAllDependentVertices(Mode.INVERSE, "H"), " A B D E F");		
	}

}
