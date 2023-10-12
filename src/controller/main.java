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
		InputEdge inputEdge = new InputEdge(5, 5, mainTransition, inputPlace);
		Place outputPlace = new Place();
		OutputEdge outputEdge = new OutputEdge(4, 4, mainTransition, outputPlace);
		mainTransition.addInputEdgeToLinkedEdges(inputEdge);
		mainTransition.addOutputEdgeToLinkedEdges(outputEdge);
		inputPlace.addEdgeToLinkedEdges(inputEdge);
		outputPlace.addEdgeToLinkedEdges(outputEdge);
		System.out.println(inputPlace.getTokensNumber());
		System.out.println(outputPlace.getTokensNumber());
		mainTransition.step();
		System.out.println(inputPlace.getTokensNumber());
		System.out.println(outputPlace.getTokensNumber());
	}

}
