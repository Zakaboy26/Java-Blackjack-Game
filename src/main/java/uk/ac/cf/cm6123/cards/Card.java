package uk.ac.cf.cm6123.cards;

import java.util.Objects;
import java.util.Set;

import static uk.ac.cf.cm6123.cards.Rank.*;

public class Card {
    public final Rank rank;
    public final Suit suit;

    public Card(final Rank aRank, final Suit aSuit) {
        rank = aRank;
        suit = aSuit;
    }

    public String toString() {
        return rank + " OF " + suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    public boolean isPicture() {
        Set<Rank> pictures = Set.of(JACK, QUEEN, KING);
        return pictures.contains(rank);
    }

    public boolean isAce() {
        return rank.equals(ACE);
    }
}
