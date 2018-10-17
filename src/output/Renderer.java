package output;

import input.Keyboard;
import input.Mouse;
import main.Main;
import util.Util;
import world.World;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Klausmp
 */

public class Renderer extends JFrame {

    public static BufferedImage ship;
    public static BufferedImage shipDead0;
    public static BufferedImage shipDead1;
    public static BufferedImage shipLives;
    public static BufferedImage shipShot;
    public static BufferedImage shipShotDead;
    public static BufferedImage alienBullet0;
    public static BufferedImage alienBullet1;
    public static BufferedImage alienBulledDead;
    public static BufferedImage alien1_0;
    public static BufferedImage alien1_1;
    public static BufferedImage alien2_0;
    public static BufferedImage alien2_1;
    public static BufferedImage alien3_0;
    public static BufferedImage alien3_1;
    public static BufferedImage alienDestroyed;
    public static BufferedImage shield;
    public static BufferedImage shield_0_0;
    public static BufferedImage shield_0_3;
    public static BufferedImage shield_3_0;
    public static BufferedImage shield_3_3;

    //TODO add destroyed shield-textures

    public static int windowSizeX;
    public static int windowSizeY;

    public static JFrame gameFrame = new JFrame();

    public static JPanel gamePanel = new JPanel();

    public static Screen screen = new Screen();

