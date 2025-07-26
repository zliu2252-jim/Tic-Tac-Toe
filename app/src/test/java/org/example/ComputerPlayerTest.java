package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the ComputerPlayer class,
 * verifying that the computer player follows opportunistic strategy:
 * a. Picks a corner first.
 * b. Takes center on second move if available.
 * c. Makes a winning move.
 * d. Blocks the opponent's winning move.
 */
class ComputerPlayerTest {

    /**
     * Tests that the computer picks a corner on its first move.
     */
    @Test
    void testFirstMoveCorner() {
        String[][] arr = {
                {"  1  ", "  2  ", "  3  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        Rules rules = new Rules();
        ComputerPlayer cp = new ComputerPlayer(arr, "  X  ", board, rules);
        cp.move();
        int corners = 0;
        if (arr[0][0].equals("  X  ")) corners++;
        if (arr[0][2].equals("  X  ")) corners++;
        if (arr[2][0].equals("  X  ")) corners++;
        if (arr[2][2].equals("  X  ")) corners++;
        assertEquals(1, corners);
    }

    /**
     * Tests that the computer takes the center if it is the second move and available.
     */
    @Test
    void testSecondMoveCenter() {
        String[][] arr = {
                {"  1  ", "  2  ", "  3  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        arr[0][0] = "  O  "; // Human plays corner first
        Board board = new Board(arr);
        Rules rules = new Rules();
        ComputerPlayer cp = new ComputerPlayer(arr, "  X  ", board, rules);
        cp.move();
        assertEquals("  X  ", arr[1][1]);
    }

    /**
     * Tests that the computer makes a winning move if available.
     */
    @Test
    void testComputerWinMove() {
        String[][] arr = {
                {"  X  ", "  X  ", "  3  "},
                {"  O  ", "  O  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        Rules rules = new Rules();
        ComputerPlayer cp = new ComputerPlayer(arr, "  X  ", board, rules);
        arr[0][2] = "  3  ";
        cp.move();
        assertEquals("  X  ", arr[0][2]);
    }

    /**
     * Tests that the computer blocks the opponent's winning move if possible.
     */
    @Test
    void testComputerBlockMove() {
        String[][] arr = {
                {"  O  ", "  O  ", "  3  "},
                {"  4  ", "  X  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        Rules rules = new Rules();
        ComputerPlayer cp = new ComputerPlayer(arr, "  X  ", board, rules);
        cp.move();
        assertEquals("  X  ", arr[0][2]); // Should block at (0,2)
    }
}