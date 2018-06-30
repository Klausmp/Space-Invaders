package output;

import entity.Player;
import input.Keyboard;
import input.Mouse;
import main.GameLoop;
import util.Util;
import world.World;

import javax.swing.*;
import java.awt.*;

/**
 * @author Klausmp
 */

public class GameFrame extends JFrame {
    public static int windowSizeX;
    public static int windowSizeY;

    public static JFrame gameFrame = new JFrame();

    public static JPanel gamePanel = new JPanel();

    public static Screen screen = new Screen();

    public GameFrame() {
        /*Pannels*/

        //GamePannel
        getGamePanel().setLayout(new BorderLayout());
        getGamePanel().add(getScreen(), BorderLayout.CENTER);

        /*Configurations*/

        //Windowsize ETC
        resizeWindow(500, 500);

        //Screen
        getScreen().setVisible(true);

        //GameFrame
        getGameFrame().setUndecorated(false);
        getGameFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getGameFrame().setLocationRelativeTo(null);
        getGameFrame().setResizable(false);
        getGameFrame().setLayout(new BorderLayout());
        getGameFrame().add(getGamePanel(), BorderLayout.CENTER);
        getGameFrame().addKeyListener(new Keyboard());
        getGameFrame().addMouseListener(new Mouse());
        getGameFrame().setVisible(true);


        /*Buttons*/
    }

    static class Screen extends JLabel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            GameFrame.background(g);
            GameFrame.gameLayer(g);
            GameFrame.guiLayer(g);
        }
    }

    private static void background(Graphics g) {
        Util.drawBackground(g, Color.BLACK);
        g.setColor(Color.GREEN);
        g.drawLine(0, 416, getWindowSizeX(), 416);
        g.drawLine(0, 417, getWindowSizeX(), 417);
        g.drawLine(0, 418, getWindowSizeX(), 418);
        g.drawLine(0, 419, getWindowSizeX(), 419);
        g.drawLine(0, 420, getWindowSizeX(), 420);

    }

    public static void guiLayer(Graphics g) {
        g.setPaintMode();
    }

    public static void gameLayer(Graphics g) {
        for (World world: Util.getWorldList()) {
            world.render(g);
        }
    }

    public static void resizeWindow(int wight, int height) {
        if (Util.getScreenSize().getWidth() == 1360 && Util.getScreenSize().getHeight() == 768) {
            wight = (wight + 2) - 10;
            height = (height + 2) + 12;
        }
        if (Util.getScreenSize().getWidth() == 1920 && Util.getScreenSize().getHeight() == 1080) {
            wight = (wight + 2);
            height = (height + 2) + 23;
        }
        if (Util.getScreenSize().getWidth() == 1280 && Util.getScreenSize().getHeight() == 720) {
            wight = (wight + 2);
            height = (height + 2) + 23;
        }
        getScreen().setBounds(0, 0, wight, height);
        getGameFrame().setSize(wight, height);
        setWindowSizeX(wight);
        setWindowSizeY(height);
    }

    public static void repaintScreen() {
        screen.repaint(0, 0, windowSizeX, windowSizeY);
    }

    public static int getWindowSizeX() {
        return windowSizeX;
    }

    public static void setWindowSizeX(int windowSizeX) {
        GameFrame.windowSizeX = windowSizeX;
    }

    public static int getWindowSizeY() {
        return windowSizeY;
    }

    public static void setWindowSizeY(int windowSizeY) {
        GameFrame.windowSizeY = windowSizeY;
    }

    public static JFrame getGameFrame() {
        return gameFrame;
    }

    public static void setGameFrame(JFrame gameFrame) {
        GameFrame.gameFrame = gameFrame;
    }

    public static JPanel getGamePanel() {
        return gamePanel;
    }

    public static void setGamePanel(JPanel gamePanel) {
        GameFrame.gamePanel = gamePanel;
    }

    public static Screen getScreen() {
        return screen;
    }

    public static void setScreen(Screen screen) {
        GameFrame.screen = screen;
    }
}