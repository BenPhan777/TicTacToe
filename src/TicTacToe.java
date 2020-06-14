import java.util.Scanner;
/*****************************************************************************
*   Name: Ben Phan.
*   Project Name: Tic Tac Toe.
*   Date of Last Modification: June 14, 2020.
*   Purpose: Display and allow users to play Tic Tac Toe through the console.
******************************************************************************/

public class TicTacToe {
    /***************************************************************************************************************
     *   toArray(String input)
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
        game.drawBoard(game.toArray(userInput, boardSize));
    }
}
