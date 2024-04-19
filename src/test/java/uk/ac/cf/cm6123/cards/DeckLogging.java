package uk.ac.cf.cm6123.cards;

import com.github.valfirst.slf4jtest.TestLogger;
import com.github.valfirst.slf4jtest.TestLoggerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import uk.org.lidalia.slf4jext.Level;

import static com.github.valfirst.slf4jtest.Assertions.assertThat;

public class DeckLogging {

    private final TestLogger logger = TestLoggerFactory.getTestLogger(Deck.class);

    @AfterEach
    void tearDown() {
        logger.clear();
    }

    @Test
    public void shouldLogCreationOfADeck() {

        Deck aDeck = new Deck();
        assertThat(logger).hasLogged(Level.INFO, "Deck created");

    }
}
