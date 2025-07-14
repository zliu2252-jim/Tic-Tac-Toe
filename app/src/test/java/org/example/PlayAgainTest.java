package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the PlayAgain class, which handles user prompts
 * for playing the Tic-Tac-Toe again.
 */
class PlayAgainTest {

    /**
     * Tests that input "yes" returns true.
     */
    @Test
    void testAskPlayAgainYes() {
        ByteArrayInputStream in = new ByteArrayInputStream("yes\n".getBytes());
        Scanner scanner = new Scanner(in);
        assertTrue(PlayAgain.askPlayAgain(scanner));
    }

    /**
     * Tests that input "y" returns true.
     */
    @Test
    void testAskPlayAgainY() {
        ByteArrayInputStream in = new ByteArrayInputStream("y\n".getBytes());
        Scanner scanner = new Scanner(in);
        assertTrue(PlayAgain.askPlayAgain(scanner));
    }

    /**
     * Tests that input "no" returns false.
     */
    @Test
    void testAskPlayAgainNo() {
        ByteArrayInputStream in = new ByteArrayInputStream("no\n".getBytes());
        Scanner scanner = new Scanner(in);
        assertFalse(PlayAgain.askPlayAgain(scanner));
    }

    /**
     * Tests that input "n" returns false.
     */
    @Test
    void testAskPlayAgainN() {
        ByteArrayInputStream in = new ByteArrayInputStream("n\n".getBytes());
        Scanner scanner = new Scanner(in);
        assertFalse(PlayAgain.askPlayAgain(scanner));
    }
}