package output;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Klausmp
 */

public class Renderer {

    public static BufferedImage ship1;
    public static BufferedImage shipShot;
    public static BufferedImage shipShotDead;
    public static BufferedImage alien2_0;


    public Renderer() {
        try {
            //Alien
            alien2_0 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/alien2_0.png"));

            //Player
            ship1 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship.png"));

            //Bullet
            shipShot = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship_shot.png"));
            shipShotDead = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship_shot_destroyed.png"));


            //Item

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static BufferedImage getShip1() {
        return ship1;
    }

    public static void setShip1(BufferedImage ship1) {
        Renderer.ship1 = ship1;
    }

    public static BufferedImage getPlayerShot() {
        return shipShot;
    }

    public static void setPlayerShot(BufferedImage playerShot) {
        Renderer.shipShot = playerShot;
    }

    public static BufferedImage getAlien2_0() {
        return alien2_0;
    }

    public static void setAlien2_0(BufferedImage alien2_0) {
        Renderer.alien2_0 = alien2_0;
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
}
