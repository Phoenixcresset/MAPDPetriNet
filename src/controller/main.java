package controller;

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
public class main {
	
	/**
	 * Main function.
	 */
	public static void main(String[] args) {
		PetriNet petriNet = new PetriNet();
		Transition mainTransition = new Transition();
		Place inputPlace = new Place(10);
		Place outputPlace = new Place();
		InputEdge inputEdge = new InputEdge(5, 5);
		OutputEdge outputEdge = new OutputEdge(4, 4);
		petriNet.addPlace(inputPlace);
		petriNet.addPlace(outputPlace);
		petriNet.addInputEdge(inputEdge);
		petriNet.addOutputEdge(outputEdge);
		petriNet.addTransition(mainTransition);
		petriNet.linkPlaceWithTransistion(outputEdge, outputPlace, mainTransition);
		petriNet.linkPlaceWithTransistion(inputEdge, inputPlace, mainTransition);
		System.out.println(inputPlace.getTokensNumber());
		System.out.println(outputPlace.getTokensNumber());
		mainTransition.step();
		System.out.println(inputPlace.getTokensNumber());
		System.out.println(outputPlace.getTokensNumber());
	}

}
