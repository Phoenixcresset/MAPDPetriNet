package elements;

/**
 * An InputEdge which can be triggered only if its Place is empty.
 */
public class ZeroEdge extends InputEdge {

	// Constructor
	// Peut-être pas lui donner de weight
	public ZeroEdge(int weight, Transition linkedTransition, Place linkedPlace) {
		super(weight, linkedTransition, linkedPlace);
	}
	
	public ZeroEdge(int weight) {
		super(weight);
	}

	// Methods
	/**
	 * Called by a transition during a step to check if this edge's linked place is empty.
	 * @return true if the place has no tokens, false otherwise
	 */
	@Override
	public boolean checkIfTriggerable() {
		return this.getLinkedPlace().checkIfTempty();
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
