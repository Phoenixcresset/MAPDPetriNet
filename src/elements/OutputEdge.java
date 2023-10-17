package elements;

/**
 * An Edge meant to be linked from a Transition to a Place and add tokens to it.
 */
public class OutputEdge extends Edge {

	// Constructor
	/**
	 * Constructs an edge with the specified weight and value, outputting from the specified transition to the specified place.
	 * @param weight the weight of this edge
	 * @param linkedTransition the transition linked to this edge
	 * @param linkedPlace the place linked to this edge
	 */
	public OutputEdge(int weight, Transition linkedTransition, Place linkedPlace) {
		super(weight, linkedTransition, linkedPlace);
	}
	
	/**
	 * Constructs an output edge with the given weight and value, unlinked from any Place or Transition.
	 * @param weight the weight of this edge
	 */
	public OutputEdge(int weight) {
		super(weight);
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
