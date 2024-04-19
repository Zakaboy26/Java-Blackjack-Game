package uk.ac.cf.cm6123.cards;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import uk.org.lidalia.slf4jext.Level;

import static com.github.valfirst.slf4jtest.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static uk.ac.cf.cm6123.cards.Rank.*;
import static uk.ac.cf.cm6123.cards.Suit.CLUBS;

public class DeckCreation {


    @Test
    public void shouldBeAbleToCreateDeckOf52Cards() {
        Deck aDeck = new Deck();
        assertEquals(52, aDeck.size());
    }

    @Test
    public void shouldBeAbleToShuffleDeck() {
        Deck aDeck = new Deck();
        aDeck.shuffle();
        assertEquals(52, aDeck.size());
        assertFalse(aDeck.get(0).equals(new Card(ACE, CLUBS)) &&
                            aDeck.get(1).equals(new Card(TWO, CLUBS)) &&
                            aDeck.get(2).equals(new Card(THREE, CLUBS)));
    }

    @Test
    public void shouldBeAbleToCutDeck() {
        Deck aDeck = new Deck();
        aDeck.cut();
        assertEquals(52, aDeck.size());
        assertFalse(aDeck.get(0).equals(new Card(ACE, CLUBS)));
    }


}
