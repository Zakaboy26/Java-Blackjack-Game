package uk.ac.cf.cm6123.blackjack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import uk.ac.cf.cm6123.cards.Card;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static uk.ac.cf.cm6123.blackjack.BlackjackHand.BlackjackValue.*;
import static uk.ac.cf.cm6123.cards.Rank.*;
import static uk.ac.cf.cm6123.cards.Suit.*;

public class BlackjackScoring {
    @Test
    public void shouldGetFiveForHandOfTwoAndThree() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(TWO, CLUBS));
        aHand.add(new Card(THREE, SPADES));
        assertEquals(_5, aHand.value());
    }

    @Test
    public void shouldGetEightForHandOfFiveAndThree() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(FIVE, CLUBS));
        aHand.add(new Card(THREE, SPADES));
        assertEquals(_8, aHand.value());
    }

    @Test
    public void shouldGetTenForHandOf2332() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(TWO, CLUBS));
        aHand.add(new Card(THREE, SPADES));
        aHand.add(new Card(THREE, CLUBS));
        aHand.add(new Card(TWO, SPADES));
        assertEquals(_10, aHand.value());
    }

    @Test
    public void shouldGet21ForHandOf45453() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(FOUR, CLUBS));
        aHand.add(new Card(FIVE, SPADES));
        aHand.add(new Card(FIVE, CLUBS));
        aHand.add(new Card(FOUR, SPADES));
        aHand.add(new Card(THREE, HEARTS));
        assertEquals(_21, aHand.value());
    }

    @Test
    public void shouldGet20ForHandOf10_10() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(TEN, CLUBS));
        aHand.add(new Card(TEN, SPADES));
        assertEquals(_20, aHand.value());
    }

    @Test
    public void shouldGet20ForHandOf10_Jack() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(TEN, CLUBS));
        aHand.add(new Card(JACK, SPADES));
        assertEquals(_20, aHand.value());
    }

    @Test
    public void shouldGet13ForHandOfAce_2() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(ACE, CLUBS));
        aHand.add(new Card(TWO, SPADES));
        assertEquals(_13, aHand.value());
    }

    @Test
    public void shouldGet12ForHandOfAce_Ace() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(ACE, CLUBS));
        aHand.add(new Card(ACE, SPADES));
        assertEquals(_12, aHand.value());
    }

    @Test
    public void shouldGet21ForHandOfAce_55() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(ACE, CLUBS));
        aHand.add(new Card(FIVE, SPADES));
        aHand.add(new Card(FIVE, SPADES));
        assertEquals(_21, aHand.value());
    }

    @Test
    public void shouldGetBlackjackForHandOfAce10() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(ACE, CLUBS));
        aHand.add(new Card(TEN, SPADES));
        assertEquals(BLACKJACK, aHand.value());
    }

    @Test
    public void shouldGetBlackjackForHandOfAceQueen() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(ACE, CLUBS));
        aHand.add(new Card(QUEEN, SPADES));
        assertEquals(BLACKJACK, aHand.value());
    }

    @Test
    public void shouldGetBustForHandOf6666() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(SIX, CLUBS));
        aHand.add(new Card(SIX, DIAMONDS));
        aHand.add(new Card(SIX, SPADES));
        aHand.add(new Card(SIX, HEARTS));

        assertEquals(BUST, aHand.value());
    }

    @Test
    public void shouldGetBustForHandOf6664() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(SIX, CLUBS));
        aHand.add(new Card(SIX, DIAMONDS));
        aHand.add(new Card(SIX, SPADES));
        aHand.add(new Card(FOUR, HEARTS));

        assertEquals(BUST, aHand.value());
    }

    @Test
    public void shouldGet21ForHandOfAce1010() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(ACE, CLUBS));
        aHand.add(new Card(TEN, DIAMONDS));
        aHand.add(new Card(TEN, SPADES));

        assertEquals(_21, aHand.value());
    }

    @Test
    public void shouldGetBustForHandOf10JQK() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(TEN, CLUBS));
        aHand.add(new Card(JACK, DIAMONDS));
        aHand.add(new Card(QUEEN, SPADES));
        aHand.add(new Card(KING, SPADES));

        assertEquals(BUST, aHand.value());
    }

    @Test
    public void shouldGetBustForHandOf10JAA() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(TEN, CLUBS));
        aHand.add(new Card(JACK, DIAMONDS));
        aHand.add(new Card(ACE, SPADES));
        aHand.add(new Card(ACE, SPADES));

        assertEquals(BUST, aHand.value());
    }

    @Test
    public void shouldGet14ForHandOfAAAA() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(ACE, CLUBS));
        aHand.add(new Card(ACE, DIAMONDS));
        aHand.add(new Card(ACE, SPADES));
        aHand.add(new Card(ACE, HEARTS));

        assertEquals(_14, aHand.value());
    }

    @Test
    public void shouldWinBlackjackOver21() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(ACE, CLUBS));
        aHand.add(new Card(JACK, CLUBS));

        BlackjackHand bHand = new BlackjackHand();
        bHand.add(new Card(ACE, DIAMONDS));
        bHand.add(new Card(FOUR, DIAMONDS));
        bHand.add(new Card(SIX, DIAMONDS));

        assertEquals(1, aHand.compareTo(bHand));
    }

    @Test
    public void shouldDrawBlackjackVBlackjack() {
        BlackjackHand aHand = new BlackjackHand();
        aHand.add(new Card(ACE, CLUBS));
        aHand.add(new Card(JACK, CLUBS));

        BlackjackHand bHand = new BlackjackHand();
        bHand.add(new Card(ACE, DIAMONDS));
        bHand.add(new Card(QUEEN, DIAMONDS));

        assertEquals(0, aHand.compareTo(bHand));
    }

    /*
    Below are Parameterised tests. The first method defines the test and is annotated with the name of the method that will
    provide the data to the tests.

    The data is passed to the test method as a stream of arguments and the test framework runs each test with the arguments in turn.
     */

    @ParameterizedTest
    @MethodSource("provideCardsAndValues")
    public void shouldGetValuesForHands(Set<Card> cards, BlackjackHand.BlackjackValue value) {
        BlackjackHand aHand = new BlackjackHand();
        for (Card aCard : cards) {
            aHand.add(aCard);
        }
        assertEquals(value, aHand.value());
    }

    private static Stream<Arguments> provideCardsAndValues() {

        Set<Card> shouldScore14 = Set.of(ACE.of(CLUBS), ACE.of(DIAMONDS), ACE.of(SPADES), ACE.of(HEARTS));
        Set<Card> shouldScore21_1 = Set.of(FOUR.of(CLUBS), FIVE.of(SPADES), FIVE.of(CLUBS), FOUR.of(SPADES), THREE.of(HEARTS));

        return Stream.of(
                Arguments.of(shouldScore14, _14),
                Arguments.of(shouldScore21_1, _21)
                        );

    }
}
