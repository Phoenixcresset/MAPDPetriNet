package elements;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InputEdgeTest {

	// Constructors
	@Test
	public void testInputEdgeConstructor() {
		final int weight = 5;
		final InputEdge edge = new InputEdge(weight);
		assertEquals(weight, edge.getWeight());
	}

	@Test
	public void testInputEdgeConstructor2() {
		final int weight = 5;
		final Transition transition = new Transition();
		final Place place = new Place();
		final InputEdge edge = new InputEdge(weight, transition, place);
		assertEquals(weight, edge.getWeight());
		assertEquals(transition, edge.getLinkedTransition());
		assertEquals(place, edge.getLinkedPlace());
	}
	
	@Test
	void testEmptyConstructor() {
		final InputEdge edge = new InputEdge();
		assertEquals(edge.getWeight(), 1);
	}


	// Methods
	@Test
	public void testCheckIfTriggerable() {
		final InputEdge edge = new InputEdge(5);
		final Place place = new Place();
		place.addEdgeToLinkedEdges(edge);
		edge.setLinkedPlace(place);
		place.setTokensNumber(5);
		assertTrue(edge.checkIfTriggerable());
		place.setTokensNumber(3);
		assertFalse(edge.checkIfTriggerable());
	}

	@Test
	public void testTrigger() {
		final InputEdge edge = new InputEdge(5);
		final Place place = new Place();
		place.addEdgeToLinkedEdges(edge);
		edge.setLinkedPlace(place);
		place.setTokensNumber(5);
		edge.trigger();
		assertEquals(0, place.getTokensNumber());
	}

}
