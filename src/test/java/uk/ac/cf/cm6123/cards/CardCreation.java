package uk.ac.cf.cm6123.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static uk.ac.cf.cm6123.cards.Rank.*;
import static uk.ac.cf.cm6123.cards.Suit.*;

public class CardCreation {

    @Test
    public void shouldBeAbleToMakeAceOfSpades() {
        Card aceOfSpades = ACE.of(SPADES);
        assertEquals(ACE, aceOfSpades.rank);
        assertEquals(SPADES, aceOfSpades.suit);
    }

    @Test
    public void shouldBeAbleToPrintAceOfSpades() {
        Card aceOfSpades = new Card(ACE, SPADES);
        assertEquals("ACE OF SPADES", aceOfSpades.toString());

    }

    @Test
    public void shouldSayTwoCardsAreTheSame() {
        Card aceOfSpades1 = new Card(ACE, SPADES);
        Card aceOfSpades2 = new Card(ACE, SPADES);

        assertTrue(aceOfSpades1.equals(aceOfSpades2));
        assertTrue(aceOfSpades1 != aceOfSpades2);

    }

    @Test
    public void shouldSayTwoCardsAreDifferent() {
        Card aceOfSpades = new Card(ACE, SPADES);
        Card aceOfClubs = new Card(ACE, CLUBS);

        assertFalse(aceOfSpades.equals(aceOfClubs));
        assertTrue(aceOfSpades != aceOfClubs);

    }

}
