package main;

import entity.Player;
import input.Keyboard;
import output.GameFrame;
import output.Renderer;
import util.Util;
import world.World;
import world.WorldOne;

import java.awt.event.KeyEvent;

/**
 * @author Klausmp
 */

public class GameLoop {

    public static Renderer renderer = new Renderer();

    private static boolean gameRunning = true;

    private static double fpsTimer;
    private static double nsPerTick;
    private static double nsPerRenderTick;
    private static double then;
    private static double now;
    private static double unprocessed;
    private static double unprocessedRender;

    private static int fps = 0;
    private static int tps = 0;
    private static int currentTick = 0;

    private static final int TPS = 60;
    private static final int FPS = 60;

    void run() {
        gameLoop();
    }

    static void init() {
        GameFrame frame = new GameFrame();
        Keyboard keyboard = new Keyboard();
    }

    private void gameLoop() {
        fps = 0;
        tps = 0;
        fpsTimer = System.currentTimeMillis();
        nsPerTick = 1D / TPS * 1000000000D;
        nsPerRenderTick = 1D / FPS * 1000000000D;
        then = System.nanoTime();
        while (true) {
            now = System.nanoTime();
            unprocessed += (now - then) / nsPerTick;
            unprocessedRender += (now - then) / nsPerRenderTick;
            then = now;

            while (getUnprocessed() >= 1) {
                if (isGameRunning()) {
                    gameTick();
                    gameTicks();
                }
                guiTick();
                setTps(getTps() + 1);
                setUnprocessed(getUnprocessed() - 1);
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gameRender();
            while (getUnprocessedRender() >= 1) {
                gameRender();
                setFps(getFps() + 1);
                setUnprocessedRender(getUnprocessedRender() - 1);
            }


            if (System.currentTimeMillis() - getFpsTimer() >= 1000) {
                System.out.println("FPS: " + getFps());
                setFps(0);
                setTps(0);
                setFpsTimer(getFpsTimer() + 1000);
            }
        }
    }

    private void gameRender() {
        GameFrame.repaintScreen();
    }

    private void guiTick() {
    }

    private void gameTick() {
        Util.clearLists();
        for (World world : Util.getWorldList()) {
            world.update();
        }
        if (Util.getWorldList().isEmpty() && Keyboard.isKeyDown(KeyEvent.VK_ENTER)){

            Util.getWorldList().add(new WorldOne());
        }
    }

    public void gameTicks() {
        setCurrentTick(getCurrentTick() + 1);
        if (getCurrentTick() >= getTPS() + 1) {
            setCurrentTick(1);
        }
    }


    public static int getCurrentTick() {
        return currentTick;
    }

    public static void setCurrentTick(int currentTick) {
        GameLoop.currentTick = currentTick;
    }

    public static boolean isGameRunning() {
        return gameRunning;
    }

    public static void setGameRunning(boolean gameRunning) {
        GameLoop.gameRunning = gameRunning;
    }

    public static double getFpsTimer() {
        return fpsTimer;
    }

    public static void setFpsTimer(double fpsTimer) {
        GameLoop.fpsTimer = fpsTimer;
    }

    public static double getNsPerTick() {
        return nsPerTick;
    }

    public static void setNsPerTick(double nsPerTick) {
        GameLoop.nsPerTick = nsPerTick;
    }

    public static double getNsPerRenderTick() {
        return nsPerRenderTick;
    }

    public static void setNsPerRenderTick(double nsPerRenderTick) {
        GameLoop.nsPerRenderTick = nsPerRenderTick;
    }

    public static double getThen() {
        return then;
    }

    public static void setThen(double then) {
        GameLoop.then = then;
    }

    public static double getNow() {
        return now;
    }

    public static void setNow(double now) {
        GameLoop.now = now;
    }

    public static double getUnprocessed() {
        return unprocessed;
    }

    public static void setUnprocessed(double unprocessed) {
        GameLoop.unprocessed = unprocessed;
    }

    public static double getUnprocessedRender() {
        return unprocessedRender;
    }

    public static void setUnprocessedRender(double unprocessedRender) {
        GameLoop.unprocessedRender = unprocessedRender;
    }

    public static int getFps() {
        return fps;
    }

    public static void setFps(int fps) {
        GameLoop.fps = fps;
    }

    public static int getTps() {
        return tps;
    }

    public static void setTps(int tps) {
        GameLoop.tps = tps;
    }

    public static int getTPS() {
        return TPS;
    }

    public static int getFPS() {
        return FPS;
    }

}