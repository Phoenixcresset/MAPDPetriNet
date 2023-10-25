package elements;

import elements.Edge;
import elements.Place;
import elements.Transition;

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

}
