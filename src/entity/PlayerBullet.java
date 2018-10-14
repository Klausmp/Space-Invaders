package entity;

import output.Renderer;
import util.Util;
import world.World;

public class PlayerBullet extends Bullet {

    public int animationTimer = 0;
    public final int ANIMATIONTIMER = 7;

    public PlayerBullet(int posX, int posY, double speed) {
        super(posX, posY, speed, true);
    }

    public PlayerBullet(int posX, int posY) {
        super(posX, posY, 7.5, true);
    }

    @Override
    public void loadAndSetTextures() {
        look = Renderer.getShipShot();
    }

    @Override
    public void movement() {
        if (isAlive()) {
            setPosY(getPosY() - speed);
        }
        if (getPosY_int() <= 20) {
            this.setAlive(false);
        }
    }

    @Override
    public void animation() {
        if (!isAlive()){
            look = Renderer.getShipShotDead();
            setAnimationTimer(getAnimationTimer() + 1);
        }
        if (getANIMATIONTIMER() <= getAnimationTimer()){
            setCanBeRemoved(true);
        }
    }

    @Override
    public void hit() {
        for (World world : Util.getWorldList()) {
            for (Alien alien : world.alienList) {
                if (bounding.intersects(alien.bounding) && !isCanBeRemoved()) {
                    alien.setAlive(false);
                    this.setCanBeRemoved(true);
                }
            }
            for (Bullet bullet : world.getBulletList()) {
                if (bounding.intersects(bullet.bounding) && bullet != this && isAlive() && bullet.isAlive) {
                    bullet.setAlive(false);
                    this.setAlive(false);
                }
            }


        }
    }

    public int getAnimationTimer() {
        return animationTimer;
    }

    public void setAnimationTimer(int animationTimer) {
        this.animationTimer = animationTimer;
    }

    public int getANIMATIONTIMER() {
        return ANIMATIONTIMER;
    }

    @Override
    public String toString() {
        return "PlayerBullet{" +
                "isPlayerBullet=" + isPlayerBullet +
                ", posX=" + posX +
                ", posY=" + posY +
                ", wight=" + wight +
                ", height=" + height +
                ", isAlive=" + isAlive +
                ", canBeRemoved=" + canBeRemoved +
                ", bounding=" + bounding +
                '}';
    }
}
