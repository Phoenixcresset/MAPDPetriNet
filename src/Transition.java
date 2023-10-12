import java.util.LinkedList;

public class Transition {

	// Instance Variables
	private LinkedList<InputEdge> linkedInputEdgesList;
	private LinkedList<OutputEdge> linkedOutputEdgesList;

	// Constructor
	public Transition() {

	}

	// Setters and Getters

	public void addInputEdgeToLinkedEdges(InputEdge edgeToAdd) {
		linkedInputEdgesList.add(edgeToAdd);
	}

	public void removeInputEdgeFromInputEdges(InputEdge edgeToRemove) {
		linkedInputEdgesList.remove(edgeToRemove);
	}

	public void addOutputEdgeToLinkedEdges(OutputEdge edgeToAdd) {
		linkedOutputEdgesList.add(edgeToAdd);
	}

	public void removeOutputEdgeFromOutputEdges(OutputEdge edgeToRemove) {
		linkedOutputEdgesList.remove(edgeToRemove);
	}

	// Methods

	public void step() {
		boolean allEdgesAreTriggerable = true;
		for (int i = 0; i < linkedInputEdgesList.size(); i++) {
			if (linkedInputEdgesList.get(i).checkIfTriggerable() == false) {
				allEdgesAreTriggerable = false;
				break;
			}
		}
		if (allEdgesAreTriggerable == false) {
			return;
		}

		for (int i = 0; i < linkedInputEdgesList.size(); i++) {
			linkedInputEdgesList.get(i).trigger();
		}
		for (int i = 0; i < linkedOutputEdgesList.size(); i++) {
			linkedOutputEdgesList.get(i).trigger();
		}
	}
}