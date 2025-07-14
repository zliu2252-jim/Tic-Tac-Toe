package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Player class, which provides static
 * methods for placing the move from the player on the board.
 */
class PlayerTest {

    /**
     * Tests that Player.placeMove correctly places 'O' in the middle cell '5'.
     */
    @Test
    void testPlaceMoveMiddle() {
        Board board = new Board();
        Player.placeMove(board, "5", 'O');
        assertEquals('O', board.getCell(1, 1));
    }

    /**
     * Tests that Player.placeMove places 'X' in the top-left corner '1'.
     */
    @Test
    void testPlaceMoveTopLeft() {
        Board board = new Board();
        Player.placeMove(board, "1", 'X');
        assertEquals('X', board.getCell(0, 0));
    }

    /**
     * Tests that Player.placeMove places 'X' in the bottom-right corner '9'.
     */
    @Test
    void testPlaceMoveBottomRight() {
        Board board = new Board();
        Player.placeMove(board, "9", 'X');
        assertEquals('X', board.getCell(2, 2));
    }

    /**
     * Tests that Player.placeMove can place different symbols on different cells.
     */
    @Test
    void testPlaceMoveDifferentSymbols() {
        Board board = new Board();
        Player.placeMove(board, "2", 'X');
        Player.placeMove(board, "3", 'O');
        assertEquals('X', board.getCell(0, 1));
        assertEquals('O', board.getCell(0, 2));
    }
}