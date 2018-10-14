package main;

/**
 * @author Klausmp
 */
//TODO game over screen

public class Main {
    public static final String gameTitle = "Space Invaders";
    public static int highScore = 0;
    public static GameLoop gameLoop = new GameLoop();

    public static void main(String[] args) {
        gameLoop.init();
        gameLoop.run();
    }

    public static String getGameTitle() {
        return gameTitle;
    }

    public static int getHighScore() {
        return highScore;
    }

    public static void setHighScore(int highScore) {
        Main.highScore = highScore;
    }
}