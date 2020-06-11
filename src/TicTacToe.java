import java.util.Scanner;
/*****************************************************************************
*   Name: Ben Phan.
*   Project Name: Tic Tac Toe.
*   Date of Last Modification: June 11, 2020.
*   Purpose: Display and allow users to play Tic Tac Toe through the console.
******************************************************************************/

public class TicTacToe {
    /***********************************************************************
    *   main(String[] args)
    *   Purpose: display a tic tac toe game to the console using users' inputs.
    *   Pre-conditions:
    *       @param args: an array of string arguments, empty in this case.
    *   Post-conditions: display a tic tac toe game to the console.
    *   Return: None.
    ************************************************************************/
    public static void main(String[] args) {
        // Ask for the user's input
        System.out.print("Enter cells: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();    // the string to extract the moves from

        // Display the game board along with the moves obtained from the user's input
        System.out.println("_________");
        System.out.println("| " + input.charAt(0) + " " + input.charAt(1) + " " + input.charAt(2) + " |");
        System.out.println("| " + input.charAt(3) + " " + input.charAt(4) + " " + input.charAt(5) + " |");
        System.out.println("| " + input.charAt(6) + " " + input.charAt(7) + " " + input.charAt(8) + " |");
        System.out.println("_________");
    }
}
