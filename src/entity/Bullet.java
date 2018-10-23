package entity;

import util.Util;
import world.World;

/**
 * @author Klausmp
 */

public abstract class Bullet extends Entity {
    public boolean isPlayerBullet = false;

    public Bullet(int posX, int posY, boolean isPlayerBullet) {
        super(posX, posY, 6);
        setPlayerBullet(isPlayerBullet);
    }

    public Bullet(int posX, int posY, double speed, boolean isPlayerBullet) {
        super(posX, posY, speed);
        setPlayerBullet(isPlayerBullet);
    }

    public abstract void hit();

    @Override
    public void update() {
        movement();
        setBounds();
        animation();
        hit();
    }

    public void hitShield() {
        for (World world : Util.getWorldList()) {
            for (Shield shield : world.getShieldList()) {
                for (ShieldTile shieldTile : shield.getShieldTileList()) {
                    if (getBounding().intersects(shieldTile.getBounding()) && isAlive()) {
                        shieldTile.setCanBeRemoved(true);
                        setAlive(false);
                    }

                }
            }
        }
    }

    public boolean isPlayerBullet() {
        return isPlayerBullet;
    }

    public void setPlayerBullet(boolean playerBullet) {
        isPlayerBullet = playerBullet;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "isPlayerBullet=" + isPlayerBullet +
                ", posX=" + posX +
                ", posY=" + posY +
                ", speed=" + speed +
                ", wight=" + wight +
                ", height=" + height +
                ", isAlive=" + isAlive +
                ", canBeRemoved=" + canBeRemoved +
                ", look=" + look +
                ", bounding=" + bounding +
                '}';
    }
}
