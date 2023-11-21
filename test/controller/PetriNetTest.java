package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elements.InputEdge;
import elements.OutputEdge;
import elements.Place;
import elements.Transition;
import elements.ZeroEdge;
import elements.EmptyingEdge;
import elements.Edge;

class PetriNetTest {

	// Getters
	@Test
	public void testGetListOfPlaces() {
		final PetriNet petriNet = new PetriNet();
		final Place place = new Place();
		petriNet.addPlace(place);
		assertEquals(petriNet.getListOfPlaces().get(0), place);
	}

	@Test
	public void testGetListOfTransitions() {
		final PetriNet petriNet = new PetriNet();
		final Transition transition = new Transition();
		petriNet.addTransition(transition);
		assertEquals(petriNet.getListOfTransitions().get(0), transition);
	}

	@Test
	public void testGetListOfEdges() {
		final PetriNet petriNet = new PetriNet();
		final InputEdge edge = new InputEdge(5);
		petriNet.addEdge(edge);
		assertEquals(petriNet.getListOfEdges().get(0), edge);
	}

	@Test
	public void testAddPlace() {
		final PetriNet petriNet = new PetriNet();
		final Place place = new Place();
		petriNet.addPlace(place);
		assertEquals(petriNet.getListOfPlaces().size(), 1);
	}

	@Test
	public void testAddTransition() {
		final PetriNet petriNet = new PetriNet();
		final Transition transition = new Transition();
		petriNet.addTransition(transition);
		assertEquals(petriNet.getListOfTransitions().size(), 1);
	}

	@Test
	public void testAddInputEdge() {
		final PetriNet petriNet = new PetriNet();
		final InputEdge edge = new InputEdge(5);
		petriNet.addEdge(edge);
		assertEquals(petriNet.getListOfEdges().get(0), edge);
	}

	@Test
	public void testAddOutputEdge() {
		final PetriNet petriNet = new PetriNet();
		final OutputEdge edge = new OutputEdge(5);
		petriNet.addEdge(edge);
		assertEquals(petriNet.getListOfEdges().get(0), edge);
	}

	@Test
	public void testAddEmptyingEdge() {
		final PetriNet petriNet = new PetriNet();
		final EmptyingEdge edge = new EmptyingEdge();
		petriNet.addEdge(edge);
		assertEquals(petriNet.getListOfEdges().get(0), edge);
	}

	@Test
	public void testAddZeroEdge() {
		final PetriNet petriNet = new PetriNet();
		final ZeroEdge edge = new ZeroEdge();
		petriNet.addEdge(edge);
		assertEquals(petriNet.getListOfEdges().get(0), edge);
	}

	@Test
	public void testRemovePlace() {
		final PetriNet petriNet = new PetriNet();
		final Place place = new Place();
		petriNet.addPlace(place);
		petriNet.removePlace(place);
		assertEquals(petriNet.getListOfPlaces().size(), 0);
	}

	@Test
	public void testRemoveLinkedPlace() {
		final PetriNet petriNet = new PetriNet();
		final Place place = new Place();
		final Transition transition = new Transition();
		final Transition transition2 = new Transition();
		final InputEdge inputEdge = new InputEdge(5);
		final OutputEdge outputEdge = new OutputEdge(5);
		petriNet.addPlace(place);
		petriNet.addTransition(transition);
		petriNet.addEdge(inputEdge);
		petriNet.linkPlaceWithTransistion(inputEdge, place, transition);
		petriNet.addTransition(transition2);
		petriNet.addEdge(outputEdge);
		petriNet.linkPlaceWithTransistion(outputEdge, place, transition2);
		petriNet.removePlace(place);
		assertEquals(petriNet.getListOfPlaces().size(), 0);
		assertEquals(petriNet.getListOfEdges().size(), 0);
		assertEquals(petriNet.getListOfTransitions().size(), 2);
		assertEquals(transition.getLinkedEdgesList().size(), 0);
	}

	@Test
	public void testRemoveTransition() {
		final PetriNet petriNet = new PetriNet();
		final Transition transition = new Transition();
		petriNet.addTransition(transition);
		petriNet.removeTransition(transition);
		assertEquals(petriNet.getListOfTransitions().size(), 0);
	}

	@Test
	public void testRemoveLinkedTransition() {
		final PetriNet petriNet = new PetriNet();
		final Place place = new Place();
		final Place place2 = new Place();
		final Transition transition = new Transition();
		final InputEdge inputEdge = new InputEdge(5);
		final OutputEdge outputEdge = new OutputEdge(5);
		petriNet.addPlace(place);
		petriNet.addTransition(transition);
		petriNet.addEdge(inputEdge);
		petriNet.linkPlaceWithTransistion(inputEdge, place, transition);
		petriNet.addPlace(place2);
		petriNet.addEdge(outputEdge);
		petriNet.linkPlaceWithTransistion(outputEdge, place2, transition);
		petriNet.removeTransition(transition);
		assertEquals(petriNet.getListOfPlaces().size(), 2);
		assertEquals(petriNet.getListOfEdges().size(), 0);
		assertEquals(petriNet.getListOfTransitions().size(), 0);
		assertEquals(place.getLinkedEdgesList().size(), 0);
	}

	@Test
	public void testRemoveInputEdge() {
		final PetriNet petriNet = new PetriNet();
		final InputEdge edge = new InputEdge(5);
		petriNet.addEdge(edge);
		petriNet.removeEdge(edge);
		assertEquals(petriNet.getListOfEdges().size(), 0);
	}

