package org.example;

/**
 * This class encapsulates the Tic-Tac-Toe game board.
 * It provides methods to get and set cell values and to display the board.
 */
public class Board {
    // The 3x3 array representing the Tic-Tac-Toe game board
    private final char[][] board;

    /**
     * Builds a new Board and initializes each cell with characters 1-9.
     * This allows players to choose their moves based on the cell numbers on the board.
     */
    public Board() {
        board = new char[][]{
                {'1','2','3'},
                {'4','5','6'},
                {'7','8','9'}
        };
    }

    /**
     * Returns the array representing the board.
     *
     * @return the 3*3 game board array
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * Prints the current state of the board to the console in a readable grid format.
     */
    public void printBoard() {
        System.out.println();
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }

    /**
     * Gets the symbol at the assigned position in the board.
     *
     * @param row the index of the row
     * @param col the index of the column
     * @return the character at the specified cell
     */
    public char getCell(int row, int col) {
        return board[row][col];
    }

    /**
     * Sets the symbol at the assigned position in the board.
     *
     * @param row the index of the row
     * @param col the index of the column
     * @param symbol the character to set ('X' or 'O')
     */
    public void setCell(int row, int col, char symbol) {
        board[row][col] = symbol;
    }
}
