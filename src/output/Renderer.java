package output;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Klausmp
 */

public class Renderer {

    public static BufferedImage ship;
    public static BufferedImage playerShot;


    public Renderer() {
        try {
            //Player
            ship = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship.png"));

            //Bullet
            playerShot = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship_shot.png"));

            //Item

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

    public static BufferedImage getPlayerShot() {
        return playerShot;
    }

    public static void setPlayerShot(BufferedImage playerShot) {
        Renderer.playerShot = playerShot;
    }
}
