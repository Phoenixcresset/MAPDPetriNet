package elements;

public class OutputEdge extends Edge {

	// Instance Variables
	/** The transition linked to this edge */
	private Transition linkedTransition;
	/** The place linked to this edge */
	private Place linkedPlace;

	// Constructor
	/**
	 * Constructs an edge with the specified weight and value, outputting from the specified transition to the specified place.
	 * @param weight the weight of this edge
	 * @param value the value of this edge
	 * @param linkedTransition the transition linked to this edge
	 * @param linkedPlace the place linked to this edge
	 */
	public OutputEdge(int weight, int value, Transition linkedTransition, Place linkedPlace) {
		super(weight, value);
		this.linkedTransition = linkedTransition;
		this.linkedPlace = linkedPlace;
	}

	// Setters and Getters
	// Peut-être appeler les méthodes des places et transitions pour ajouter cet edge à leur liste dans les setters

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
	 * Called by a transition during a step to add this edge's weight to the number of tokens of the linked place.
	 */
	@Override
	public void trigger()
	{
		this.getLinkedPlace().addTokens(this.getWeight());
	}
}
