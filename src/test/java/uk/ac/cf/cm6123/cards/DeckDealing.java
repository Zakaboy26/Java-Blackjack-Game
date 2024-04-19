package uk.ac.cf.cm6123.cards;

/*
TODO what if deck is empty?

 */

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static uk.ac.cf.cm6123.cards.Rank.*;
import static uk.ac.cf.cm6123.cards.Suit.CLUBS;

public class DeckDealing {

    @Test
    public void shouldBeAbleToGetTheTopCard() {
        Deck aDeck = new Deck();
        Card aCard = aDeck.draw();
        assertEquals(new Card(ACE, CLUBS), aCard);
        assertEquals(51, aDeck.size());
    }

    @Test
    public void shouldBeAbleToGetTheTopCardIntoHand() {
        Deck aDeck = new Deck();
        Hand aHand = new Hand();
        List<Hand> hands = List.of(aHand);
        aDeck.deal(hands, 1);
        assertEquals(new Card(ACE, CLUBS), aHand.get(0));
        assertEquals(51, aDeck.size());
    }

    @Test
    public void shouldBeAbleToDeal2CardsIntoTwoHands() {
        Deck aDeck = new Deck();
        Hand aHand = new Hand();
        Hand bHand = new Hand();
        List<Hand> hands = List.of(aHand, bHand);
        aDeck.deal(hands, 2);
        assertEquals(new Card(ACE, CLUBS), aHand.get(0));
        assertEquals(new Card(TWO, CLUBS), bHand.get(0));
        assertEquals(new Card(THREE, CLUBS), aHand.get(1));
        assertEquals(new Card(FOUR, CLUBS), bHand.get(1));
        assertEquals(48, aDeck.size());
    }

    @Test
    public void shouldThrowExceptionIfDrawingFromEmptyDeck() {
        Deck aDeck = new Deck();
        for (int i = 0; i <= 51; i++) {
            aDeck.draw();
        }

        assertThrows(DrawFromEmptyDeckException.class, () -> aDeck.draw());

    }
}
