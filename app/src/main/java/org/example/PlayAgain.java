package org.example;

import java.util.Scanner;

/**
 * This class provides a static method to prompt the user
 * to decide if they want to play the Tic-Tac-Toe game again.
 * It handles user input validation and only returns when a clear
 * "yes" or "no" response is given.
 */
public class PlayAgain {

    /**
     * Prompts the user to enter "yes" or "no"
     * to decide whether they want to play again.
     * Continues prompting until a valid response is received.
     *
     * @param scnr the Scanner object to read the input from the user
     * @return true if the user wants to play again, false otherwise
     */
    public static boolean askPlayAgain(Scanner scnr) {
        while (true) {
            System.out.print("\nWould you like to play again (yes/no)? ");
            String entry = scnr.nextLine().trim();
            if (entry.equalsIgnoreCase("yes") || entry.equalsIgnoreCase("y")) return true;
            if (entry.equalsIgnoreCase("no")  || entry.equalsIgnoreCase("n")) return false;
            System.out.println("That is not a valid entry!");
        }
    }
}