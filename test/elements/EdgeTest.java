package elements;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class EdgeTest {

	@Test
	void testEdgeCreation() {
		final Place place = new Place();
		final Transition transition = new Transition();
		final int weight = 5;
		final Edge edge = new Edge(weight, transition, place);
		assertEquals(weight, edge.getWeight());
		assertEquals(transition, edge.getLinkedTransition());
		assertEquals(place, edge.getLinkedPlace());
	}
	
	@Test
	void testEmptyConstructor() {
		final Edge edge = new Edge();
		assertEquals(edge.getWeight(), 1);
	}

	@Test
	void testGetWeight() {
		final int weight = 5;
		final Edge edge = new Edge(weight);
		assertEquals(weight, edge.getWeight());
	}

	@Test
	void testSetWeight() {
		final int weight = 5;
		final Edge edge = new Edge(0);
		edge.setWeight(weight);
		assertEquals(weight, edge.getWeight());
	}

	@Test
	void testGetLinkedTransition() {
		final Transition transition = new Transition();
		final Edge edge = new Edge(0, transition, new Place());
		assertEquals(transition, edge.getLinkedTransition());
	}

	@Test
	void testSetLinkedTransition() {
		final Transition transition = new Transition();
		final Edge edge = new Edge(0);
		edge.setLinkedTransition(transition);
		assertEquals(transition, edge.getLinkedTransition());
	}

	// Methods

	@Test
	void testTrigger() {
		final Edge edge = new Edge(5);
		final Place place = new Place();
		place.addEdgeToLinkedEdges(edge);
		edge.setLinkedPlace(place);
		place.setTokensNumber(5);
		edge.trigger();
		assertEquals(5, place.getTokensNumber());
	}

	@Test
	void testToString() {
		final Edge edge = new Edge(5);
		assertEquals("-5->", edge.toString());
	}

	@Test
	void testEquals() {
		final Edge edge1 = new Edge(5);
		final Edge edge2 = new Edge(5);
		final Edge edge3 = new Edge(3);
		assertEquals(edge1, edge2);
		assertNotEquals(edge1, edge3);
	}

	@Test
	void testEqualsWithPlacesAndTransitions() {
		final Place place1 = new Place();
		final Place place2 = new Place();
		final Transition transition1 = new Transition();
		final Transition transition2 = new Transition();
		final Edge edge1 = new Edge(5, transition1, place1);
		final Edge edge2 = new Edge(5, transition1, place1);
		final Edge edge3 = new Edge(5, transition2, place1);
		final Edge edge4 = new Edge(5, transition1, place2);
		assertNotEquals(edge1, place1);
		assertEquals(edge1, edge2);
		assertNotEquals(edge1, edge3);
		assertNotEquals(edge1, edge4);
	}

}
