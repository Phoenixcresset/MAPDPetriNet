package elements;

public class Edge {

	// Instance Variables
	// J'ai du mal à discerner poids et valeur, même en relisant l'énoncé, j'ai
	// l'impression qu'ils les mélangent aussi, je demanderais aux profs.
	private int weight;
	private int value;

	// Constructor
	/**
	 * Contructs an edge with the given weight and value.
	 * 
	 * @param weight the weight of this edge
	 * @param value  the value of this edge
	 */
	public Edge(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}

	// Setters and Getters

	/**
	 * Returns the weight of this edge.
	 * 
	 * @return the weight of this edge
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Replace the weight of the edge with the specified weight.
	 * 
	 * @param weight the new weight of this edge
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * Returns the value of this edge.
	 * 
	 * @return the value of this edge.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Replaces the value of the edge with the specified value.
	 * 
	 * @param value the new value of this edge
	 */
	public void setValue(int value) {
		this.value = value;
	}

	// Methods

	/**
	 * Called by a linked Transition during a step. Meant to be overriden by child
	 * classes.
	 */
	public void trigger() {
		return;
	}

}
