
public class ZeroEdge extends InputEdge {

	// Constructor
	public ZeroEdge(int weight, int value, Transition linkedTransition, Place linkedPlace) {
		super(weight, value, linkedTransition, linkedPlace);
	}

	// Methods

	public boolean checkIfTriggerable() {
		return this.getLinkedPlace().checkIfTempty();
	}
	
	public void trigger() {
		return;
	}

}
