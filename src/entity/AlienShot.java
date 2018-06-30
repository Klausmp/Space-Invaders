package entity;

import output.GameFrame;

public class AlienShot extends Bullet {

    public AlienShot(int posX, int posY, boolean isPlayerBullet) {
        super(posX, posY, 5, isPlayerBullet);
    }

    @Override
    public void hit() {

    }
    @Override
    public void loadAndSetTextures() {

    }

    @Override
    public void movement() {
        setPosY(getPosY() + speed);
        if (getPosY_int() <= GameFrame.getWindowSizeY()){
            this.setAlive(false);
        }
    }

    @Override
    public void animation() {

    }
}
