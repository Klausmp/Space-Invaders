package world;

import entity.Alien;
import entity.Shield;
import grafiks.Renderer;

/**
 * @author Klausmp
 */

public class WorldOne extends World {
    public WorldOne() {
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void entityFormation() {
        getAlienList().add(new Alien(10000, 1000, 1));
        getShieldList().add(new Shield(50, 320));
        getShieldList().add(new Shield(172, 320));
        getShieldList().add(new Shield(295, 320));
        for (int x = 50; x <= Renderer.getWindowSizeX() - 76; x += 26) {
            for (int y = 30; y <= 55; y += 26) {
                getAlienList().add(new Alien(x, y, 1));
            }
            for (int y = 57; y <= 108; y += 26) {
                getAlienList().add(new Alien(x, y, 2));
            }
            for (int y = 109; y <= 159; y += 26) {
                getAlienList().add(new Alien(x, y, 3));
            }
        }
    }

    @Override
    public void resetAlien() {
        setRunX(0);
        setRUNX(92);
        setRunLeft(true);
        setFirstRunn(true);
        entityFormation();
    }

    @Override
    public String toString() {
        return "WorldOne{" +
                "runX=" + runX +
                ", RUNX=" + RUNX +
                ", lives=" + lives +
                ", score=" + score +
                ", runLeft=" + runLeft +
                ", firstRunn=" + firstRunn +
                ", isGameRunning=" + isGameRunning +
                ", isRendert=" + isRendert +
                ", bulletList=" + bulletList +
                ", deadBulletList=" + deadBulletList +
                ", alienList=" + alienList +
                ", deadAlienList=" + deadAlienList +
                ", playerList=" + playerList +
                ", deadPlayerList=" + deadPlayerList +
                ", shieldList=" + shieldList +
                ", deadShieldList=" + deadShieldList +
                '}';
    }
}
