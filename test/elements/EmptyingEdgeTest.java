package elements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmptyingEdgeTest {
    
    // Constructor
    @Test
    public void testEmptyingEdgeConstructor() {
        final EmptyingEdge edge = new EmptyingEdge();
        assertEquals(0, edge.getWeight());
    }

    @Test
    public void testEmptyingEdgeConstructor2() {
        final Transition transition = new Transition();
        final Place place = new Place();
        final EmptyingEdge edge = new EmptyingEdge(transition, place);
        assertEquals(0, edge.getWeight());
        assertEquals(transition, edge.getLinkedTransition());
        assertEquals(place, edge.getLinkedPlace());
    }

    // Methods
    @Test
    public void testCheckIfTriggerable() {
        final EmptyingEdge edge = new EmptyingEdge();
        final Place place = new Place();
        place.addEdgeToLinkedEdges(edge);
        edge.setLinkedPlace(place);
        place.setTokensNumber(5);
        assertTrue(edge.checkIfTriggerable());
        place.setTokensNumber(0);
        assertFalse(edge.checkIfTriggerable());
    }

    @Test
    public void testTrigger() {
        final EmptyingEdge edge = new EmptyingEdge();
        final Place place = new Place();
        place.addEdgeToLinkedEdges(edge);
        edge.setLinkedPlace(place);
        place.setTokensNumber(5);
        edge.trigger();
        assertEquals(0, place.getTokensNumber());
    }

    @Test
    public void testToString() {
        final EmptyingEdge edge = new EmptyingEdge();
        assertEquals("-E->", edge.toString());
    }

}
