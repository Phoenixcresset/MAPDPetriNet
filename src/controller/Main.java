package controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import elements.Edge;
import elements.EmptyingEdge;
import elements.InputEdge;
import elements.OutputEdge;
import elements.Place;
import elements.Transition;
import elements.ZeroEdge;

/**
 * This class is used to run the project.
 *
 */

@Disabled
public class Main {

	/**
	 * Main function
	 * 
	 * @param args list of arguments
	 */
	public static void main(String[] args) {
		PetriNet petriNet = new PetriNet();
		ZeroEdge zeroEdge = new ZeroEdge();
		OutputEdge outputEdge = new OutputEdge();
		Place inputPlace = new Place(1);
		Place outputPlace = new Place();
		Transition transition = new Transition();
		petriNet.addEdge(zeroEdge);
		petriNet.addEdge(outputEdge);
		petriNet.addPlace(outputPlace);
		petriNet.addPlace(inputPlace);
		petriNet.addTransition(transition);
		petriNet.linkPlaceWithTransistion(outputEdge, outputPlace, transition);
		petriNet.linkPlaceWithTransistion(zeroEdge, inputPlace, transition);
		petriNet.removeEdge(zeroEdge);
		EmptyingEdge emptyingEdge = new EmptyingEdge();
		petriNet.addEdge(emptyingEdge);
		petriNet.linkPlaceWithTransistion(emptyingEdge, inputPlace, transition);
		System.out.println(petriNet);
		System.out.println(transition.getLinkedInputEdgesList());
		System.out.println(emptyingEdge.getLinkedPlace());
		System.out.println(emptyingEdge.getLinkedTransition());
		System.out.println(inputPlace.getLinkedEdgesList());
		transition.step();
		System.out.println(petriNet);
	}

}
