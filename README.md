# Tic-Tac-Toe (Java)

The Tic-Tac-Toe game written in Java with Gradle. The game supports Human vs Human, Human vs. Computer, and Computer vs. Human modes. It features full input validation, win/draw detection, alternating who goes first, automatic statistics and game log saving, and a computer player. The program also include the JUnit 5 test. 

## Table of Contents

- [Project Description](#project-description)  
- [Features](#features)  
- [Prerequisites & Initial Setup](#prerequisites--initial-setup)  
- [Build the App](#build-the-app)  
- [Run the App](#run-the-app)  
- [Test the App](#test-the-app)  
- [How to Use](#how-to-use)  
- [Credits](#credits)  
- [License](#license)  

## Project Description

Tic-Tac-Toe is a classic game played on a 3*3 grid. In this console version, two human players alternate placing **X** and **O** in cells numbered 1 through 9. The program validates every move; the value that is entered in the cell must be numeric, between 1 and 9, and on an unoccupied cell, detects wins (three in a row horizontally, vertically, or diagonally) and draws (the whole board with no winner), and then prompts players to play again—all without crashing on bad input. After each round, the program prints nicely formatted statistics showing the current number of wins for each player and the number of ties. When you decide not to play again, the game log for the session is saved to disk in a clearly formatted text file. The starting player alternates: the loser of the previous round always goes first in the next game. If the round was a tie, the first and second players swap. You don’t need to load the game log on a new run—the tally only counts games from the current session. If you enter an invalid cell or blank, the program will warn you, and if you give invalid input to the play-again prompt, it will also warn you.

In addition to human-vs-human play, the game supports both "Human vs Computer" and "Computer vs Human" modes, where a computer player can compete against a human. The computer follows a simple strategy: it will take a random corner for its first move, choose the center for its second move if available, win immediately if possible, block the opponent’s winning move if necessary, and otherwise pick a random open spot. The board always displays the computer’s move before prompting the user, ensuring a natural gameplay flow. All input is robustly validated, and the program includes a comprehensive suite of JUnit 5 tests to ensure correctness and reliability.

We built it in Java for simplicity, using plain `System.in`/`System.out` and a 2D `char` array for the board. Challenges included robustly handling all forms of invalid input (letters, out-of-range numbers, occupied cells, blank) and designing clear console prompts.

## Features

- Human-vs-Human play in the terminal  
- Numbered cells (1–9) for intuitive input  
- Full input validation  
- Automatic win/draw detection
- Opportunistic computer player
- Game log tracks wins, losses, and ties, and prints statistics after each round
- When the game exits, the full game log is saved to the disk in the game.txt file.
- The loser goes first in the next game; if a round is tied, the starting player alternates. 
- “Play again?” loop with yes/no validation  
- End-to-end JUnit 5 test suite  

## Prerequisites & Initial Setup

1. **Clone the repository**  
   ```bash
   git clone https://github.com/your-username/tic-tac-toe-console.git
   cd tic-tac-toe-console
   ```

2. **Verify Java installation**
   ```bash
   java -version
   javac -version
   ```
   
## Building the App

You can build the app using:
```bash
./gradlew build
```

## Run the App

You can run the app using: 
```bash
./gradlew run --quiet --console=plain
```

## Testing the App

You can run the automated suite of tests using:
```bash
./gradlew test
```

## How to Use

1. At the beginning of the program, it contains a welcome message and a menu to select the game mode.
2. Enter a number (1-3) to select Human vs Human, HUman vs Computer, or Computer vs Human. 
3. When the program asks "Player X, what is your move? (1-9)" or "Player O, what is your move? (1-9)", please enter a move by typing the number from 1 to 9.
4. If you enter an invalid input or blank, the program will warn you, "This is not a valid move. Try again."
5. Watch the board update after each valid move.
6. When someone wins, or it’s a draw, you’ll see: "Player X wins!" or "Player O wins!" or "The game ended in a tie!"
7. After each round, statistics are printed showing Player X Wins, Player O Wins, and Ties so far. 
8. At the end of the program, it may ask you to play again; you can enter yes or no.
9. If you play again, the loser of the previous round goes first in the new game. If the round was a tie, the starting player alternates. 
10. If you enter a blank rather than "yes" or "no", the program will warn you, "That is not a valid entry!"
11. When you enter no, you will see a "Goodbye!" message.
12. The game log file contains the wins, losses, and ties from the session. 

## Credits

1. Author: Zhengjia Liu
2. Inspiration: Tic-Tac-Toe game
3. Testing: JUnit 5 Testing

## License

This project is licensed under the MIT License.
