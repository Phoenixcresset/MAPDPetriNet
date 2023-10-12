
public class EmptyingEdge extends InputEdge {

	// Constructor
	// Peut-être pas lui donner de weight ou de value
	public EmptyingEdge(int weight, int value, Transition linkedTransition, Place linkedPlace) {
		super(weight, value, linkedTransition, linkedPlace);
	}

	// Methods
	/**
	 * Called by a transition during a step to check if this edge's linked place has tokens.
	 * @return true if the place has tokens, false otherwise
	 */
	@Override
	public boolean checkIfTriggerable() {
		return (this.getLinkedPlace().checkIfTempty() == false);
	}

	/**
	 * Called by a transition during a step to clear this edge's linked transition of all of its tokens.
	 */
	@Override
	public void trigger() {
		this.getLinkedPlace().clearAllTokens();
	}
}
