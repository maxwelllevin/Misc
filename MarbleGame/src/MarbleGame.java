import java.util.ArrayList;
import java.util.Arrays;

// Game Rules:
// 1) Player 1 places a marble (1) on the circle and ends their turn.
// 2) The next player moves one place on the circle (clockwise) and places a marble after the existing one
// 3) If the marble placed is divisible by three, then the player who placed it moves the place 7 spaces on the
// circle and receives points equal to the number of the marble they land on.

// Example game state for 1 -> 7 marbles total and two players:
// 1
// 1 2
// 1 3 2 --> Player 1 gets 2 points
// 1 4 3 2
// 1 4 3 5 2
// 1 4 3 5 2 6 --> Player 2 gets 1 point
// 1 4 7 3 5 2 6

public class MarbleGame {

    private int gamePosition;
    private int numMarbles;
    private boolean gameCompleted;
    private int[] scoreboard;
    private ArrayList<Integer> gameBoard;


    public MarbleGame(int numMarbles) {
        if (numMarbles < 1) throw new IllegalArgumentException("Error: parameter numMarbles must be 1 or more");
        this.gamePosition = 0;
        this.numMarbles = numMarbles;
        this.gameCompleted = false;
        this.scoreboard = new int[3];
        this.gameBoard = new ArrayList<>(numMarbles);
    }


    private void placeMarble(int m) {
        gamePosition = (gamePosition + 1) % (m - 1);  // moves 1 place clockwise
        gameBoard.add(++gamePosition, m);  // add inserts BEFORE the given index
    }


    private void scoreMarble(int m) {
        if (m % 3 == 0) {
            gamePosition = (gamePosition + 7) % m;
            scoreboard[((m + 1) % 2) + 1] += gameBoard.get(gamePosition);
        }
    }


    private void move(int m) {
        placeMarble(m);
        scoreMarble(m);
    }


    private void runGame() {
        if (gameCompleted) return;
        gameBoard.add(gamePosition, 1);
        for (int marble = 2; marble < numMarbles + 1; marble++) move(marble);
        gameCompleted = true;
    }


    public int getWinner() {
        if (!gameCompleted) runGame();
        int[] sorted = Arrays.copyOf(scoreboard, scoreboard.length);
        Arrays.sort(sorted);
        if (sorted[sorted.length - 1] == sorted[sorted.length - 2]) return 0;
        for (int i = 0; i < scoreboard.length; i++) {
            if (scoreboard[i] == sorted[sorted.length - 1]) return i;
        }
        return -1;
    }


    public int getScore() {
        return scoreboard[getWinner()];
    }


    @Override
    public String toString() {
        if (gameBoard.isEmpty()) return "Game has not yet been played\n";
        return "Game Board:\n" +
                gameBoard.toString() + "\n" +
                "Winner: " + getWinner() + "\n" +
                "Winner's score: " + scoreboard[getWinner()] + "\n";
    }


    public static void main(String[] args) {
        MarbleGame game1 = new MarbleGame(1);
        System.out.println(game1);

        MarbleGame game2 = new MarbleGame(3);
        game2.runGame();
        System.out.println(game2);

        MarbleGame game3 = new MarbleGame(6);
        game3.runGame();
        System.out.println(game3);

        MarbleGame game4 = new MarbleGame(9);
        game4.runGame();
        System.out.println(game4);

    }

}
