package output;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Klausmp
 */

public class Renderer {

    public static BufferedImage ship;

    public Renderer() {
        try {
            //Entity Texture
            ship = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/ship.png"));

            //Block Texture


            //Item Texture

            //Background and other

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
}
