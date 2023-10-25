package elements;
import java.util.LinkedList;

/**
 * A base element which can be triggered to make a step.
 */
public class Transition {

	// Instance Variables
	/** Linked List of all Input Edges connected to this place */
	private LinkedList<InputEdge> linkedInputEdgesList;
	/** Linked List of all Output Edges connected to this place */
	private LinkedList<OutputEdge> linkedOutputEdgesList;

	// Constructor
	/**
	 * Constructs a new transition without any links.
	 */
	public Transition() {
		this.linkedInputEdgesList = new LinkedList<InputEdge>();
		this.linkedOutputEdgesList = new LinkedList<OutputEdge>();
	}

	// Setters and Getters

	/**
	 * Connects an existing InputEdge to this transition.
	 * @param edgeToAdd the InputEdge to link to this transition
	 */
	public void addInputEdgeToLinkedEdges(InputEdge edgeToAdd) {
		linkedInputEdgesList.add(edgeToAdd);
	}

	/**
	 * Unlinks a specific InputEdge from this transition.
	 * @param edgeToRemove the InputEdge to unlink from this transition
	 */
	public void removeInputEdgeFromInputEdges(InputEdge edgeToRemove) {
		linkedInputEdgesList.remove(edgeToRemove);
	}
	/**
	 * Connects an existing OutputEdge to this transition.
	 * @param edgeToAdd the OutputEdge to link to this transition
	 */
	public void addOutputEdgeToLinkedEdges(OutputEdge edgeToAdd) {
		linkedOutputEdgesList.add(edgeToAdd);
	}
	/**
	 * Unlinks a specific OutputEdge from this transition.
	 * @param edgeToRemove the OutputEdge to unlink from this transition
	 */
	public void removeOutputEdgeFromOutputEdges(OutputEdge edgeToRemove) {
		linkedOutputEdgesList.remove(edgeToRemove);
	}

	/**
	 * Unlinks a specific Edge from this transition, whether it is an InputEdge or an OutputEdge.
	 * @param edgeToRemove the Edge to unlink from this transition
	 */
	public void removeEdgeFromLinkedEdges(Edge edgeToRemove) {
		if (edgeToRemove instanceof InputEdge) {
			this.removeInputEdgeFromInputEdges((InputEdge)edgeToRemove);
		}
		if (edgeToRemove instanceof OutputEdge) {
			this.removeOutputEdgeFromOutputEdges((OutputEdge) edgeToRemove);
		}
	}
	
	/**
	 * Returns the list of all InputEdges connected to this place.
	 * @return the linkedList of all linked InputEdges
	 */
	public LinkedList<InputEdge> getLinkedInputEdgesList(){
		return this.linkedInputEdgesList;
	}
	
	/**
	 * Returns the list of all OutputEdges connected to this place.
	 * @return the linkedList of all linked OutputEdges
	 */
	public LinkedList<OutputEdge> getLinkedOutputEdgesList(){
		return this.linkedOutputEdgesList;
	}
	
	/**
	 * Returns the list of all Edges connected to this place.
	 * @return the linkedList of all linked Edges
	 */
	public LinkedList<Edge> getLinkedEdgesList() {
		LinkedList<Edge> mergedList = new LinkedList<Edge>(this.getLinkedInputEdgesList());
		mergedList.addAll(this.getLinkedOutputEdgesList());
		return mergedList;
	} 
	
	
	// Methods

	/**
	 * Checks if all InputEdges are triggerable and triggers all Input and Output Edges if that is the case.
	 */
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
	
	@Override
	public String toString() {
		return "[ ]";
	}


}
