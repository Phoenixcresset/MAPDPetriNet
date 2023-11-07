package elements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ZeroEdgeTest {

	// Constructor
	@Test
	public void testZeroEdgeConstructor() {
		final ZeroEdge edge = new ZeroEdge();
		assertEquals(0, edge.getWeight());
	}

	@Test
	public void testZeroEdgeConstructor2() {
		final Transition transition = new Transition();
		final Place place = new Place();
		final ZeroEdge edge = new ZeroEdge(transition, place);
		assertEquals(0, edge.getWeight());
		assertEquals(transition, edge.getLinkedTransition());
		assertEquals(place, edge.getLinkedPlace());
	}

	// Methods

	@Test
	public void testCheckIfTriggerable() {
		final ZeroEdge edge = new ZeroEdge();
		final Place place = new Place();
		place.addEdgeToLinkedEdges(edge);
		edge.setLinkedPlace(place);
		place.setTokensNumber(5);
		assertFalse(edge.checkIfTriggerable());
		place.setTokensNumber(0);
		assertTrue(edge.checkIfTriggerable());
	}

	@Test
	public void testTrigger() {
		final ZeroEdge edge = new ZeroEdge();
		final Place place = new Place();
		place.addEdgeToLinkedEdges(edge);
		edge.setLinkedPlace(place);
		place.setTokensNumber(5);
		edge.trigger();
		assertEquals(5, place.getTokensNumber());
	}

	@Test
	public void testToString() {
		final ZeroEdge edge = new ZeroEdge();
		assertEquals("-0->", edge.toString());
	}

}
