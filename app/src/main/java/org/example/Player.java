package org.example;

import java.util.Scanner;

/**
 * This class containing static methods for handling
 * player moves and updating the information to the board in Tic-Tac-Toe.
 * These methods prompt the user for input and perform the move.
 */
public class Player {

    /**
     * Prompts the current player for a move, validates input,
     * and places the symbol on the board if we insert the valid move.
     * Re-prompts the user until a valid move is entered.
     *
     * @param board  the Board object representing the Tic-Tac-Toe board
     * @param scnr   Scanner for user input
     * @param symbol the player's symbol ('X' or 'O')
     */
    public static void playerMove(Board board, Scanner scnr, char symbol) {
        String inp;
        while (true) {
            System.out.println("Player " + symbol + ", what is your move? (1-9):");
            inp = scnr.nextLine().trim();
            // Use Rules.isValidMove to validate input
            if (Rules.isValidMove(board, inp)) break;
            System.out.println("This is not a valid move: " + inp + ". Try again.");
        }
        placeMove(board, inp, symbol);
    }

    /**
     * Places the player's symbol on the board at the given position.
     *
     * @param board    the Board object representing the Tic-Tac-Toe board
     * @param position the string representing the cell number (1 to 9)
     * @param symbol   the symbol represents players ('X' or 'O')
     */
    public static void placeMove(Board board, String position, char symbol) {
        int cell = Integer.parseInt(position);
        int row  = (cell - 1) / 3;
        int col = (cell - 1) % 3;
        board.setCell(row, col, symbol);
    }
}