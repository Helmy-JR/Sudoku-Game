import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SudokuGame extends JFrame implements ActionListener {
    // Declaration of class variables
    private JTextField[][] grid;
    private JButton checkButton;
    private JButton resetButton;
    private JButton newOneButton;
    private int[][] sudokuBoard; // Store the original Sudoku board

    // Constructor for the SudokuGame class
    public SudokuGame() {
        setTitle("Sudoku Game"); // Set the title of the JFrame
        setSize(400, 400); // Set the size of the JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Set default close operation
        setLayout(new GridLayout(10, 9)); // Set layout for the JFrame

        grid = new JTextField[9][9]; // Initialize the grid for Sudoku
        // Loop to create the grid of JTextFields
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = new JTextField(); // Create a new JTextField
                add(grid[i][j]); // Add the JTextField to the JFrame
            }
        }

        // Create and configure the "Check" button
        checkButton = new JButton("Check");
        checkButton.addActionListener(this); // Add ActionListener to the button
        add(new JLabel()); // Add an empty JLabel
        add(checkButton); // Add the "Check" button to the JFrame

        // Create and configure the "Reset" button
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this); // Add ActionListener to the button
        add(new JLabel()); // Add an empty JLabel
        add(resetButton); // Add the "Reset" button to the JFrame

        // Create and configure the "New One" button
        newOneButton = new JButton("New One");
        newOneButton.addActionListener(this); // Add ActionListener to the button
        add(new JLabel()); // Add an empty JLabel
        add(newOneButton); // Add the "New One" button to the JFrame

        sudokuBoard = generateSudokuPuzzle(); // Generate a new Sudoku puzzle upon startup
        updateGrid(sudokuBoard); // Update the grid with the generated puzzle

        setVisible(true); // Set the JFrame to be visible
    }

    // ActionListener method to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which button was clicked
        if (e.getSource() == checkButton) {
            if (checkSolution()) { // Check if the current solution is correct
                JOptionPane.showMessageDialog(this, "Congratulations! You solved the Sudoku puzzle.");
            } else {
                JOptionPane.showMessageDialog(this, "Sorry, your solution is not correct. Please try again.");
            }
        } else if (e.getSource() == resetButton) { // Reset button clicked
            resetBoard(); // Reset the Sudoku board
        } else if (e.getSource() == newOneButton) { // New One button clicked
            sudokuBoard = generateSudokuPuzzle(); // Generate a new Sudoku puzzle
            updateGrid(sudokuBoard); // Update the grid with the new puzzle
        }
    }

    // Method to reset the user-input cells only, keeping the pre-filled cells intact
    private void resetBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudokuBoard[i][j] == 0) {
                    grid[i][j].setText(""); // Clear the user-input cells
                }
            }
        }
    }

    // Method to update the grid with the new Sudoku puzzle
    private void updateGrid(int[][] puzzle) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (puzzle[i][j] != 0) {
                    grid[i][j].setText(String.valueOf(puzzle[i][j])); // Set text for pre-filled cells
                    grid[i][j].setEditable(false); // Lock the pre-filled cells
                } else {
                    grid[i][j].setText(""); // Clear the user-input cells
                    grid[i][j].setEditable(true); // Allow the user to fill empty cells
                }
            }
        }
    }

    // Method to generate a new Sudoku puzzle
    private int[][] generateSudokuPuzzle() {
        int[][] puzzle = new int[9][9]; // Initialize the puzzle array

        // Hardcoded completed Sudoku puzzle
        int[][] completedPuzzle = {
            {5,3,4,6,7,8,9,1,2},
            {6,7,2,1,9,5,3,4,8},
            {1,9,8,3,4,2,5,6,7},
            {8,5,9,7,6,1,4,2,3},
            {4,2,6,8,5,3,7,9,1},
            {7,1,3,9,2,4,8,5,6},
            {9,6,1,5,3,7,2,8,4},
            {2,8,7,4,1,9,6,3,5},
            {3,4,5,2,8,6,1,7,9}
        };

        // Copy the completed puzzle to the puzzle array
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                puzzle[i][j] = completedPuzzle[i][j];
            }
        }

        // Remove numbers randomly to create a partially completed puzzle
        Random random = new Random();
        int toRemove = 40; // Number of cells to remove (adjustable)
        while (toRemove > 0) {
            int i = random.nextInt(9);
            int j = random.nextInt(9);
            if (puzzle[i][j] != 0) {
                puzzle[i][j] = 0;
                toRemove--;
            }
        }

        return puzzle; // Return the generated Sudoku puzzle
    }

    // Hardcoded solution for the Sudoku puzzle
    int[][] solution2 = {
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    // Method to check if the current solution is correct
    private boolean checkSolution() {
        int[][] currentState = getCurrentGridState(); // Get the current grid state
    
        // Compare currentState with the hardcoded solution to check the solution
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // Check only non-empty and complete cells
                if (currentState[i][j] != solution2[i][j]) {
                    return false; // If any cell doesn't match, return false immediately
                }
            }
        }
    
        return true; // If all conditions are satisfied, return true
    }
    

    // Method to get the current grid state
    private int[][] getCurrentGridState() {
        int[][] currentState = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String text = grid[i][j].getText();
                currentState[i][j] = text.isEmpty() ? -1 : Integer.parseInt(text);
            }
        }
        return currentState; // Return the current grid state
    }
    

    // Main method to start the Sudoku game
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SudokuGame::new); // Create an instance of SudokuGame
    }
}
