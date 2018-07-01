package entity;

import input.Keyboard;
import output.Renderer;
import util.Util;
import world.World;

import java.awt.event.KeyEvent;

public class Player extends Entity {
    public int deadAnimationTimer = 0;
    public final int DEADANIMATIONTIMER = 20;
    public int animationTimer = 5;
    public final int ANIMATIONTIMER = 5;
    public boolean animationStatus = true;

    public Player(int posX, int posY, double speed) {
        super(posX, posY, speed);
    }

    public Player(int posX, int posY) {
        super(posX, posY, 2.5);
    }

    @Override
    public void update() {
        movement();
        animation();
        shot();
    }

    @Override
    public void loadAndSetTextures() {
        look = Renderer.getShip();
    }

    @Override
    public void movement() {
        if (isAlive()) {
            if (Keyboard.isKeyDown(KeyEvent.VK_LEFT) || Keyboard.isKeyDown(KeyEvent.VK_A)) {
                setPosX(getPosX() - getSpeed());

            }
            if (Keyboard.isKeyDown(KeyEvent.VK_RIGHT) || Keyboard.isKeyDown(KeyEvent.VK_D)) {
                setPosX(getPosX() + getSpeed());
            }
            setBounds();
        }
    }

    @Override
    public void animation() {
        if (!isAlive()) {
            if (getANIMATIONTIMER() <= getAnimationTimer()){
                setAnimationTimer(0);
                if (isAnimationStatus()){
                    setLook(Renderer.getShipDead0());
                    setAnimationStatus(false);
                }else {
                    setLook(Renderer.getShipDead1());
                    setAnimationStatus(true);
                }
            }
            setDeadAnimationTimer(getDeadAnimationTimer() + 1);
        }
        setAnimationTimer(getAnimationTimer() + 1);
        if (getDEADANIMATIONTIMER() <= getDeadAnimationTimer()) {
            for (World world: Util.getWorldList()) {
                world.setLives(world.getLives() - 1);
            }
            setCanBeRemoved(true);
        }
    }

    public void shot() {
        if (canShoot()) {
            if (Keyboard.isKeyDown(KeyEvent.VK_SPACE) || Keyboard.isKeyDown(KeyEvent.VK_W) || Keyboard.isKeyDown(KeyEvent.VK_UP)) {
                for (World world : Util.getWorldList()) {
                    world.bulletList.add(new PlayerBullet(getPosX_int() + (getWight() / 2 - 3), getPosY_int()));
                }
            }
        }
    }

    public boolean canShoot() {
        for (World world : Util.getWorldList()) {
            for (Bullet bullet : world.getBulletList()) {
                if (bullet.isPlayerBullet() && bullet.isAlive) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getDeadAnimationTimer() {
        return deadAnimationTimer;
    }

    public void setDeadAnimationTimer(int deadAnimationTimer) {
        this.deadAnimationTimer = deadAnimationTimer;
    }

    public int getDEADANIMATIONTIMER() {
        return DEADANIMATIONTIMER;
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

    public boolean isAnimationStatus() {
        return animationStatus;
    }

    public void setAnimationStatus(boolean animationStatus) {
        this.animationStatus = animationStatus;
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
