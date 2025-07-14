package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is Unit test for the Board class, which manages the Tic-Tac-Toe board state.
 */
class BoardTest {

    /**
     * Tests that a new Board is initialized with characters 1-9.
     */
    @Test
    void testBoardInitialization() {
        Board board = new Board();
        char[][] grid = board.getBoard();
        assertEquals('1', grid[0][0]);
        assertEquals('9', grid[2][2]);
    }

    /**
     * Tests that setCell correctly sets a symbol at the assigned location.
     */
    @Test
    void testSetCell() {
        Board board = new Board();
        board.setCell(2, 2, 'O');
        assertEquals('O', board.getCell(2, 2));
    }

    /**
     * Tests that getCell retrieves the correct symbol from a cell.
     */
    @Test
    void testGetCell() {
        Board board = new Board();
        assertEquals('5', board.getCell(1, 1));
    }

    /**
     * Tests that printing the board does not throw an exception.
     */
    @Test
    void testPrintBoardDoesNotThrow() {
        Board board = new Board();
        assertDoesNotThrow(board::printBoard);
    }
}