package main;

/**
 * @author Klausmp
 */
//TODO add game over screen
//TODO Dokumentation für AlienBullet
//TODO Dokumentation für Item
//TODO Dokumentation für PlayerBullet
//TODO Dokumentation für Shield
//TODO Dokumentation für ShieldTile
//TODO Dokumentation für GameLoop
//TODO Dokumentation für Main
//TODO Dokumentation für Renderer
//TODO Dokumentation für Util
//TODO Dokumentation für World
//TODO Dokumentation für World One

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

    public static GameLoop getGameLoop() {
        return gameLoop;
    }

    public static void setGameLoop(GameLoop gameLoop) {
        Main.gameLoop = gameLoop;
    }


}