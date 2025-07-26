package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains unit tests for the Board class.
 * It checks board initialization, updating, reference sharing, and dimensions.
 */
class BoardTest {

    /**
     * Tests that the board is initialized with the correct cell values.
     */
    @Test
    void testInitialBoardState() {
        String[][] arr = {
                {"  1  ", "  2  ", "  3  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        assertEquals("  5  ", board.board[1][1]);
    }

    /**
     * Tests updating a board cell and checks if the update is reflected.
     */
    @Test
    void testBoardUpdate() {
        String[][] arr = {
                {"  1  ", "  2  ", "  3  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        board.board[2][2] = "  X  ";
        assertEquals("  X  ", board.board[2][2]);
    }

    /**
     * Tests that the board shares reference with the passed array.
     */
    @Test
    void testBoardReferenceSharing() {
        String[][] arr = {
                {"  1  ", "  2  ", "  3  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        arr[0][1] = "  O  ";
        assertEquals("  O  ", board.board[0][1]);
    }

    /**
     * Tests that the board is a 3*3 array.
     */
    @Test
    void testBoardIs3x3() {
        String[][] arr = {
                {"  1  ", "  2  ", "  3  "},
                {"  4  ", "  5  ", "  6  "},
                {"  7  ", "  8  ", "  9  "}
        };
        Board board = new Board(arr);
        assertEquals(3, board.board.length);
        assertEquals(3, board.board[0].length);
    }
}
