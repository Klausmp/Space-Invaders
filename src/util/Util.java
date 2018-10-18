package util;

import entity.*;
import output.Renderer;
import world.World;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Klausmp
 */

public class Util {
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public static List<World> worldList = new ArrayList<World>();
    public static List<World> deadWorldList = new ArrayList<World>();

    public static void drawBackground(Graphics g, Color color) {
        g.setColor(color);
        g.drawRect(0, 0, Renderer.getWindowSizeX(), Renderer.getWindowSizeY());

        for (int i = 0; i <= Renderer.getWindowSizeX(); i++) {
            g.drawLine(i, 0, i, Renderer.getWindowSizeY());
        }

        for (int i = 0; i <= 500; i++) {
            g.drawLine(0, i, Renderer.getWindowSizeX(), i);
        }

    }

    public static void clearLists() {
        for (World world : Util.getWorldList()) {
            for (Player player : world.getPlayerList()) {
                if (player.isCanBeRemoved()) {
                    world.getDeadPlayerList().add(player);
                }
            }

            for (Alien alien : world.getAlienList()) {
                if (alien.isCanBeRemoved()) {
                    world.getDeadAlienList().add(alien);
                }
            }

            for (Bullet bullet : world.getBulletList()) {
                if (bullet.isCanBeRemoved()) {
                    world.getDeadBulletList().add(bullet);
                }
            }

            for (Shield shield : world.getShieldList()) {
                for (ShieldTile shieldTile : shield.getShieldTileList()) {
                    if (shieldTile.isCanBeRemoved()) {
                        shield.getDeadShieldTileList().add(shieldTile);
                    }
                }

                if (shield.canBeRemoved) {
                    world.getDeadShieldList().add(shield);
                }
            }

            if (!world.getDeadPlayerList().isEmpty()) {
                world.getPlayerList().removeAll(world.getDeadPlayerList());
                world.getDeadPlayerList().clear();
            }

            if (!world.getDeadAlienList().isEmpty()) {
                world.getAlienList().removeAll(world.getDeadAlienList());
                world.getDeadAlienList().clear();
            }

            if (!world.getDeadBulletList().isEmpty()) {
                world.getBulletList().removeAll(world.getDeadBulletList());
                world.getDeadBulletList().clear();
            }

            for (Shield shield : world.getShieldList()) {
                if (!shield.getDeadShieldTileList().isEmpty()) {
                    shield.getShieldTileList().removeAll(shield.getDeadShieldTileList());
                    shield.getDeadShieldTileList().clear();
                }
            }

            if (!world.getDeadShieldList().isEmpty()) {
                world.getShieldList().removeAll(world.getDeadShieldList());
                world.getDeadShieldList().clear();
            }

        }

        if (!getDeadWorldList().isEmpty()) {
            getWorldList().removeAll(getDeadWorldList());
            deadWorldList.clear();
        }
    }

    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(Dimension screenSize) {
        Util.screenSize = screenSize;
    }

    public static List<World> getWorldList() {
        return worldList;
    }

    public static void setWorldList(List<World> worldList) {
        Util.worldList = worldList;
    }

    public static List<World> getDeadWorldList() {
        return deadWorldList;
    }

    public static void setDeadWorldList(List<World> deadWorldList) {
        Util.deadWorldList = deadWorldList;
    }
}
