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
        char[][] moves = {{'X', 'O', 'O'}, {'X', '_', 'X'}, {'X', 'O', 'O'}};
        assertEquals('X' , test.getResult(moves),
                            "Test with X as winner (board size 3) (vertical win).");
        moves = new char[][]{{'X', 'X', 'X'}, {'O', '_', 'O'}, {'_', 'X', 'O'}};
        assertEquals('X' , test.getResult(moves),
                            "Test with X as winner (board size 3) (horizontal win)");

        // Board of size 4.
        moves = new char[][]{{'X', 'X', 'X', 'O'}, {'O', 'X', 'O', 'O'}, {'X', 'X', 'X', 'O'}, {'O', '_', 'O', 'O'}};
        assertEquals('O', test.getResult(moves),
                            "Test with O as winner (board size 4) (vertical win).");
        moves = new char[][]{{'X', 'O', 'X', 'X'}, {'O', 'X', 'O', 'O'}, {'X', 'X', 'O', 'X'}, {'O', 'O', 'X', 'O'}};
        assertEquals('D', test.getResult(moves),
                            "Test with no one as winner (board size 4) (draw).");
        moves = new char[][]{{'X', '_', '_', 'O'}, {'_', 'X', '_', '_'}, {'_', 'O', 'X', '_'}, {'O', '_', '_', 'X'}};
        assertEquals('X', test.getResult(moves),
                            "Test with X as winner (board size 4) (diagonal win).");

        // Board of size 5.
        moves = new char[][]{{'X', 'X', 'X', 'X', 'X'}, {'O', '_', 'O', 'O', 'O'},
                {'X', '_', 'X', 'X', 'X'}, {'O', 'O', 'O', 'O', '_'}, {'_', 'O', 'X', 'O', 'X'}};
        assertEquals('X', test.getResult(moves),
                            "Test with X as winner (board size 5) (horizontal win).");
    }

    @Test
    void testCheckIfDone() {
        TicTacToe test = new TicTacToe();

        // Board of size 3.
        char[][] moves = {{'X', '_', 'X'}, {'X', 'O', 'O'}, {'_', 'O', 'O'}};
        assertFalse(test.checkIfDone(moves), "Test with an unfinished board of size 3.");
        moves = new char[][]{{'X', 'O', 'X'}, {'X', 'O', 'O'}, {'X', 'O', 'O'}};
        assertTrue(test.checkIfDone(moves), "Test with a finished board of size 3.");

        // Board of size 4.
        moves = new char[][]{{'X', 'X', 'X', 'O'}, {'O', 'X', 'O', 'O'}, {'X', 'X', 'X', 'O'}, {'O', '_', 'O', 'O'}};
        assertFalse(test.checkIfDone(moves), "Test with an unfinished board of size 4.");
        moves = new char[][]{{'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X'}, {'X', 'X', 'X', 'O'}, {'O', 'X', 'O', 'O'}};
        assertTrue(test.checkIfDone(moves), "Test with a finished board of size 4.");
    }
}