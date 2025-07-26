package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the PlayAgain utility class.
 * It checks valid and accepted user input for replay prompt logic.
 */
class PlayAgainTest {

    /**
     * Tests that input "yes" returns true for replay.
     */
    @Test
    void testAskPlayAgainYes() {
        String simulatedInput = "yes\n";
        Scanner scnr = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertTrue(PlayAgain.askPlayAgain(scnr));
    }

    /**
     * Tests that input "no" returns false for replay.
     */
    @Test
    void testAskPlayAgainNo() {
        String simulatedInput = "no\n";
        Scanner scnr = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertFalse(PlayAgain.askPlayAgain(scnr));
    }

    /**
     * Tests that input "y" returns true for replay.
     */
    @Test
    void testAskPlayAgainY() {
        String simulatedInput = "y\n";
        Scanner scnr = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertTrue(PlayAgain.askPlayAgain(scnr));
    }

    /**
     * Tests that input "n" returns false for replay.
     */
    @Test
    void testAskPlayAgainN() {
        String simulatedInput = "n\n";
        Scanner scnr = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        assertFalse(PlayAgain.askPlayAgain(scnr));
    }
}
