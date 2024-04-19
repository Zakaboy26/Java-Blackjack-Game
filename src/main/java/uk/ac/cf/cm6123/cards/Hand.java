package uk.ac.cf.cm6123.cards;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    protected List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public Card get(int i) {
        return cards.get(i);
    }

    protected void add(Card aCard) {
        cards.add(aCard);
    }
}
