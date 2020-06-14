import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void drawBoard() {
        TicTacToe test = new TicTacToe();
        // Board of size 3.
        char[][] moves = {{'X', '_', 'X'}, {'X', 'O', 'O'}, {'_', 'O', 'O'}};
        test.drawBoard(moves);
        // Board of size 4.
        moves = new char[][]{{'X', '_', 'X', 'X'}, {'O', '_', 'O', 'O'}, {'X', 'X', '_', 'X'}, {'O', 'O', 'O', 'O'}};
        test.drawBoard(moves);
        // Board of size 5.
        moves = new char[][]{{'X', 'X', '_', 'X', 'X'}, {'O', '_', 'O', 'O', 'O'},
                                {'X', '_', 'X', 'X', 'X'}, {'O', 'O', 'O', 'O', '_'}, {'_', 'O', 'X', 'O', 'X'}};
        test.drawBoard(moves);
    }

    @Test
    void toArray() {
        TicTacToe test = new TicTacToe();

        // Board of size 3.
        char[][] moves = {{'X', '_', 'X'}, {'X', 'O', 'O'}, {'_', 'O', 'O'}};
        assertArrayEquals(test.toArray("X_XXOO_OO", 3), moves,
                "Test to see if the given string gives the correct array of 2-dimensional array size 3");

        // Board of size 4.
        moves = new char[][]{{'X', '_', 'X', 'X'}, {'O', '_', 'O', 'O'}, {'X', 'X', '_', 'X'}, {'O', 'O', 'O', 'O'}};
        assertArrayEquals(test.toArray("X_XXO_OOXX_XOOOO", 4), moves,
                "Test to see if the given string gives the correct array of 2-dimensional array size 4");

        // Board of size 5.
        moves = new char[][]{{'X', 'X', '_', 'X', 'X'}, {'O', '_', 'O', 'O', 'O'},
                {'X', '_', 'X', 'X', 'X'}, {'O', 'O', 'O', 'O', '_'}, {'_', 'O', 'X', 'O', 'X'}};
        assertArrayEquals(test.toArray("XX_XXO_OOOX_XXXOOOO__OXOX", 5), moves,
                "Test to see if the given string gives the correct array of 2-dimensional array size 5");
    }
}