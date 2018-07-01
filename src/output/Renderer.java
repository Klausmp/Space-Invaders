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


    public Renderer() {
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
            ship1 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship.png"));

            //Bullet
            shipShot = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship_shot.png"));
            shipShotDead = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship_shot_destroyed.png"));
            alienBullet0 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/alien_shot_0.png"));
            alienBullet1 = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/alien_shot_1.png"));
            alienBulledDead = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/alien_shot_destroyed.png"));

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
}
