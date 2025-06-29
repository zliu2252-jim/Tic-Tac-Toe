# Tic-Tac-Toe (Java)

A simple two-player Tic-Tac-Toe game you can run in the terminal, written in Java with Gradle. Includes full input validation, win/draw detection, a “play again” loop, and end-to-end JUnit tests.

## Table of Contents

- [About](#about)  
- [Prerequisites & Initial Setup](#prerequisites--initial-setup)  
- [Building the App](#building-the-app)  
- [Testing the App](#testing-the-app)  
- [Running the App](#running-the-app)

## About

This console application lets two human players **X** and **O** on a numbered 3*3 grid. The game:

- Validates moves (numeric, in-range, not occupied)  
- Detects wins (rows, columns, diagonals) and draws  
- Prompts to “play again?” with yes/no validation  
- Never crashes on invalid input  

A companion JUnit 5 test suite (`AppTest.java`) drives the full `main()` loop to verify all behaviors.

## Prerequisites & Initial Setup

1. **Clone the repository**  
   ```bash
   git clone https://github.com/your-username/tic-tac-toe-console.git
   cd tic-tac-toe-console

## Building the App

You can build the app using:

```bash
./gradlew build
```

## Testing the App

You can run the automated suite of tests using:

```bash
./gradlew test
```

## Running the App

You can run the app using:

```bash
./gradlew run --quiet --console=plain
```

The two flags passed to the `run` command hide the noisy output from Gradle. You can see the details from Gradle by omitting those flags.
