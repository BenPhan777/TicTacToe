import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void testDrawBoard() {
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
    void testToArray() {
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

    @Test
    void testGetResult() {
        TicTacToe test = new TicTacToe();

        // Board of size 3.
        char[][] moves = {{'X', '_', 'X'}, {'X', 'O', 'O'}, {'_', 'O', 'O'}};
        assertEquals("The game has not finished!" , test.getResult(moves),
                                             "Test with an unfinished game.");
        moves = new char[][]{{'X', 'X', 'X'}, {'O', 'O', 'O'}, {'_', 'X', 'O'}};
        assertEquals("This is impossible!" , test.getResult(moves),
                                             "Test with an impossible game (both players win).");
        moves = new char[][]{{'X', 'X', 'X'}, {'O', 'X', 'O'}, {'_', 'X', 'O'}};
        assertEquals("This is impossible!" , test.getResult(moves),
                                             "Test with an impossible game (too many X).");

        // Board of size 4.
        moves = new char[][]{{'X', 'X', 'X', 'O'}, {'O', 'X', 'O', 'O'}, {'X', 'X', 'X', 'O'}, {'O', '_', 'O', 'O'}};
        assertEquals("Player O wins, congratulations!", test.getResult(moves),
                                            "Test with player O wins the game.");
        moves = new char[][]{{'X', 'O', 'X', 'X'}, {'O', 'X', 'O', 'O'}, {'X', 'X', 'O', 'X'}, {'O', 'O', 'X', 'O'}};
        assertEquals("The game is draw!", test.getResult(moves),
                                            "Test with a draw game.");

        // Board of size 5.
        moves = new char[][]{{'X', 'X', 'X', 'X', 'X'}, {'O', '_', 'O', 'O', 'O'},
                {'X', '_', 'X', 'X', 'X'}, {'O', 'O', 'O', 'O', '_'}, {'_', 'O', 'X', 'O', 'X'}};
        assertEquals("Player X wins, congratulations!", test.getResult(moves),
                "Test with player X wins the game.");
    }
}