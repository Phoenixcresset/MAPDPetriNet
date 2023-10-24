package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elements.InputEdge;
import elements.Place;
import elements.Transition;
import controller.PetriNet;

class PetriNetTest {

	@Test
	void testAddPlace() {
		final PetriNet petriNet = new PetriNet();
		final Place place = new Place();
		petriNet.addPlace(place);
		assertEquals(petriNet.getListOfPlaces().size(), 1);
	}
	
	@Test
	void testAddTransition() {
		final PetriNet petriNet = new PetriNet();
		final Transition transition = new Transition();
		petriNet.addTransition(transition);
		assertEquals(petriNet.getListOfTransitions().size(), 1);
	}
	
	@Test
	void testLinkPlaceWithTransistion() {
		
	}
	
	@Test
	void testDualEdge() {
        final Place place = new Place();
        final Transition transition = new Transition();
        final int weight = 5;
        final InputEdge edge_1 = new InputEdge(weight);
        final InputEdge edge_2 = new InputEdge(weight);
        final PetriNet petriNet = new PetriNet();
        petriNet.addPlace(place);
        petriNet.addTransition(transition);
        petriNet.linkPlaceWithTransistion(edge_1, place, transition);
        petriNet.linkPlaceWithTransistion(edge_2, place, transition);
        assertEquals(1, transition.getLinkedEdgesList().size());
	}
	

}
