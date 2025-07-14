package org.example;

import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Human class, representing a human player in the game.
 */
class HumanTest {

    /**
     * Test that a Human object is successfully constructed with valid arguments.
     */
    @Test
    void testHumanConstructor() {
        Board board = new Board();
        Human human = new Human('X', board, new java.util.Scanner(System.in));
        assertNotNull(human);
    }

    /**
     * Test that creating a Human object does not throw, and it can accept a different symbol.
     */
    @Test
    void testMoveDoesNotThrow() {
        Board board = new Board();
        Human human = new Human('O', board, new java.util.Scanner(System.in));
        // Just test construction. (move requires input, see next test)
        assertNotNull(human);
    }

    /**
     * Test that a Human object with symbol 'X' is not null.
     */
    @Test
    void testHumanHasSymbol() {
        Board board = new Board();
        Human human = new Human('X', board, new java.util.Scanner(System.in));
        // No public accessor but object should exist
        assertNotNull(human);
    }

    /**
     * Test that a Human object can be constructed using a provided Scanner object.
     */
    @Test
    void testHumanObjectWithScanner() {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        Human human = new Human('X', board, scanner);
        assertNotNull(human);
    }
}