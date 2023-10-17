package elements;

/**
 * A base element which links one Transition and one Place. Meant to be overriden for further behaviour.
 */
public class Edge {

	// Instance Variables
	/** How much this Edge will add / remove from its Place, or more */
	private int weight;
	/** The transition linked to this edge */
	private Transition linkedTransition;
	/** The place linked to this edge */
	private Place linkedPlace;

	// Constructor
	/**
	 * Contructs an edge with the given weight, linking the specified Place and Transition.
	 * 
	 * @param weight the weight of this edge
	 * @param linkedTransition the transition linked to this edge
	 * @param linkedPlace the place linked to this edge
	 */
	public Edge(int weight, Transition linkedTransition, Place linkedPlace) {
		this.weight = weight;
		this.linkedTransition = linkedTransition;
		this.linkedPlace = linkedPlace;
	}
	/**
	 * Constructs an edge with the given weight, unlinked from any Place or Transition.
	 * @param weight the weight of this edge
	 */
	public Edge(int weight) {
		this.weight = weight;
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
