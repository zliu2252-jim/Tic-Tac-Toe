package org.example;

import java.util.Scanner;

/**
 * This class handles prompting the user to play another game.
 * It ensures the user enters a valid "yes" or "no" response, and returns
 * a boolean indicating their choice.
 */
public class PlayAgain {

    /**
     * Prompts the user to decide if they want to play another round.
     * Accepts "yes", "y", "no", or "n". Keeps prompting for valid input.
     *
     * @param scnr the Scanner object for reading user input
     * @return true if user wants to play again, false if not
     */
    public static boolean askPlayAgain(Scanner scnr) {
        while (true) {
            // Prompt user for replay
            System.out.print("\nWould you like to play again (yes/no)? ");
            String entry = scnr.nextLine().trim();
            // Accept "yes" or "y"
            if (entry.equalsIgnoreCase("yes") || entry.equalsIgnoreCase("y"))
                return true;
            // Accept "no" or "n"
            if (entry.equalsIgnoreCase("no")  || entry.equalsIgnoreCase("n"))
                return false;
            // Otherwise, print error and prompt again
            System.out.println("That is not a valid entry!");
        }
    }
}
