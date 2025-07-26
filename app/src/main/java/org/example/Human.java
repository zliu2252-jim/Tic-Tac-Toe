package org.example;

import java.util.Scanner;

/**
 * This class represents a human player in the Tic-Tac-Toe game.
 * It is responsible for prompting the user for input, validating moves,
 * and updating the board for the human's turn.
 */
public class Human {
    /** The character symbol representing this player. */
    private final char symbol;
    /** The board object to update when the player makes a move. */
    private final Board board;
    /** Scanner for reading user input from the console. */
    private final Scanner scanner;

    /**
     * Constructs a new Human player.
     * @param symbol  the symbol for this player
     * @param board   the board the player interacts with
     * @param scanner the Scanner for user input
     */
    public Human(char symbol, Board board, Scanner scanner) {
        this.symbol = symbol;
        this.board = board;
        this.scanner = scanner;
    }

    /**
     * Prompts the user to enter their move, validates it, and updates the board.
     */
    public void move() {
        String inp;
        while (true) {
            // Prompt the user for a move
            System.out.print("What is your move? ");
            inp = scanner.nextLine().trim();
            // Check if the move is valid and, if so, update the board and exit.
            if (Rules.isValidMove(board, inp)) {
                Player.placeMove(board, inp, symbol);
                break;
            } else {
                // Invalid move entered
                System.out.println("\nThat is not a valid move! Try again.\n");
            }
        }
    }
}
