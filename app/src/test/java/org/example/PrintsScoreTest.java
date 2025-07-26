package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the PrintsScore utility class.
 * It verifies that static counters for ties, X wins, and O wins works well.
 */
class PrintsScoreTest {

    /**
     * Tests that the tie counter can be set and retrieved correctly.
     */
    @Test
    void testTieCounterAssignment() {
        PrintsScore.tieCounter = 5;
        assertEquals(5, PrintsScore.tieCounter);
    }

    /**
     * Tests that the X win counter can be set and retrieved correctly.
     */
    @Test
    void testXWinCounterAssignment() {
        PrintsScore.playerXWinCounter = 4;
        assertEquals(4, PrintsScore.playerXWinCounter);
    }

    /**
     * Tests that the O win counter can be set and retrieved correctly.
     */
    @Test
    void testOWinCounterAssignment() {
        PrintsScore.playerOWinCounter = 2;
        assertEquals(2, PrintsScore.playerOWinCounter);
    }

    /**
     * Tests that all counters can be set to zero at the same time.
     */
    @Test
    void testCountersCanAllBeZero() {
        PrintsScore.tieCounter = 0;
        PrintsScore.playerXWinCounter = 0;
        PrintsScore.playerOWinCounter = 0;
        assertEquals(0, PrintsScore.tieCounter + PrintsScore.playerXWinCounter + PrintsScore.playerOWinCounter);
    }
}