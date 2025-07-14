package org.example;

import java.util.Scanner;

/**
 * This class represents a human player in the Tic-Tac-Toe game.
 * It handles prompting the player for their move and placing their symbol
 * on the board.
 */
public class Human {
    // The symbol for this player ('X' or 'O')
    private final char symbol;
    // The game board for the two players using
    private final Board board;
    // Scanner for reading user input
    private final Scanner scanner;

    /**
     * Constructs the new Human player with the given symbol, board, and scanner.
     *
     * @param symbol the player's symbol ('X' or 'O')
     * @param board the Board object representing the Tic-Tac-Toe game
     * @param scanner the Scanner for reading user input
     */
    public Human(char symbol, Board board, Scanner scanner) {
        this.symbol = symbol;
        this.board = board;
        this.scanner = scanner;
    }

    /**
     * Prompts the player to enter their move, validates the input,
     * and places the symbol on the board if the move is valid.
     * Keeps prompting until a valid move is entered.
     */
    public void move() {
        String inp;
        while (true) {
            System.out.print("Player " + symbol + ", what is your move? (1-9): ");
            inp = scanner.nextLine().trim();
            if (Rules.isValidMove(board, inp)) {
                Player.placeMove(board, inp, symbol);
                break;
            } else {
                System.out.println(inp + " is not a valid move");
            }
        }
    }
}