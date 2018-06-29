package output;

import util.Util;

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
        resizeWindow(14, 14);

        //Screen
        getScreen().setVisible(true);

        //GameFrame
        getGameFrame().setUndecorated(false);
        getGameFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getGameFrame().setLocationRelativeTo(null);
        getGameFrame().setResizable(false);
        getGameFrame().setLayout(new BorderLayout());
        getGameFrame().add(getGamePanel(), BorderLayout.CENTER);
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

    }

    public static void guiLayer(Graphics g) {
        g.setPaintMode();
    }

    public static void gameLayer(Graphics g) {
        g.drawImage(Renderer.getRed(), 10, 10, null);
    }

    public static void resizeWindow(int wight, int height) {
        if (Util.getScreenSize().getWidth() == 1360 && Util.getScreenSize().getHeight() == 768) {
            wight = (wight + 2) * 16 - 10;
            height = (height + 2) * 16 + 12;
        }
        if (Util.getScreenSize().getWidth() == 1920 && Util.getScreenSize().getHeight() == 1080) {
            wight = (wight + 2) * 16;
            height = (height + 2) * 16 + 23;
        }
        if (Util.getScreenSize().getWidth() == 1280 && Util.getScreenSize().getHeight() == 720) {
            wight = (wight + 2) * 16;
            height = (height + 2) * 16 + 23;
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