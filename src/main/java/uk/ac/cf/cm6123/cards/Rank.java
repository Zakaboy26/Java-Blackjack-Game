package uk.ac.cf.cm6123.cards;

public enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    public Card of(Suit aSuit) {
        return new Card(this, aSuit);
    }

}
