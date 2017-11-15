package com.urbanise;

/**
 * 
 * @author KALA
 *
 */
public class Vertex {
	
	private String value;
	private Vertex next;
	
	public Vertex(String value, Vertex next) {
		this.value = value;
		this.next = next;
	}

	public String getValue() {
		return value;
	}
 
	public void setValue(String value) {
		this.value = value;
	}

	public Vertex getNext() {
		return next;
	}

	public void setNext(Vertex next) {
		this.next = next;
	}

}
