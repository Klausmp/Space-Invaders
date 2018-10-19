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
    //Erkennung der Displayauflösung
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //Liste in der die Welt gespeichert wird
    public static List<World> worldList = new ArrayList<World>();
    //Liste zur entfernung von Elementen aus der nicht "dead" Liste
    public static List<World> deadWorldList = new ArrayList<World>();

    //Screen Layer für den Hintergrund (hinterste Ebene)
    public static void drawBackground(Graphics g, Color color) {
        //Setung der Farbe für den Hintergrunf
        g.setColor(color);
        //Zeichnung eines Rechhteckes am Rand des Fensters
        g.drawRect(0, 0, Renderer.getWindowSizeX(), Renderer.getWindowSizeY());
        //Zeichnet so viele Lienien vom oberene bis zum unteren ende des Bildes (in der Größe des Fensters)
        for (int i = 0; i <= Renderer.getWindowSizeX(); i++) {
            g.drawLine(i, 0, i, Renderer.getWindowSizeY());
        }
    }

    //Entfernung aller Listenelemente und somit Löschung aller Entitys
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
