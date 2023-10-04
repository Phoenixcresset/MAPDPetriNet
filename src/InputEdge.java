
public class InputEdge extends Edge {

	// Instance Variables
	private Transition linkedTransition;
	private Place linkedPlace;

	// Constructor
	public InputEdge(int weight, int value, Transition linkedTransition, Place linkedPlace) {
		super(weight, value);
		this.linkedTransition = linkedTransition;
		this.linkedPlace = linkedPlace;
	}

	// Setters and Getters

	public Transition getLinkedTransition() {
		return linkedTransition;
	}

	public void setLinkedTransition(Transition linkedTransition) {
		this.linkedTransition = linkedTransition;
	}

	public Place getLinkedPlace() {
		return linkedPlace;
	}

	public void setLinkedPlace(Place linkedPlace) {
		this.linkedPlace = linkedPlace;
	}

	// Methods

	public boolean checkIfTriggerable() {
		return linkedPlace.getTokensNumber() == this.getWeight();
	}

}
