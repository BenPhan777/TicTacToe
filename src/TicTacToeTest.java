import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void drawBoard() {
        TicTacToe test = new TicTacToe();
        // Board of size 3.
        String[][] moves = {{"X", "_", "X"}, {"X", "O", "O"}, {"_", "O", "O"}};
        test.drawBoard(moves);
        // Board of size 4.
        moves = new String[][]{{"X", "_", "X", "X"}, {"O", "_", "O", "O"}, {"X", "X", "_", "X"}, {"O", "O", "O", "O"}};
        test.drawBoard(moves);
        // Board of size 5.
        moves = new String[][]{{"X", "X", "_", "X", "X"}, {"O", "_", "O", "O", "O"},
                                {"X", "_", "X", "X", "X"}, {"O", "O", "O", "O", "_"}, {"_", "O", "X", "O", "X"}};
        test.drawBoard(moves);
    }
}