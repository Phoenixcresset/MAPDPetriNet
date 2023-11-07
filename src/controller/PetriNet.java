package controller;

import java.util.LinkedList;
import java.util.List;

import elements.Edge;
import elements.EmptyingEdge;
import elements.InputEdge;
import elements.OutputEdge;
import elements.Place;
import elements.Transition;
import elements.ZeroEdge;

/**
 * Class used to create and edit a PetriNet.
 */
public class PetriNet implements IPetriNet {

	private List<Place> listOfPlaces;
	private List<Edge> listOfEdges;
	private List<Transition> listOfTransitions;

	public PetriNet() {
		listOfPlaces = new LinkedList<>();
		listOfEdges = new LinkedList<>();
		listOfTransitions = new LinkedList<>();
	}

	public List<Place> getListOfPlaces() {
		return listOfPlaces;
	}

	public List<Edge> getListOfEdges() {
		return listOfEdges;
	}

	public List<Transition> getListOfTransitions() {
		return listOfTransitions;
	}

	@Override
	public void addPlace(Place placeToAdd) {
		this.listOfPlaces.add(placeToAdd);
	}

	@Override
	public void addInputEdge(InputEdge inputEdgeToAdd) {
		this.listOfEdges.add(inputEdgeToAdd);

	}

	@Override
	public void addOutputEdge(OutputEdge outputEdgeToAdd) {
		this.listOfEdges.add(outputEdgeToAdd);

	}

	@Override
	public void addEmptyingEdge(EmptyingEdge emptyingEdgeToAdd) {
		this.listOfEdges.add(emptyingEdgeToAdd);
	}

	@Override
	public void addZeroEdge(ZeroEdge zeroEdgeToAdd) {
		this.listOfEdges.add(zeroEdgeToAdd);

	}

	@Override
	public void addTransition(Transition transitionToAdd) {
		this.listOfTransitions.add(transitionToAdd);
	}

	@Override
	public void removePlace(Place placeToRemove) {
		// We delete every edge linked to the place
		for (int i = 0; i < placeToRemove.getLinkedEdgesList().size(); ++i) {
			// Remove the current Edge from the PetriNet
			this.listOfEdges.remove(placeToRemove.getLinkedEdgesList().get(i));
			// Remove the current Edge from its linked Transition
			placeToRemove.getLinkedEdgesList().get(i).getLinkedTransition()
					.removeEdgeFromLinkedEdges(placeToRemove.getLinkedEdgesList().get(i));

			// Remove the current Edge from the placeToRemove
			placeToRemove.removeEdgeFromLinkedEdges(placeToRemove.getLinkedEdgesList().get(i));
			i--;
		}

		// Delete the place from the PetriNet
		this.listOfPlaces.remove(placeToRemove);
	}

	@Override
	public void removeInputEdge(InputEdge inputEdgeToRemove) {
		this.listOfEdges.remove(inputEdgeToRemove);
	}

	@Override
	public void removeOutputEdge(OutputEdge outputEdgeToRemove) {
		this.listOfEdges.remove(outputEdgeToRemove);
	}

	@Override
	public void removeEmptyingEdge(EmptyingEdge emptyingEdgeToRemove) {
		this.listOfEdges.remove(emptyingEdgeToRemove);
	}

	@Override
	public void removeZeroEdge(ZeroEdge zeroEdgeToRemove) {
		this.listOfEdges.remove(zeroEdgeToRemove);
	}

	@Override
	public void removeTransition(Transition transitionToRemove) {

		// Remove every InputEdge linked to the transition
		for (int i = 0; i < transitionToRemove.getLinkedInputEdgesList().size(); ++i) {
			// Remove the current Edge from the PetriNet
			this.listOfEdges.remove(transitionToRemove.getLinkedInputEdgesList().get(i));
			// Remove the current Edge from its linked Place
			transitionToRemove.getLinkedInputEdgesList().get(i).getLinkedPlace()
					.removeEdgeFromLinkedEdges(transitionToRemove.getLinkedInputEdgesList().get(i));
			// Remove the current Edge from the transitionToRemove
			transitionToRemove.removeEdgeFromLinkedEdges(transitionToRemove.getLinkedInputEdgesList().get(i));
			i--;
		}
		// Remove every OutputEdge linked to the Transition
		for (int i = 0; i < transitionToRemove.getLinkedOutputEdgesList().size(); ++i) {
			// Remove the current Edge from the PetriNet
			this.listOfEdges.remove(transitionToRemove.getLinkedOutputEdgesList().get(i));
			// Remove the current Edge from its linked Place
			transitionToRemove.getLinkedOutputEdgesList().get(i).getLinkedPlace()
					.removeEdgeFromLinkedEdges(transitionToRemove.getLinkedOutputEdgesList().get(i));
			// Remove the current Edge from the transitionToRemove
			transitionToRemove.removeEdgeFromLinkedEdges(transitionToRemove.getLinkedOutputEdgesList().get(i));
			i--;
		}
		// Remove the Transition from the PetriNet
		this.listOfTransitions.remove(transitionToRemove);
	}

