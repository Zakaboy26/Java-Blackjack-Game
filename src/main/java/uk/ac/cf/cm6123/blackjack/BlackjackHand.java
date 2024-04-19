package uk.ac.cf.cm6123.blackjack;

import uk.ac.cf.cm6123.cards.Card;
import uk.ac.cf.cm6123.cards.Hand;

import static uk.ac.cf.cm6123.cards.Rank.*;

public class BlackjackHand extends Hand implements Comparable<BlackjackHand> {

    private final static Integer MAX_HAND_SIZE = 5;

    public enum BlackjackValue {BUST, _1X, _2X, _3X, _4, _5, _6, _7, _8, _9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21, BLACKJACK}

    ;

    private static final Integer SPECIAL_VALUE_COUNT = 2;
    private static final Integer CARDS_IN_HAND_FOR_BLACKJACK = 2;

    private static final Integer ORDINAL_TO_VALUE_OFFSET = 1;

    public BlackjackValue value() {
        Integer value = 0;
        Integer cardValue = 0;
        Integer aceCount = 0;

        for (Card aCard : cards) {
            cardValue = blackvalueOf(aCard);
            aceCount = aCard.isAce() ? aceCount + 1 : aceCount;
            value += cardValue;
        }

        while (aceCount > 0 && value <= 11) {
            aceCount--;
            value += 10;
        }

        if (isBust(value)) {
            return BlackjackValue.BUST;
        }

        BlackjackValue provisionalValue = BlackjackValue.values()[value];
        if (provisionalValue == BlackjackValue._21 && cards.size() == CARDS_IN_HAND_FOR_BLACKJACK) {
            return BlackjackValue.BLACKJACK;
        } else {
            return provisionalValue;
        }
    }

    boolean canHit() {
        return cards.size() < MAX_HAND_SIZE;
    }

    @Override
    public void add(Card aCard) {
        if (canHit()) {
            super.add(aCard);
        } else {
            throw new HandIsFullException();
        }
    }

    private boolean isBust(Integer value) {
        return value > BlackjackValue.values().length - CARDS_IN_HAND_FOR_BLACKJACK;
    }

    private Integer blackvalueOf(Card aCard) {

        if (aCard.isPicture()) {
            return TEN.ordinal() + ORDINAL_TO_VALUE_OFFSET;
        } else {
            return aCard.rank.ordinal() + ORDINAL_TO_VALUE_OFFSET;
        }
    }

    @Override
    public int compareTo(BlackjackHand aHand) {
        return this.value().compareTo(aHand.value());
    }

}
