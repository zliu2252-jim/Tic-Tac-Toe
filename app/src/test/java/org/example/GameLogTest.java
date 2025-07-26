package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the GameLog class.
 * It verifies correct win/tie counting and session result tracking.
 */
class GameLogTest {

    /**
     * Tests that recording an X win increments the total games.
     */
    @Test
    void testXWinCount() {
        GameLog log = new GameLog();
        log.recordResult("X");
        assertEquals(1, log.totalGames());
    }

    /**
     * Tests that recording an O win increments the total games.
     */
    @Test
    void testOWinCount() {
        GameLog log = new GameLog();
        log.recordResult("O");
        assertEquals(1, log.totalGames());
    }

    /**
     * Tests that recording a tie increments the total games.
     */
    @Test
    void testTieCount() {
        GameLog log = new GameLog();
        log.recordResult("Tie");
        assertEquals(1, log.totalGames());
    }

    /**
     * Tests that multiple results are all counted correctly.
     */
    @Test
    void testMultipleResults() {
        GameLog log = new GameLog();
        log.recordResult("X");
        log.recordResult("O");
        log.recordResult("Tie");
        assertEquals(3, log.totalGames());
    }
}
