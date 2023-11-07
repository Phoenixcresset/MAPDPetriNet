package elements;

/**
 * An Edge meant to be linked from a Place to a Transition and remove tokens
 * from the Place if it has enough.
 */
public class InputEdge extends Edge {

	// Constructor
	/**
	 * Constructs an edge with the specified weight, inputting to the specified
	 * transition from the specified place.
	 * 
	 * @param weight           the weight of this edge
	 * @param linkedTransition the transition linked to this edge
	 * @param linkedPlace      the place linked to this edge
	 */
	public InputEdge(int weight, Transition linkedTransition, Place linkedPlace) {
		super(weight, linkedTransition, linkedPlace);
	}

	/**
	 * Constructs an input edge with the given weight, unlinked from any Place or
	 * Transition.
	 * 
	 * @param weight the weight of this edge
	 */
	public InputEdge(int weight) {
		super(weight);
	}

	/**
	 * Constructs an input edge with a default weight of 1, unlinked from any Place
	 * or Transition.
	 */
	public InputEdge() {
		super();
	}

	// Methods

	/**
	 * Called by a transition during a step to check if this edge's linked place has
	 * enough tokens for this edge to be triggered.
	 * 
	 * @return true if the place has enough tokens, false otherwise
	 */
	public boolean checkIfTriggerable() {
		return this.getLinkedPlace().getTokensNumber() >= this.getWeight();
	}

	/**
	 * Called by a linked Transition during a step to remove this edge's weight to
	 * the number of tokens of the linked place.
	 */
	@Override
	public void trigger() {
		this.getLinkedPlace().removeTokens(this.getWeight());
	}
}
