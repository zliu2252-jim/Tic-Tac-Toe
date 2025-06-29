# Tic-Tac-Toe (Java)

A simple two-player Tic-Tac-Toe game you can run in the terminal, written in Java with Gradle. Includes full input validation, win/draw detection, a “play again” loop, and end-to-end JUnit tests.

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

Tic-Tac-Toe is a classic game played on a 3*3 grid. In this console version, two human players alternate placing **X** and **O** in cells numbered 1–9. The program validates every move (must be numeric, between 1 and 9, and on an unoccupied cell), detects wins (three in a row horizontally, vertically, or diagonally) and draws (full board with no winner), and then prompts players to play again—all without ever crashing on bad input.

We built it in Java for simplicity and portability, using plain `System.in`/`System.out` and a 2D `char` array for the board. Challenges included robustly handling all forms of invalid input (letters, out-of-range numbers, occupied cells) and designing clear console prompts.

## Features

- Human-vs-Human play in the terminal  
- Numbered cells (1–9) for intuitive input  
- Full input validation  
- Automatic win/draw detection  
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
mkdir -p out
javac -d out src/main/java/org/example/App.java
```

## Run the App

You can run the app using: 
```bash
java -cp out org.example.App
```

## Testing the App

You can run the automated suite of tests using:
```bash
javac -d out \
  --module-path path/to/junit-platform-console-standalone.jar \
  --add-modules junit \
  src/test/java/org/example/AppTest.java
```
```bash
java -jar path/to/junit-platform-console-standalone.jar \
  --class-path out \
  --scan-class-path
```

## How to Use

1. At the beginning of the program, it contains a welcome message. 
2. When the program asks "Player X, what is your move? (1-9)" or "Player O, what is your move? (1-9)", please enter a move by typing the number from 1 to 9.
3. If you enter an invalid input or blank, the program will warn you, "This is not a valid move. Try again."
4. Watch the board update after each valid move.
5. When someone wins, or it’s a draw, you’ll see: "Player X wins!" or "Player O wins!" or "The game ended in a tie!"
6. At the end of the program, it may ask you to play again; you can enter yes or no.
7. If you enter a blank rather than "yes" or "no", the program will warn you, "That is not a valid entry!"
8. When you enter no, you will see a "Goodbye!" message.

## Credits

Author: Zhengjia Liu
Inspiration: Tic-Tac-Toe game
Testing: JUnit 5 Testing

## License

This project is licensed under the MIT License.
