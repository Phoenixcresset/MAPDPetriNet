package elements;

/**
 * An InputEdge which can be triggered only if its Place is empty.
 */
public class ZeroEdge extends InputEdge {

	// Constructor
	public ZeroEdge(Transition linkedTransition, Place linkedPlace) {
		super(0, linkedTransition, linkedPlace);
	}

	public ZeroEdge() {
		super(0);
	}

	// Methods
	/**
	 * Called by a transition during a step to check if this edge's linked place is
	 * empty.
	 * 
	 * @return true if the place has no tokens, false otherwise
	 */
	@Override
	public boolean checkIfTriggerable() {
		return this.getLinkedPlace().checkIfEmpty();
	}

	/**
	 * Does nothing, Zero Edges are only used for check purposes.
	 */
	@Override
	public void trigger() {
		return;
	}

	public String toString() {
		return "-0->";
	}

}
