import java.util.Scanner;
/*****************************************************************************
*   Name: Ben Phan.
*   Project Name: Tic Tac Toe.
*   Date of Last Modification: June 14, 2020.
*   Purpose: Display and allow users to play Tic Tac Toe through the console.
******************************************************************************/

public class TicTacToe {
    private int size;  // the size of the square board.
    private String[][] userInput;   // a 2-dimensional array containing positions of X and O.

    /****************************************************************************************************
     *   drawBoard()
     *   Purpose: display a tic tac toe game to the console.
     *   Pre-conditions:
     *       @param movesArray: a 2-dimensional array containing positions of X and O.
     *   Post-conditions: display a tic tac toe game to the console.
     *   Return: None.
     *****************************************************************************************************/
    public void drawBoard(String[][] movesArray) {
        System.out.println("-".repeat(movesArray.length * 2 + 3)); // display the top border of the game board.

        // Going through each row and column of movesArray to display players' moves.
        for (String[] row : movesArray) {
            System.out.print("| ");
            for (String move: row) {
                if ("_".equals(move)) {   // leave a blank space if neither players had made their moves here.
                    System.out.print("  ");
                } else {   // display the player's move if there is one.
                    System.out.print(move + " ");
                }
            }
            System.out.print("|\n");
        }

        System.out.println("-".repeat(movesArray.length * 2 + 3)); // display the bottom border of the game board.
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
        // Ask for the user's input
        System.out.print("Enter cells: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();    // the string to extract the moves from

        // Display the game board along with the moves obtained from the user's input
        System.out.println("---------");
        System.out.println("| " + input.charAt(0) + " " + input.charAt(1) + " " + input.charAt(2) + " |");
        System.out.println("| " + input.charAt(3) + " " + input.charAt(4) + " " + input.charAt(5) + " |");
        System.out.println("| " + input.charAt(6) + " " + input.charAt(7) + " " + input.charAt(8) + " |");
        System.out.println("---------");
    }
}
