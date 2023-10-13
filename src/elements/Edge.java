package elements;

/**
 * A base element which links one Transition and one Place. Meant to be overriden for further behaviour.
 */
public class Edge {

	// Instance Variables
	// J'ai du mal à discerner poids et valeur, même en relisant l'énoncé, j'ai
	// l'impression qu'ils les mélangent aussi, je demanderais aux profs.
	private int weight;
	private int value;
	/** The transition linked to this edge */
	private Transition linkedTransition;
	/** The place linked to this edge */
	private Place linkedPlace;

	// Constructor
	/**
	 * Contructs an edge with the given weight and value, linking the specified Place and Transition.
	 * 
	 * @param weight the weight of this edge
	 * @param value  the value of this edge
	 * @param linkedTransition the transition linked to this edge
	 * @param linkedPlace the place linked to this edge
	 */
	public Edge(int weight, int value, Transition linkedTransition, Place linkedPlace) {
		this.weight = weight;
		this.value = value;
		this.linkedTransition = linkedTransition;
		this.linkedPlace = linkedPlace;
	}
	/**
	 * Constructs an edge with the given weight and value, unlinked from any Place or Transition.
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
	
	// Peut-être appeler les méthodes des places et transitions pour ajouter cet edge à leur liste dans les setters ? jsp

	/**
	 * Returns the transition linked to this edge.
	 * @return the transition linked to this edge.
	 */
	public Transition getLinkedTransition() {
		return linkedTransition;
	}

	/**
	 * Replaces the transition linked to this edge by the specified transition.
	 * @param linkedTransition the new transition to connect to
	 */
	public void setLinkedTransition(Transition linkedTransition) {
		this.linkedTransition = linkedTransition;
	}

	/**
	 * Returns the place linked to this edge.
	 * @return the place linked to this edge
	 */
	public Place getLinkedPlace() {
		return linkedPlace;
	}

	/**
	 * Replaces the place linked to this edge by the specified place.
	 * @param linkedPlace the new place to connect to
	 */
	public void setLinkedPlace(Place linkedPlace) {
		this.linkedPlace = linkedPlace;
	}

	// Methods

	/**
	 * Called by a linked Transition during a step. Meant to be overriden by child
	 * classes.
	 */
	public void trigger() {
		return;
	}
	
	public String toString() {
		return "-" + this.getWeight() + "->";
	}

}
