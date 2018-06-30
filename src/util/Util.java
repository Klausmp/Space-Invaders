package util;

import output.GameFrame;

import java.awt.*;

/**
 * @author Klausmp
 */

public class Util {
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


    public static void drawBackground(Graphics g, Color color){
        g.setColor(color);
        g.drawRect(0, 0, GameFrame.getWindowSizeX(), GameFrame.getWindowSizeY());

        for (int i = 0; i <= GameFrame.getWindowSizeX(); i++) {
            g.drawLine(i, 0, i, GameFrame.getWindowSizeY());
        }
        for (int i = 0; i <= 500; i++) {
            g.drawLine(0, i, GameFrame.getWindowSizeX(), i);
        }

    }


    /**public static void clearLists() {
        for (World world : World.getWorldList()) {
            for (Snake snake : World.getSnakeList()) {
                if (!snake.isAlive) {
                    World.getDeadSnakeList().add(snake);
                }
            }
            for (Food food : World.getFoodList()) {
                if (!food.isAlive()) {
                    World.getDeadFoodList().add(food);
                }
            }
        }
        if (!World.getDeadWallList().isEmpty()){
            World.getWallList().removeAll(World.getDeadWallList());
            World.getDeadWallList().clear();
        }
        if (!World.getDeadFoodList().isEmpty()) {
            World.getFoodList().removeAll(World.getDeadFoodList());
            World.getDeadFoodList().clear();
        }
        if (!World.getDeadSnakeList().isEmpty()) {
            World.getSnakeList().removeAll(World.getDeadSnakeList());
            World.getDeadSnakeList().clear();
        }
        if (!World.getDeadWorldList().isEmpty()) {
            World.getWorldList().removeAll(World.getWorldList());
            World.getDeadWorldList().clear();
        }
    }*/

    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(Dimension screenSize) {
        Util.screenSize = screenSize;
    }
}
