package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the Rules class,
 * verifying detection of win conditions for horizontal, vertical, diagonal, and no-win cases.
 */
class RulesTest {

    /**
     * Tests that a horizontal row of matching symbols is detected as a win.
     */
    @Test
    void testHorizontalWin() {
        Rules rules = new Rules();
        String[][] b = {
                {"  X  ", "  X  ", "  X  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        assertTrue(rules.hasContestantWon(b, "  X  "));
    }

    /**
     * Tests that a vertical column of matching symbols is detected as a win.
     */
    @Test
    void testVerticalWin() {
        Rules rules = new Rules();
        String[][] b = {
                {"  X  ", "  O  ", "  O  "},
                {"  X  ", "  5  ", "  6  "},
                {"  X  ", "  8  ", "  9  "}
        };
        assertTrue(rules.hasContestantWon(b, "  X  "));
    }

    /**
     * Tests that a diagonal of matching symbols is detected as a win.
     */
    @Test
    void testDiagonalWin() {
        Rules rules = new Rules();
        String[][] b = {
                {"  X  ", "  O  ", "  3  "},
                {"  4  ", "  X  ", "  O  "},
                {"  7  ", "  8  ", "  X  "}
        };
        assertTrue(rules.hasContestantWon(b, "  X  "));
    }

    /**
     * Tests that a board with no winning row, column, or diagonal returns no win.
     */
    @Test
    void testNoWin() {
        Rules rules = new Rules();
        String[][] b = {
                {"  X  ", "  O  ", "  X  "},
                {"  O  ", "  O  ", "  X  "},
                {"  X  ", "  X  ", "  O  "}
        };
        assertFalse(rules.hasContestantWon(b, "  X  "));
    }
}
