package uk.ac.cf.cm6123.cards;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    private static final Logger logger = LoggerFactory.getLogger(Deck.class);

    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(rank.of(suit));
            }
        }
        logger.info("Deck created");
    }

    public Integer size() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card get(int i) {
        return cards.get(i);
    }

    public void cut() {
        Collections.rotate(cards, new Random().nextInt(cards.size()));
    }

    public Card draw() {
        try {
            return cards.remove(0);
        } catch (IndexOutOfBoundsException e) {
            throw new DrawFromEmptyDeckException();
        }
    }

    public void deal(List<? extends Hand> hands, int cards) {
        for (int c = 0; c < cards; c++) {
            for (Hand hand : hands) {
                this.deal(hand);
            }
        }
    }

    public void deal(Hand hand) {
        hand.add(this.draw());

    }
}