    public Renderer() {
        loadTextures();
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

    public static void repaintScreen(){
        getScreen().repaint();
    }

    static class Screen extends JLabel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Renderer.background(g);

            Renderer.gameLayer(g);
            Renderer.guiLayer(g);
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
            if (!world.isGameRunning()) {
                g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 17));
                g.drawString("Press Enter to Continue", 106, 300);
            }
        }
        g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 9));
        for (World world : Util.getWorldList()) {
            g.drawString("L I V E S :", 0, getWindowSizeY() - 43);
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
                case 0:
                    break;
                default:
                    System.out.println("Wrong Live Count!!");
                    break;
            }
        }
        g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 15));
        g.drawString("SCORE: ", 25, 15);
        for (World world : Util.getWorldList()) {
            g.setFont(new Font(g.getFont().getName(), Font.PLAIN, 15));
            g.drawString("" + world.getScore(), 125, 15);
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

    public static void loadTextures() {
        try {
            //Alien
            alien1_0 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/alien1_0.png"));
            alien1_1 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/alien1_1.png"));
            alien2_0 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/alien2_0.png"));
            alien2_1 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/alien2_1.png"));
            alien3_0 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/alien3_0.png"));
            alien3_1 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/alien3_1.png"));
            alienDestroyed = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/alien_destroyed.png"));

            //Player
            ship = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship.png"));
            shipDead0 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship_destroyed_0.png"));
            shipDead1 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship_destroyed_1.png"));
            shipLives = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship_lives.png"));

            //Bullet
            shipShot = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship_shot.png"));
            shipShotDead = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship_shot_destroyed.png"));
            alienBullet0 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/alien_shot_0.png"));
            alienBullet1 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/alien_shot_1.png"));
            alienBulledDead = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/alien_shot_destroyed.png"));

            //Item

            //Shield
            shield = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/shield.png"));
            shield_0_0 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/shield_0_0.png"));
            shield_0_3 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/shield_0_3.png"));
            shield_3_0 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/shield_3_0.png"));
            shield_3_3 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/shield_3_3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getShip() {
        return ship;
    }

    public static void setShip(BufferedImage ship) {
        Renderer.ship = ship;
    }

    public static BufferedImage getShipDead0() {
        return shipDead0;
    }

    public static void setShipDead0(BufferedImage shipDead0) {
        Renderer.shipDead0 = shipDead0;
    }

    public static BufferedImage getShipDead1() {
        return shipDead1;
    }

    public static void setShipDead1(BufferedImage shipDead1) {
        Renderer.shipDead1 = shipDead1;
    }

    public static BufferedImage getShipLives() {
        return shipLives;
    }

    public static void setShipLives(BufferedImage shipLives) {
        Renderer.shipLives = shipLives;
    }

    public static BufferedImage getShipShot() {
        return shipShot;
    }

    public static void setShipShot(BufferedImage shipShot) {
        Renderer.shipShot = shipShot;
    }

    public static BufferedImage getShipShotDead() {
        return shipShotDead;
    }

    public static void setShipShotDead(BufferedImage shipShotDead) {
        Renderer.shipShotDead = shipShotDead;
    }

    public static BufferedImage getAlienBullet0() {
        return alienBullet0;
    }

    public static void setAlienBullet0(BufferedImage alienBullet0) {
        Renderer.alienBullet0 = alienBullet0;
    }

    public static BufferedImage getAlienBullet1() {
        return alienBullet1;
    }

    public static void setAlienBullet1(BufferedImage alienBullet1) {
        Renderer.alienBullet1 = alienBullet1;
    }

    public static BufferedImage getAlienBulledDead() {
        return alienBulledDead;
    }

    public static void setAlienBulledDead(BufferedImage alienBulledDead) {
        Renderer.alienBulledDead = alienBulledDead;
    }

    public static BufferedImage getAlien1_0() {
        return alien1_0;
    }

    public static void setAlien1_0(BufferedImage alien1_0) {
        Renderer.alien1_0 = alien1_0;
    }

    public static BufferedImage getAlien1_1() {
        return alien1_1;
    }

    public static void setAlien1_1(BufferedImage alien1_1) {
        Renderer.alien1_1 = alien1_1;
    }

    public static BufferedImage getAlien2_0() {
        return alien2_0;
    }

    public static void setAlien2_0(BufferedImage alien2_0) {
        Renderer.alien2_0 = alien2_0;
    }

    public static BufferedImage getAlien2_1() {
        return alien2_1;
    }

    public static void setAlien2_1(BufferedImage alien2_1) {
        Renderer.alien2_1 = alien2_1;
    }

    public static BufferedImage getAlien3_0() {
        return alien3_0;
    }

    public static void setAlien3_0(BufferedImage alien3_0) {
        Renderer.alien3_0 = alien3_0;
    }

    public static BufferedImage getAlien3_1() {
        return alien3_1;
    }

    public static void setAlien3_1(BufferedImage alien3_1) {
        Renderer.alien3_1 = alien3_1;
    }

    public static BufferedImage getAlienDestroyed() {
        return alienDestroyed;
    }

    public static void setAlienDestroyed(BufferedImage alienDestroyed) {
        Renderer.alienDestroyed = alienDestroyed;
    }

    public static BufferedImage getShield() {
        return shield;
    }

    public static void setShield(BufferedImage shield) {
        Renderer.shield = shield;
    }

    public static BufferedImage getShield_0_0() {
        return shield_0_0;
    }

    public static void setShield_0_0(BufferedImage shield_0_0) {
        Renderer.shield_0_0 = shield_0_0;
    }

    public static BufferedImage getShield_0_3() {
        return shield_0_3;
    }

    public static void setShield_0_3(BufferedImage shield_0_3) {
        Renderer.shield_0_3 = shield_0_3;
    }

    public static BufferedImage getShield_3_0() {
        return shield_3_0;
    }

    public static void setShield_3_0(BufferedImage shield_3_0) {
        Renderer.shield_3_0 = shield_3_0;
    }

    public static BufferedImage getShield_3_3() {
        return shield_3_3;
    }

    public static void setShield_3_3(BufferedImage shield_3_3) {
        Renderer.shield_3_3 = shield_3_3;
    }

    public static int getWindowSizeX() {
        return windowSizeX;
    }

    public static void setWindowSizeX(int windowSizeX) {
        Renderer.windowSizeX = windowSizeX;
    }

    public static int getWindowSizeY() {
        return windowSizeY;
    }

    public static void setWindowSizeY(int windowSizeY) {
        Renderer.windowSizeY = windowSizeY;
    }

    public static JFrame getGameFrame() {
        return gameFrame;
    }

    public static void setGameFrame(JFrame gameFrame) {
        Renderer.gameFrame = gameFrame;
    }

    public static JPanel getGamePanel() {
        return gamePanel;
    }

    public static void setGamePanel(JPanel gamePanel) {
        Renderer.gamePanel = gamePanel;
    }

    public static Screen getScreen() {
        return screen;
    }

    public static void setScreen(Screen screen) {
        Renderer.screen = screen;
    }
}