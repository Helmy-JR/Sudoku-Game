# Sudoku Game Documentation

## Overview

Sudoku is a popular number-placement puzzle game where players fill a 9x9 grid with digits from 1 to 9. Each row, column, and 3x3 subgrid must contain all the digits from 1 to 9 without repetition. This project implements a Sudoku game in Java with a graphical user interface (GUI) using Swing.

## Purpose

The purpose of this project is to provide a playable Sudoku game with the following features:

1. Graphical User Interface (GUI): The game features a graphical interface where players can input numbers into a 9x9 grid.
2. Puzzle Generation: The game generates Sudoku puzzles for players to solve.
3. Solution Checking: Players can check their solutions against the correct solution to verify correctness.
4. Reset Functionality: Players can reset the Sudoku board to its initial state to try again.
5. New Puzzle Generation: Players can generate new Sudoku puzzles to play.

## Functionality

### GUI Components
- **Grid Text Fields**: Displays the 9x9 grid of text fields where players can input numbers.
- **Check Button**: Allows players to check if their solution is correct.
- **Reset Button**: Allows players to reset the Sudoku board.
- **New Puzzle Button**: Allows players to generate a new Sudoku puzzle.
  
### Game Logic
- **Puzzle Generation**: The game generates a new Sudoku puzzle upon startup and when requested by the player.
- **Solution Checking**: Players can check their solution against the correct solution to determine correctness.
- **Reset Functionality**: Players can reset the Sudoku board to its initial state, clearing user input.
- **New Puzzle Generation**: Players can generate new Sudoku puzzles to play.
  
## Structure

### Classes
- **SudokuGame**: Main class that implements the GUI and game logic.

### Methods
- **resetBoard()**: Resets user-input cells while keeping pre-filled cells intact.
- **updateGrid(int[][] puzzle)**: Updates the Sudoku grid with a new puzzle.
- **generateSudokuPuzzle()**: Generates a new Sudoku puzzle.
- **checkSolution()**: Compares the current solution with the correct solution to determine correctness.
- **getCurrentGridState()**: Retrieves the current state of the Sudoku grid.

## Usage

1. Run the program to launch the Sudoku game.
2. Input numbers into the grid to solve the Sudoku puzzle.
3. Click the "Check" button to verify your solution.
4. Use the "Reset" button to clear your input and restart the puzzle.
5. Click the "New One" button to generate a new Sudoku puzzle.

## Conclusion

The Sudoku game project provides an interactive implementation of the classic puzzle game with a graphical interface. It demonstrates the use of Java Swing for building GUI applications and implements core game logic for puzzle generation, solution checking, and user interaction.
