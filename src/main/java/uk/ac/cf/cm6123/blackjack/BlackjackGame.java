package uk.ac.cf.cm6123.blackjack;

import uk.ac.cf.cm6123.cards.Deck;

import java.util.ArrayList;
import java.util.List;

import static uk.ac.cf.cm6123.blackjack.BlackjackHand.BlackjackValue;
import static uk.ac.cf.cm6123.blackjack.BlackjackHand.BlackjackValue.BUST;

public class BlackjackGame {

    private List<BlackjackPlayer> players;

    private Integer currentPlayerIndex;

    private Deck theDeck;

    public BlackjackGame(String... names) {

        theDeck = new Deck();

        players = new ArrayList<>();

        for (String name : names) {
            BlackjackPlayer player = new BlackjackPlayer(name);
            players.add(player);
        }

        resetHands();
        currentPlayerIndex = 0;
        dealInitialCards();

    }

    private void dealInitialCards() {
        List<BlackjackHand> hands = getHandsFromPlayers();
        theDeck.deal(hands, 2);
    }

    private List<BlackjackHand> getHandsFromPlayers() {
        List<BlackjackHand> hands = new ArrayList<>();
        for (BlackjackPlayer player : players) {
            hands.add(player.getHand());
        }
        return hands;
    }

    public void resetHands() {
        for (BlackjackPlayer player : players) {
            player.clearHand();
        }
    }

    public BlackjackPlayer getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public Boolean isOver() {
        Boolean thereIsAnActivePlayer = Boolean.FALSE;
        for (BlackjackPlayer player : players) {
            thereIsAnActivePlayer = thereIsAnActivePlayer || player.isActive();
        }
        return !thereIsAnActivePlayer;
    }

    public void hit(BlackjackPlayer aPlayer) {
        aPlayer.getHand().add(theDeck.draw());
    }

    public void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void stand(BlackjackPlayer aPlayer) {
        aPlayer.stand();
    }

    public List<BlackjackPlayer> getWinners() {
        List<BlackjackPlayer> winners = new ArrayList<>();
        BlackjackValue worstValue = BUST;

        for (BlackjackPlayer player : players) {
            BlackjackHand hand = player.getHand();
            BlackjackValue value = hand.value();
            if (value.compareTo(worstValue) >= 0) {
                if (value.compareTo(worstValue) == 1) {
                    winners.clear();
                }
                winners.add(player);
                worstValue = value;
            }
        }
        return winners;
    }
}
