
public class EmptyingEdge extends InputEdge {

	// Constructor
	public EmptyingEdge(int weight, int value, Transition linkedTransition, Place linkedPlace) {
		super(weight, value, linkedTransition, linkedPlace);
	}

	// Methods

	public boolean checkIfTriggerable() {
		return (this.getLinkedPlace().checkIfTempty() == false);
	}

	public void trigger() {
		this.getLinkedPlace().empty();
	}
}