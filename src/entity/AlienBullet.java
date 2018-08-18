package entity;

import output.GameFrame;
import output.Renderer;
import util.Util;
import world.World;

public class AlienBullet extends Bullet {
    public int deadAnimationTimer = 0;
    public final int DEADANIMATIONTIMER = 7;
    public int animationTimer = 0;
    public final int ANIMATIONTIMER = 6;
    public boolean animationStatus = true;

    public AlienBullet(int posX, int posY) {
        super(posX, posY, 5, false);
    }

    @Override
    public void hit() {
        for (World world: Util.getWorldList()) {
            for (Player player: world.getPlayerList()) {
                if (getBounding().intersects(player.getBounding())){
                    this.setCanBeRemoved(true);
                    player.setAlive(false);

                }
            }
        }
    }

    @Override
    public void loadAndSetTextures() {
        look = Renderer.getAlienBullet0();
    }

    @Override
    public void movement() {
        if (isAlive()) {
            setPosY(getPosY() + speed);
        }
        if (getPosY_int() >= GameFrame.getWindowSizeY()) {
            this.setAlive(false);
        }
    }

    @Override
    public void animation() {
        setAnimationTimer(getAnimationTimer() + 1);
        if (getANIMATIONTIMER() == getAnimationTimer()) {
            if (isAnimationStatus()) {
                look = Renderer.getAlienBullet0();
                setAnimationStatus(false);
                setAnimationTimer(0);
            } else {
                look = Renderer.getAlienBullet1();
                setAnimationStatus(true);
                setAnimationTimer(0);
            }
        }
        if (!isAlive()) {
            look = Renderer.getAlienBulledDead();
            setDeadAnimationTimer(getDeadAnimationTimer() + 1);
        }
        if (getDEADANIMATIONTIMER() <= getDeadAnimationTimer()) {
            setCanBeRemoved(true);
        }
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
        return "AlienBullet{" +
                "deadAnimationTimer=" + deadAnimationTimer +
                ", DEADANIMATIONTIMER=" + DEADANIMATIONTIMER +
                ", isPlayerBullet=" + isPlayerBullet +
                ", posX=" + posX +
                ", posY=" + posY +
                ", speed=" + speed +
                ", wight=" + wight +
                ", height=" + height +
                ", isAlive=" + isAlive +
                ", canBeRemoved=" + canBeRemoved +
                ", bounding=" + bounding +
                '}';
    }
}
