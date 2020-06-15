import java.util.Scanner;
/*****************************************************************************
*   Name: Ben Phan.
*   Project Name: Tic Tac Toe.
*   Date of Last Modification: June 15, 2020.
*   Purpose: Display and allow users to play Tic Tac Toe through the console.
******************************************************************************/

public class TicTacToe {
    /***************************************************************************************************************
     *   toArray(String input, int size)
     *   Purpose: Take a given string input and return a 2-dimensional array filled with the content of that string.
     *   Pre-conditions:
     *       @param input: A string representing user's moves.
     *       @param size: the size of the board game.
     *   Post-conditions: None.
     *   Return: A 2-dimensional array containing positions of X, O or underscore.
     ***************************************************************************************************************/
    public char[][] toArray(String input, int size) {
        char [][] returnArray = new char[size][size];

        // Go through each column and row of the array,
        // and insert the character at index charIdx of the input string to the array.
        int charIdx = 0;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                returnArray[row][column] = input.charAt(charIdx);
                charIdx++;
            }
        }
        return returnArray;
    }

    /****************************************************************************************************
     *   drawBoard(char[][] movesArray) {
     *   Purpose: Display a tic tac toe game to the console.
     *   Pre-conditions:
     *       @param movesArray: A 2-dimensional array containing positions of X, O or underscore.
     *   Post-conditions: Display a tic tac toe game to the console.
     *   Return: None.
     *****************************************************************************************************/
    public void drawBoard(char[][] movesArray) {
        System.out.println("-".repeat(movesArray.length * 2 + 3)); // Display the top border of the game board.

        // Going through each row and column of movesArray to display players' moves.
        for (char[] row : movesArray) {
            System.out.print("| ");
            for (char move: row) {
                if (move == '_') {   // Leave a blank space if neither players had made their moves here.
                    System.out.print("  ");
                } else {   // Display the player's move if there is one.
                    System.out.print(move + " ");
                }
            }
            System.out.print("|\n");
        }

        System.out.println("-".repeat(movesArray.length * 2 + 3)); // Display the bottom border of the game board.
    }

    /****************************************************************************************************
     *   getResult(char[][] movesArray) {
     *   Purpose: Display the result of the tic tac toe game to the console.
     *   Pre-conditions:
     *       @param movesArray: A 2-dimensional array containing positions of X, O or underscore.
     *   Post-conditions: Display the result of the tic tac toe game to the console.
     *   Return: A string represent the result of the game.
     *****************************************************************************************************/
    public String getResult(char[][] movesArray) {
        int numX = 0, numO = 0, num_ = 0; // Number of X, O and _ on the board.
        String compareX = "X".repeat(movesArray.length), compareO = "O".repeat(movesArray.length); // Strings used to
        // check for winner.
        boolean winX = false, winO = false; // True if either of them win the game.

        // Check horizontally for a win and count the number of X and O in the process.
        for (char[] row : movesArray) {
            StringBuilder movesInRow = new StringBuilder(); // A set of moves in a row to check for the winner.
            for (char currChar : row) {  // Check each character in the row.
                movesInRow.append(currChar);
                if (currChar == 'X') { // Increase numX, numO or num_ if currChar is X, O or _ respectively.
                    numX++;
                } else if (currChar == 'O') {
                    numO++;
                } else {
                    num_++;
                }
            }
            if (movesInRow.toString().equals(compareX)) { // If movesInRow has a set of X then X wins, same with O.
                winX = true;
            } else if (movesInRow.toString().equals(compareO)) {
                winO = true;
            }
        }

        // Check vertically for a win and count the number of X and O in the process.
        for (int i = 0; i < movesArray.length; i++) {
            StringBuilder movesInRow = new StringBuilder(); // A set of moves in a row to check for the winner.
            for (char[] row : movesArray) {
                movesInRow.append(row[i]);
            }
            if (movesInRow.toString().equals(compareX)) { // If movesInRow has a set of X then X wins, same with O.
                winX = true;
            } else if (movesInRow.toString().equals(compareO)) {
                winO = true;
            }
        }

        // Check diagonally for a win and count the number of X and O in the process.
        StringBuilder leftDiagonal = new StringBuilder();
        StringBuilder rightDiagonal = new StringBuilder();
        int DiagonalIdx = 0; // Index of the diagonal positions.
        for (char[] row : movesArray) { // Get the moves at the diagonal positions.
            leftDiagonal.append(row[DiagonalIdx]);
            rightDiagonal.append(row[movesArray.length - 1 - DiagonalIdx]);
            DiagonalIdx++;
        }
        if (leftDiagonal.toString().equals(compareO) || rightDiagonal.toString().equals(compareO)) {
            winO = true;         // Check if either X or O occupies the diagonal positions in a row.
        }
        if (leftDiagonal.toString().equals(compareX) || rightDiagonal.toString().equals(compareX)) {
            winX = true;
        }

        // Display the result.
        if ((winO && winX) || (numX - numO >= 2 || numO - numX >= 2)) { // 3 X and 3 O in a row at the same time
            return "This is impossible!";                // or there are 2 or more X than O and vice versa.
        } else if (!winO && !winX && num_ > 0) { // When no side has a three in a row but the field has empty cells;
            return "The game has not finished!";
        } else if (!winO && !winX && num_ == 0) { // When no side has a three in a row and the field has no empty cells;
            return "The game is draw!";
        } else if (winO) { // When O wins.
            return "Player O wins, congratulations!";
        } else {  // When X wins.
            return "Player X wins, congratulations!";
        }
    }
    /****************************************************************************************************
    *   main(String[] args)
    *   Purpose: display a tic tac toe game to the console using users' inputs, and determine the result.
    *   Pre-conditions:
    *       @param args: an array of string arguments, empty in this case.
    *   Post-conditions: display a tic tac toe game to the console and its result.
    *   Return: None.
    *****************************************************************************************************/
    public static void main(String[] args) {
        // Ask for the user's input.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the board game here: ");
        int boardSize = scanner.nextInt();
        System.out.print("Enter your move here: ");
        String userInput = scanner.next();    // The input needed to draw the game board.
        scanner.close();

        // Display the tictactoe game.
        TicTacToe game = new TicTacToe();
        char[][] arrayOfMoves = game.toArray(userInput, boardSize);
        game.drawBoard(arrayOfMoves);
        System.out.println(game.getResult(arrayOfMoves));
    }
}
