package elements;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elements.Place;

class PlaceTest {

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
}
