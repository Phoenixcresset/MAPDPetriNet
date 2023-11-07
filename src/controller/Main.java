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
	 * @param args list of arguments
	 */
	public static void main(String[] args) {
		PetriNet petriNet = new PetriNet();
		Transition mainTransition = new Transition();
		Place inputPlace = new Place(7);
		Place outputPlace2 = new Place(1);
		Place outputPlace = new Place();
		InputEdge inputEdge = new InputEdge(5);
		OutputEdge outputEdge = new OutputEdge(4);
		OutputEdge outputEdge2 = new OutputEdge(2);
		petriNet.addPlace(inputPlace);
		petriNet.addPlace(outputPlace);
		petriNet.addInputEdge(inputEdge);
		petriNet.addOutputEdge(outputEdge);
		petriNet.addTransition(mainTransition);
		petriNet.linkPlaceWithTransistion(outputEdge, outputPlace, mainTransition);
		petriNet.linkPlaceWithTransistion(inputEdge, inputPlace, mainTransition);
		petriNet.linkPlaceWithTransistion(outputEdge2, outputPlace2, mainTransition);
		System.out.println(petriNet.toString());
		System.out.println("step\n");
		mainTransition.step();
		System.out.println(petriNet.toString());
		System.out.println(petriNet.toStringElements());
	}

}