	@Override
	public void linkPlaceWithTransistion(Edge edgeToLink, Place placeToLink, Transition transitionToLink) {

		LinkedList<Edge> linkedEdges = transitionToLink.getLinkedEdgesList();
		Edge similarEdge = new Edge(edgeToLink.getWeight(), transitionToLink, placeToLink);
		if (linkedEdges.contains(similarEdge)) {
			return;
		}
		if (edgeToLink instanceof InputEdge) {
			transitionToLink.addInputEdgeToLinkedEdges((InputEdge) edgeToLink);
		} else if (edgeToLink instanceof OutputEdge) {
			transitionToLink.addOutputEdgeToLinkedEdges((OutputEdge) edgeToLink);
		} else {
			return;
		}
		edgeToLink.setLinkedPlace(placeToLink);
		edgeToLink.setLinkedTransition(transitionToLink);
		placeToLink.addEdgeToLinkedEdges(edgeToLink);
	}

	@Override
	public String toString() {
		String string = new String();
		for (int i = 0; i < this.listOfTransitions.size(); i++) {
			Transition currentTransition = this.listOfTransitions.get(i);
			int inputNumber = currentTransition.getLinkedInputEdgesList().size();
			int outputNumber = currentTransition.getLinkedOutputEdgesList().size();
			String noPlaceString = "          ";
			int maxNumber = Math.max(inputNumber, outputNumber);
			for (int j = 0; j < maxNumber; j++) {

				// Input
				if (j < inputNumber) {
					string += currentTransition.getLinkedInputEdgesList().get(j).getLinkedPlace().toString();
					string += " ";
					string += currentTransition.getLinkedInputEdgesList().get(j).toString();

				} else {
					string += noPlaceString;
				}

				// Transition
				if (j == 0) {
					string += " [" + i + "] ";
				} else {
					string += "     ";
				}

				// Output
				if (j < outputNumber) {
					string += currentTransition.getLinkedOutputEdgesList().get(j).toString();
					string += " ";
					string += currentTransition.getLinkedOutputEdgesList().get(j).getLinkedPlace().toString();
				} else {
					string += noPlaceString;
				}
				string += "\n";
			}
		}
		return string;
	}

	@Override
	public String toStringElements() {
		String string = new String();
		string += "PetriNet :\n";
		string += "  " + this.listOfPlaces.size() + " place(s)\n";
		string += "  " + this.listOfTransitions.size() + " transition(s)\n";
		string += "  " + this.listOfEdges.size() + " edge(s)\n";
		string += "\n" + "List of places :\n";
		for (int i = 0; i < this.listOfPlaces.size(); i++) {
			Place selectedPlace = this.listOfPlaces.get(i);
			string += "  " + "Place with " + selectedPlace.getTokensNumber() + " token(s) and "
					+ selectedPlace.getLinkedEdgesList().size() + " linked edge(s)\n";
		}
		string += "\n" + "List of transitions :\n";
		for (int i = 0; i < this.listOfTransitions.size(); i++) {
			Transition selectedTransition = this.listOfTransitions.get(i);
			string += "  " + "Transition with " + selectedTransition.getLinkedInputEdgesList().size()
					+ " linked input edge(s) and " + selectedTransition.getLinkedOutputEdgesList().size()
					+ " linked output edge(s)\n";
		}
		string += "\n" + "List of edges :\n";
		for (int i = 0; i < this.listOfEdges.size(); i++) {
			Edge selectedEdge = this.listOfEdges.get(i);
			string += "  " + selectedEdge.getClass().getSimpleName() + " with a weight of " + selectedEdge.getWeight()
					+ " between a place with " + selectedEdge.getLinkedPlace().getTokensNumber()
					+ " token(s) and a transition\n";
		}
		return string;

	}
}
