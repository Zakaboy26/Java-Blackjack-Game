package uk.ac.cf.cm6123.blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BlackjackGamePlay {

    @Test
    public void shouldBeAbleToStartAGameWithTwoPlayers() {
        BlackjackGame game = new BlackjackGame("Carl", "Clare");
        BlackjackPlayer player = game.getCurrentPlayer();
        assertEquals("Carl", player.getName());
        assertTrue(player.canHit());
    }

    @Test
    public void shouldBeAbleToPlayGameToEndIfPlayersAlwaysHit() {
        BlackjackGame game = new BlackjackGame("Carl", "Clare");
        BlackjackPlayer winner;
        while (!game.isOver()) {
            BlackjackPlayer currentPlayer = game.getCurrentPlayer();
            String name = currentPlayer.getName(); //ask player if they want to hit or stand?
            //player takes turn
            game.stand(currentPlayer);
            game.nextPlayer();
        }

        assertTrue(game.isOver());
    }

    @Test
    public void shouldBeAbleToPlayGameToEndIfPlayersAlwaysStand() {
        BlackjackGame game = new BlackjackGame("Carl", "Clare");
        BlackjackPlayer winner;
        while (!game.isOver()) {
            BlackjackPlayer currentPlayer = game.getCurrentPlayer();
            String name = currentPlayer.getName(); //ask player if they want to hit or stand?
            //player takes turn
            game.stand(currentPlayer);
            game.nextPlayer();
        }

        assertTrue(game.isOver());
    }

    @Test
    public void shouldBeAbleToPlayGameToEndIfPlayersAlwaysStandAndCarlShouldWin() {
        BlackjackGame game = new BlackjackGame("Carl", "Clare");
        while (!game.isOver()) {
            BlackjackPlayer currentPlayer = game.getCurrentPlayer();
            String name = currentPlayer.getName(); //ask player if they want to hit or stand?
            //player takes turn
            game.stand(currentPlayer);
            game.nextPlayer();
        }

        List<BlackjackPlayer> winners = game.getWinners();
        assertEquals("Carl", winners.get(0).getName());
        assertTrue(game.isOver());
    }

    @Test
    public void shouldBeAbleToPlayGameToEndIfPlayersAlwaysHitAndTheyAllWinThoughBust() {
        BlackjackGame game = new BlackjackGame("Carl", "Clare");
        BlackjackPlayer winner;
        while (!game.isOver()) {
            BlackjackPlayer currentPlayer = game.getCurrentPlayer();
            String name = currentPlayer.getName(); //ask player if they want to hit or stand?
            //player takes turn
            game.hit(currentPlayer);
            game.nextPlayer();
        }
        List<BlackjackPlayer> winners = game.getWinners();

        assertEquals(2, winners.size());
        assertTrue(game.isOver());
    }

}