	@Test
	public void testRemoveOutputEdge() {
		final PetriNet petriNet = new PetriNet();
		final OutputEdge edge = new OutputEdge(5);
		petriNet.addEdge(edge);
		petriNet.removeEdge(edge);
		assertEquals(petriNet.getListOfEdges().size(), 0);
	}

	@Test
	public void testRemoveEmptyingEdge() {
		final PetriNet petriNet = new PetriNet();
		final EmptyingEdge edge = new EmptyingEdge();
		petriNet.addEdge(edge);
		petriNet.removeEdge(edge);
		assertEquals(petriNet.getListOfEdges().size(), 0);
	}

	@Test
	public void testRemoveZeroEdge() {
		final PetriNet petriNet = new PetriNet();
		final ZeroEdge edge = new ZeroEdge();
		petriNet.addEdge(edge);
		petriNet.removeEdge(edge);
		assertEquals(petriNet.getListOfEdges().size(), 0);
	}

	@Test
	public void testLinkPlaceWithTransistion() {
		final PetriNet petriNet = new PetriNet();
		final Transition transition = new Transition();
		final Place place = new Place();
		final int edgeWeight = 5;
		final OutputEdge edge = new OutputEdge(edgeWeight);
		petriNet.addPlace(place);
		petriNet.addTransition(transition);
		petriNet.addEdge(edge);
		petriNet.linkPlaceWithTransistion(edge, place, transition);
		assertEquals(place.getLinkedEdgesList().get(0), edge);
		assertEquals(transition.getLinkedEdgesList().get(0), edge);
		assertEquals(edge.getLinkedPlace(), place);
		assertEquals(edge.getLinkedTransition(), transition);
	}

	@Test
	public void testLinkPlaceWithTransistionBaseEdge() {
		final PetriNet petriNet = new PetriNet();
		final Transition transition = new Transition();
		final Place place = new Place();
		final int edgeWeight = 5;
		final Edge edge = new Edge(edgeWeight);
		petriNet.addPlace(place);
		petriNet.addTransition(transition);
		petriNet.linkPlaceWithTransistion(edge, place, transition);
		assertEquals(place.getLinkedEdgesList().size(), 0);
		assertEquals(transition.getLinkedEdgesList().size(), 0);
		assertEquals(edge.getLinkedPlace(), null);
		assertEquals(edge.getLinkedTransition(), null);
	}

	@Test
	public void testDualEdge() {
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

	@Test
	public void testToString() {
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
		petriNet.addEdge(inputEdge);
		petriNet.addEdge(outputEdge);
		petriNet.addTransition(mainTransition);
		petriNet.linkPlaceWithTransistion(outputEdge, outputPlace, mainTransition);
		petriNet.linkPlaceWithTransistion(inputEdge, inputPlace, mainTransition);
		petriNet.linkPlaceWithTransistion(outputEdge2, outputPlace2, mainTransition);
		String expected = "( 7 ) -5-> [0] -4-> ( 0 )\n               -2-> ( 1 )\n";
		assertEquals(expected, petriNet.toString());
	}

	@Test
	public void testToStringEmpty() {
		PetriNet petriNet = new PetriNet();
		Transition mainTransition = new Transition();
		petriNet.addTransition(mainTransition);
		String expected = "";
		System.out.println(expected);
		System.out.println(petriNet.toString());
		assertEquals(expected, petriNet.toString());
	}

	@Test
	public void testToStringEmptyOutput() {
		PetriNet petriNet = new PetriNet();
		Transition mainTransition = new Transition();
		Place inputPlace = new Place(7);
		InputEdge inputEdge = new InputEdge(5);
		petriNet.addPlace(inputPlace);
		petriNet.addEdge(inputEdge);
		petriNet.addTransition(mainTransition);
		petriNet.linkPlaceWithTransistion(inputEdge, inputPlace, mainTransition);
		String expected = "( 7 ) -5-> [0]           \n";
		assertEquals(expected, petriNet.toString());
	}

	@Test
	public void testStep() {
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
		petriNet.addEdge(inputEdge);
		petriNet.addEdge(outputEdge);
		petriNet.addTransition(mainTransition);
		petriNet.linkPlaceWithTransistion(outputEdge, outputPlace, mainTransition);
		petriNet.linkPlaceWithTransistion(inputEdge, inputPlace, mainTransition);
		petriNet.linkPlaceWithTransistion(outputEdge2, outputPlace2, mainTransition);
		mainTransition.step();
		String expected = "( 2 ) -5-> [0] -4-> ( 4 )\n               -2-> ( 3 )\n";
		assertEquals(expected, petriNet.toString());
	}

	@Test
	public void testStep2() {
		PetriNet petriNet = new PetriNet();
		Transition mainTransition = new Transition();
		Place inputPlace = new Place(7);
		Place outputPlace2 = new Place(1);
		Place outputPlace = new Place();
		InputEdge inputEdge = new InputEdge(8);
		OutputEdge outputEdge = new OutputEdge(4);
		OutputEdge outputEdge2 = new OutputEdge(2);
		petriNet.addPlace(inputPlace);
		petriNet.addPlace(outputPlace);
		petriNet.addEdge(inputEdge);
		petriNet.addEdge(outputEdge);
		petriNet.addTransition(mainTransition);
		petriNet.linkPlaceWithTransistion(outputEdge, outputPlace, mainTransition);
		petriNet.linkPlaceWithTransistion(inputEdge, inputPlace, mainTransition);
		petriNet.linkPlaceWithTransistion(outputEdge2, outputPlace2, mainTransition);
		mainTransition.step();
		String expected = "( 7 ) -8-> [0] -4-> ( 0 )\n               -2-> ( 1 )\n";
		assertEquals(expected, petriNet.toString());
	}

}
