package org.example;

/**
 * This class encapsulates the Tic-Tac-Toe game board.
 * It provides methods to display the board in a readable format.
 */
public class Board {
    /**
     * The 3*3 array representing the Tic-Tac-Toe game board.
     * Each cell is a string.
     */
    public String[][] board;

    /**
     * Constructs a new Board object using the provided 2D array.
     * @param inBoard the initial board state
     */
    public Board(String[][] inBoard) { board = inBoard; }

    /**
     * Prints the current state of the board to the console in a readable grid format.
     */
    public void printBoard() {
        System.out.println();
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-----+-----+-----");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-----+-----+-----");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
        System.out.println();
    }
}
