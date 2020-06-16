import java.util.Scanner;
/*****************************************************************************
*   Name: Ben Phan.
*   Project Name: Tic Tac Toe.
*   Date of Last Modification: June 15, 2020.
*   Purpose: Display and allow users to play Tic Tac Toe through the console.
******************************************************************************/

public class TicTacToe {
    /****************************************************************************************************
     *   getSize()
     *   Purpose: Get the size of the tictactoe board from the user.
     *   Pre-conditions: None.
     *   Post-conditions: Asking the user for the board size on the console.
     *   Return: The size of the board game (integer).
     *****************************************************************************************************/
    private int getSize() {
        // Ask for the size of the board game.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the board game here: ");
        boolean isInt = scanner.hasNextInt();
        while (!isInt) {  // Ask for input again if the previous one was not an integer.
            scanner.next();
            System.out.print("Enter the size of the board game here (integer only): ");
            isInt = scanner.hasNextInt();
        }
        int sizeOfBoard = scanner.nextInt(); // The valid size of the board to pass to other methods.
        scanner.reset();
        return sizeOfBoard;
    }

    /****************************************************************************************************
     *   getXorO()
     *   Purpose: Give the user the option to choose between X or O to start with and return their choice.
     *   Pre-conditions: None.
     *   Post-conditions: Ask the user to choose between X or O.
     *   Return: True if X is chosen; false otherwise.
     *****************************************************************************************************/
    private boolean getXorO() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to be X or O? Enter your choice here: ");
        String xo = scanner.next().toUpperCase();
        while (!("X".equals(xo) || "O".equals(xo))) {  // Ask for input again if the previous one was neither X or O.
            System.out.print("Must be X or O only. Enter your choice again here: ");
            xo = scanner.next().toUpperCase();
        }
        scanner.reset();
        return "X".equals(xo);
    }

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
     *   drawBoard(char[][] movesArray)
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
     *   checkIfDone(char[][] movesArray)
     *   Purpose: Check if the board game is fully filled with players' moves.
     *   Pre-conditions:
     *       @param movesArray: A 2-dimensional array containing positions of X, O or underscore.
     *   Post-conditions: None.
     *   Return: True if the board is full (no underscore), False otherwise.
     *****************************************************************************************************/
    public boolean checkIfDone(char[][] movesArray) {
        for (char[] row: movesArray) {
            for (char move: row) {
                if (move == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    /****************************************************************************************************
     *   startGame(char[][] movesArray, int sizeOfBoard, TicTacToe theGame)
     *   Purpose: Start the tictactoe game by filling the blank spot on the board as the users providing inputs.
     *   Pre-conditions:
     *       @param movesArray: A 2-dimensional array containing positions of X, O or underscore.
     *       @param sizeOfBoard: The size of the board game (integer).
     *       @param theGame: the TicTacToe object to call methods on.
     *   Post-conditions: Display the game and modify movesArray based on user's inputs as the game goes on.
     *   Return: A character represent the result of the game.
     *****************************************************************************************************/
    public char startGame(char[][] movesArray, int sizeOfBoard, TicTacToe theGame) {
        Scanner scanner = new Scanner(System.in);
        boolean xTurn = theGame.getXorO(); // Who goes first (X or O)?
        int x, y;      // The coordinate on the board.
        char result = 'n';   // result to stop the game if either O or X wins.
        while (!theGame.checkIfDone(movesArray)) { // Only stop asking for input when the game is done.
            do {
                System.out.print("Enter the coordinate of your move here (example: 2 3): ");
                boolean isXInt = scanner.hasNextInt();
                boolean isYInt = scanner.hasNextInt();
                while (!(isXInt && isYInt)) {  // Ask for input again if the previous one was not an integer.
                    scanner.nextLine();
                    System.out.print("Please enter the coordinate of your move again (integer only): ");
                    isXInt = scanner.hasNextInt();
                    isYInt = scanner.hasNextInt();
                }
                x = scanner.nextInt();
                y = scanner.nextInt();
                // prompt the user that their input is in wrong range if the while-loop repeats more than once.
                if (!(y > 0 && y <= sizeOfBoard && x > 0 && x <= sizeOfBoard)) {
                    System.out.println("Please only enter number in range " + 1 + "-" + sizeOfBoard);
                }
            } while (!(y > 0 && y <= sizeOfBoard && x > 0 && x <= sizeOfBoard)); // Check that the coordinate
                                                                                 // is in valid range.
            if (movesArray[Math.abs(y - sizeOfBoard)][x - 1] != '_') {
                System.out.println("This spot is already occupied. Please choose another spot!");
            } else if (xTurn) {       // Fill in X if it's X's turn, same with O.
                movesArray[Math.abs(y - sizeOfBoard)][x - 1] = 'X';
                xTurn = false;        // Not X's turn, meaning O's turn.
            } else {
                movesArray[Math.abs(y - sizeOfBoard)][x - 1] = 'O';
                xTurn = true;         // Not X's turn, meaning O's turn.
            }
            drawBoard(movesArray);    // Update the board after the player just made their move.
            result = theGame.getResult(movesArray);
            if (result == 'O' || result == 'X') {
                break;
            }
        }
        scanner.reset();
        return result;
    }

    /****************************************************************************************************
     *   getResult(char[][] movesArray)
     *   Purpose: Display the result of the tic tac toe game to the console.
     *   Pre-conditions:
     *       @param movesArray: A 2-dimensional array containing positions of X, O or underscore.
     *   Post-conditions: Display the result of the tic tac toe game to the console.
     *   Return: A character represent the result of the game.
     *****************************************************************************************************/
    public char getResult(char[][] movesArray) {
        String compareX = "X".repeat(movesArray.length), compareO = "O".repeat(movesArray.length); // Strings used to
                                                                                                   // check for winner.
        // Check horizontally for a win and count the number of X and O in the process.
        for (char[] row : movesArray) {
            StringBuilder movesInRow = new StringBuilder(); // A set of moves in a row to check for the winner.
            for (char currChar : row) {  // Check each character in the row.
                movesInRow.append(currChar);
            }
            if (movesInRow.toString().equals(compareX)) { // If movesInRow has a set of X then X wins, same with O.
                return 'X'; // When X wins.
            } else if (movesInRow.toString().equals(compareO)) {
                return 'O'; // When O wins.
            }
        }

        // Check vertically for a win and count the number of X and O in the process.
        for (int i = 0; i < movesArray.length; i++) {
            StringBuilder movesInRow = new StringBuilder(); // A set of moves in a row to check for the winner.
            for (char[] row : movesArray) {
                movesInRow.append(row[i]);
            }
            if (movesInRow.toString().equals(compareX)) { // If movesInRow has a set of X then X wins, same with O.
                return 'X';
            } else if (movesInRow.toString().equals(compareO)) {
                return 'O';
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
        }                                          // Check if either X or O occupies the diagonal positions in a row.
        if (leftDiagonal.toString().equals(compareO) || rightDiagonal.toString().equals(compareO)) {
            return 'O';
        }
        if (leftDiagonal.toString().equals(compareX) || rightDiagonal.toString().equals(compareX)) {
            return 'X';
        }

        // Display the result.
        return 'D';
    }

    /****************************************************************************************************
    *   main(String[] args)
    *   Purpose: Display a tic tac toe game to the console using users' inputs, and determine the result.
    *   Pre-conditions:
    *       @param args: An array of string arguments, empty in this case.
    *   Post-conditions: Display a tic tac toe game to the console and its result.
    *   Return: None.
    *****************************************************************************************************/
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe(); // Initialize the game.
        int boardSize = game.getSize(); // Get the size of the board game for other methods.

        // Display the tictactoe game.
        char[][] arrayOfMoves = game.toArray("_".repeat(boardSize * boardSize), boardSize); // Set up an empty board.
        game.drawBoard(arrayOfMoves);     // Display the empty board game.
        char gameResult = game.startGame(arrayOfMoves, boardSize, game); // Run the game and get the result.

        // Display the result of the game.
        Scanner scanner = new Scanner(System.in);
        if (gameResult == 'O') {
            System.out.print("Player O win the game. Congratulations! Try again? Enter y/n here: ");
        } else if (gameResult == 'X') {
            System.out.print("Player X win the game. Congratulations! Try again? Enter y/n here: ");
        } else {
            System.out.print("The game is draw! Try again? Enter y/n here: ");
        }
        if ("y".equals(scanner.next())) {    // Restart the game.
            main(new String[] {});
        }
    }
}
