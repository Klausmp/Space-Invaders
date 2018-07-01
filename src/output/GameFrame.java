package output;

import input.Keyboard;
import input.Mouse;
import main.Main;
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
        resizeWindow(400, 400);

        //Screen
        getScreen().setVisible(true);

        //GameFrame
        getGameFrame().setTitle(Main.gameTitle);
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
        g.drawLine(0, 369, getWindowSizeX(), 369);
        g.drawLine(0, 370, getWindowSizeX(), 370);

    }

    public static void guiLayer(Graphics g) {
        if (Util.getWorldList().isEmpty()) {
            g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 17));
            g.drawString("Press Enter to Start", 121, 300);
        }
        for (World world : Util.getWorldList()) {
            if (world.getPlayerList().isEmpty()) {
                g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 17));
                g.drawString("Press Enter to Continue", 106, 300);
            }
        }
        g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 9));
        g.drawString("L I V E S :", 0, getWindowSizeY() - 43);
        for (World world : Util.getWorldList()) {
            switch (world.getLives()) {
                case 3:
                    g.drawImage(Renderer.getShipLives(), 50, getWindowSizeY() - 50, null);
                    g.drawImage(Renderer.getShipLives(), 65, getWindowSizeY() - 50, null);
                    g.drawImage(Renderer.getShipLives(), 80, getWindowSizeY() - 50, null);
                    break;
                case 2:
                    g.drawImage(Renderer.getShipLives(), 50, getWindowSizeY() - 50, null);
                    g.drawImage(Renderer.getShipLives(), 65, getWindowSizeY() - 50, null);
                    break;
                case 1:
                    g.drawImage(Renderer.getShipLives(), 50, getWindowSizeY() - 50, null);
                    break;
                default:
                    break;
            }
        }
    }

    public static void gameLayer(Graphics g) {
        for (World world : Util.getWorldList()) {
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