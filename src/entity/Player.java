package entity;

import input.Keyboard;
import output.Renderer;
import util.Util;
import world.World;

import java.awt.event.KeyEvent;

public class Player extends Entity {

    public Player(int posX, int posY, double speed) {
        super(posX, posY, speed);
    }

    public Player(int posX, int posY) {
        super(posX, posY, 2.5);
    }

    @Override
    public void update() {
        movement();
        shot();
    }

    @Override
    public void loadAndSetTextures() {
        look = Renderer.getShip();
    }

    @Override
    public void movement() {
        if (Keyboard.isKeyDown(KeyEvent.VK_LEFT) || Keyboard.isKeyDown(KeyEvent.VK_A)) {
            setPosX(getPosX() - getSpeed());

        }
        if (Keyboard.isKeyDown(KeyEvent.VK_RIGHT) || Keyboard.isKeyDown(KeyEvent.VK_D)) {
            setPosX(getPosX() + getSpeed());
        }
        setBounds();
    }

    @Override
    public void animation() {

    }

    public void shot() {
        if (canShoot()) {
            if (Keyboard.isKeyDown(KeyEvent.VK_SPACE) || Keyboard.isKeyDown(KeyEvent.VK_W) || Keyboard.isKeyDown(KeyEvent.VK_UP)) {
                for (World world : Util.getWorldList()) {
                    world.bulletList.add(new PlayerShot(getPosX_int() + (getWight() / 2 - 3), getPosY_int()));
                }
            }
        }
    }

    public boolean canShoot() {
        for (World world: Util.getWorldList()) {
            for (Bullet bullet: world.getBulletList()) {
                if (bullet.isPlayerBullet()){
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public String toString() {
        return "Player{" +
                ", posX=" + posX +
                ", posY=" + posY +
                ", speed=" + speed +
                ", wight=" + wight +
                ", height=" + height +
                ", isAlive=" + isAlive +
                ", bounding=" + bounding +
                '}';
    }
}
