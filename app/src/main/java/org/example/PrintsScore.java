package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * This utility class provides static methods for displaying and saving
 * the overall game session results, including X wins, O wins, and ties.
 * It keeps static counters and can print results to the console or to a file.
 */
public class PrintsScore {
    /** Counter for the number of tied games. */
    public static int tieCounter = 0;
    /** Counter for the number of games won by player X. */
    public static int playerXWinCounter = 0;
    /** Counter for the number of games won by player O. */
    public static int playerOWinCounter = 0;

    /**
     * Displays the current win/tie statistics to the console.
     */
    public static void winAndTieCountDisplay() {
        System.out.printf("\nPlayer X Wins   %d", playerXWinCounter);
        System.out.printf("\nPlayer O Wins   %d", playerOWinCounter);
        System.out.printf("\nTies            %d%n", tieCounter);
    }

    /**
     * Writes the win/tie statistics to "game.txt" in the current directory.
     * Handles IO exceptions gracefully and prints an error message if needed.
     */
    public static void winAndTieToFile() {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Paths.get("game.txt")))) {
            writer.printf("Player X Wins   %d", playerXWinCounter);
            writer.printf("\nPlayer O Wins   %d", playerOWinCounter);
            writer.printf("\nTies            %d%n", tieCounter);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}