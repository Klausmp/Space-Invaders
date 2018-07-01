package entity;

import output.GameFrame;
import output.Renderer;

public class AlienBullet extends Bullet {
    public int deadAnimationTimer = 0;
    public final int DEADANIMATIONTIMER = 7;
    public int animationTimer = 0;
    public final int ANIMATIONTIMER = 6;
    public boolean animationLeft = true;

    public AlienBullet(int posX, int posY) {
        super(posX, posY, 4, false);
    }

    @Override
    public void hit() {

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
            if (isAnimationLeft()) {
                look = Renderer.getAlienBullet0();
                setAnimationLeft(false);
                setAnimationTimer(0);
            } else {
                look = Renderer.getAlienBullet1();
                setAnimationLeft(true);
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

    public boolean isAnimationLeft() {
        return animationLeft;
    }

    public void setAnimationLeft(boolean animationLeft) {
        this.animationLeft = animationLeft;
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
