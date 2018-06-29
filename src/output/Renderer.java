package output;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Klausmp
 */

public class Renderer {

    public static BufferedImage red;

    public Renderer() {
        try {
            //Entity Texture
            red = ImageIO.read(Renderer.class.getClassLoader().getResourceAsStream("gfx/red.png"));

            //Block Texture


            //Item Texture

            //Background and other

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int makeToRenderPos(int pos) {
        return pos * 16;
    }

    public static BufferedImage getRed() {
        return red;
    }

    public static void setRed(BufferedImage red) {
        Renderer.red = red;
    }
}
