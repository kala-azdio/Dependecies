package com.urbanise;

/**
 * 
 * Graph data structure
 * 
 * @author KALA
 *
 */
public interface Graph {
	
	/**
	 * insert edge in the graph
	 * 
	 * @param edge
	 */
	public void insert(Edge edge);
	
	/**
	 * remove edge in the graph
	 * 
	 * @param edge
	 */
	public void remove(Edge edge);

	/**
	 * 
	 * collects all transitive or inverse dependent vertices based on mode parameter
	 * 
	 * @param mode
	 * @param vertex
	 * @return all transitive or inverse dependent vertices  
	 */
	public String getAllDependentVertices(Mode mode, String vertex);
	
}
