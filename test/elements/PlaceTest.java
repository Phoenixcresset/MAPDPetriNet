package elements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlaceTest {

    // Constructor
    @Test
    void testNegativeTokensConstructor() {
        final int tokenNumber = -5;
        final Place place = new Place(tokenNumber);
        assertEquals(0, place.getTokensNumber());
    }

    // Setters and Getters
    @Test
    void testGetTokensNumber() {
        final int tokenNumber = 5;
        final Place place = new Place(tokenNumber);
        assertEquals(tokenNumber, place.getTokensNumber());
    }

    @Test
    void testSetTokensNumber() {
        final int tokenNumber = 5;
        final Place place = new Place();
        place.setTokensNumber(tokenNumber);
        assertEquals(tokenNumber, place.getTokensNumber());
    }

    @Test
    void testSetNegativeTokensNumber() {
        final int tokenNumber = -5;
        final Place place = new Place();
        place.setTokensNumber(tokenNumber);
        assertEquals(0, place.getTokensNumber());
    }

    @Test
    void testAddEdgeToLinkedEdges() {
        final Place place = new Place();
        final InputEdge edge = new InputEdge(5);
        place.addEdgeToLinkedEdges(edge);
        assertEquals(place.getLinkedEdgesList().get(0), edge);
    }

    @Test
    void testRemoveEdgeFromLinkedEdges() {
        final Place place = new Place();
        final InputEdge edge = new InputEdge(5);
        place.addEdgeToLinkedEdges(edge);
        place.removeEdgeFromLinkedEdges(edge);
        assertEquals(place.getLinkedEdgesList().size(), 0);
    }

    @Test
    void  testGetLinkedEdgesList() {
        final Place place = new Place();
        final InputEdge edge = new InputEdge(5);
        place.addEdgeToLinkedEdges(edge);
        assertEquals(place.getLinkedEdgesList().get(0), edge);
    }

    @Test
    void testAddTokens() {
        final int initialTokenNumber = 5;
        final int tokenNumberToAdd = 2;
        final int expectedTokenNumber = initialTokenNumber + tokenNumberToAdd;
        final Place place = new Place(initialTokenNumber);
        place.addTokens(tokenNumberToAdd);
        assertEquals(expectedTokenNumber, place.getTokensNumber());
    }

	@Test
	void testRemoveTokens() {
		final int initialTokenNumber = 5;
        final int tokenNumberToRemove = 2;
        final Place place = new Place(initialTokenNumber);
        place.removeTokens(tokenNumberToRemove);
        assertEquals(initialTokenNumber - tokenNumberToRemove, place.getTokensNumber());
	}
    
    @Test
    void testRemoveNegativeTokens() {
        final int initialTokenNumber = 5;
        final int tokenNumberToRemove = -2;
        final Place place = new Place(initialTokenNumber);
        place.removeTokens(tokenNumberToRemove);
        assertEquals(initialTokenNumber, place.getTokensNumber());
    }

    @Test
    void testRemoveTooManyTokens() {
        final int initialTokenNumber = 5;
        final int tokenNumberToRemove = 10;
        final Place place = new Place(initialTokenNumber);
        place.removeTokens(tokenNumberToRemove);
        assertEquals(0, place.getTokensNumber());
    }

    @Test
    void testCheckIfEmpty() {
        final int initialTokenNumber = 5;
        final Place place = new Place(initialTokenNumber);
        assertFalse(place.checkIfEmpty());
        place.setTokensNumber(0);
        assertTrue(place.checkIfEmpty());
    }

    @Test
    void testClearAllTokens() {
        final int initialTokenNumber = 5;
        final Place place = new Place(initialTokenNumber);
        place.clearAllTokens();
        assertEquals(0, place.getTokensNumber());
    }

    @Test
    void testToString() {
        final int initialTokenNumber = 5;
        final Place place = new Place(initialTokenNumber);
        assertEquals("( 5 )", place.toString());
    }

}
