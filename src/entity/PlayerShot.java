package entity;

import output.Renderer;
import util.Util;
import world.World;

public class PlayerShot extends Bullet {

    public PlayerShot(int posX, int posY, double speed) {
        super(posX, posY, speed, true);
    }

    public PlayerShot(int posX, int posY) {
        super(posX, posY, 7.5, true);
    }

    @Override
    public void loadAndSetTextures() {
        look = Renderer.getPlayerShot();
    }

    @Override
    public void movement() {
        setPosY(getPosY() - speed);
        if (getPosY_int() <= 0){
            this.setAlive(false);
        }
    }

    @Override
    public void animation() {

    }

    @Override
    public void hit() {
        for (World world: Util.getWorldList()) {
            for (Alien alien: world.alienList) {
                if (bounding.intersects(alien.bounding)){
                    alien.setAlive(false);
                    this.setAlive(false);
                }
            }
            for (Bullet bullet: world.getBulletList()) {
                if (bounding.intersects(bullet.bounding) && bullet != this){
                    bullet.setAlive(false);
                    this.setAlive(false);
                }
            }


        }
    }

    @Override
    public String toString() {
        return "PlayerShot{" +
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
