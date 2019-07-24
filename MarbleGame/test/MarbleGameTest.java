import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// 1
// 1 2
// 1 3 2 --> Player 1 gets 2 points
// 1 4 3 2
// 1 4 3 5 2
// 1 4 3 5 2 6 --> Player 2 gets 1 point
// 1 4 7 3 5 2 6
// 1 4 7 3 8 5 2 6
// 1 4 7 3 8 5 9 2 6 --> Player 1 gets 8 points
// 1 4 7 3 8 5 10 9 2 6
// 1 4 7 3 8 5 10 9 11 2 6
// 1 4 7 3 8 5 10 9 11 2 12 6 --> Player 2 gets 5 points


class MarbleGameTest {

    @Test
    void getWinnerReturnsCorrectWinner() {
        MarbleGame game1 = new MarbleGame(1);
        assertEquals(0, game1.getWinner());

        MarbleGame game2 = new MarbleGame(3);
        assertEquals(1, game2.getWinner());

        MarbleGame game3 = new MarbleGame(6);
        assertEquals(1, game3.getWinner());

        MarbleGame game4 = new MarbleGame(9);
        assertEquals(1, game4.getWinner());

        MarbleGame game5 = new MarbleGame(12);
        assertEquals(1, game5.getWinner());
    }

    @Test
    void getScoreReturnsCorrectScore() {
        MarbleGame game1 = new MarbleGame(1);
        assertEquals(0, game1.getScore());

        MarbleGame game2 = new MarbleGame(3);
        assertEquals(2, game2.getScore());

        MarbleGame game3 = new MarbleGame(6);
        assertEquals(2, game3.getScore());

        MarbleGame game4 = new MarbleGame(9);
        assertEquals(10, game4.getScore());

        MarbleGame game5 = new MarbleGame(12);
        assertEquals(10, game5.getScore());
    }

}