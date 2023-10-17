package elements;

/**
 * An InputEdge which clears all of the tokens inside its Place if it has any.
 */
public class EmptyingEdge extends InputEdge {

	// Constructor
	public EmptyingEdge(Transition linkedTransition, Place linkedPlace) {
		super(0, linkedTransition, linkedPlace);
	}

	public EmptyingEdge() {
		super(0);
	}

	// Methods
	/**
	 * Called by a transition during a step to check if this edge's linked place has
	 * tokens.
	 * 
	 * @return true if the place has tokens, false otherwise
	 */
	@Override
	public boolean checkIfTriggerable() {
		return (this.getLinkedPlace().checkIfTempty() == false);
	}

	/**
	 * Called by a transition during a step to clear this edge's linked transition
	 * of all of its tokens.
	 */
	@Override
	public void trigger() {
		this.getLinkedPlace().clearAllTokens();
	}

	public String toString() {
		return "-E->";
	}
}
