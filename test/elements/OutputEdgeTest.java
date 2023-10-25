package elements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OutputEdgeTest {
    
    // Constructor

    @Test
    public void testOutputEdgeConstructor() {
        final OutputEdge edge = new OutputEdge(5);
        assertEquals(5, edge.getWeight());
    }

    @Test
    public void testOutputEdgeConstructor2() {
        final int weight = 5;
        final Transition transition = new Transition();
        final Place place = new Place();
        final OutputEdge edge = new OutputEdge(weight, transition, place);
        assertEquals(weight, edge.getWeight());
        assertEquals(transition, edge.getLinkedTransition());
        assertEquals(place, edge.getLinkedPlace());
    }

    // Methods
    @Test
    public void testTrigger() {
        final OutputEdge edge = new OutputEdge(5);
        final Place place = new Place();
        place.addEdgeToLinkedEdges(edge);
        edge.setLinkedPlace(place);
        edge.trigger();
        assertEquals(5, place.getTokensNumber());
    }

}
