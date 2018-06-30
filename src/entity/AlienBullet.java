package entity;

import output.GameFrame;
import output.Renderer;

public class AlienBullet extends Bullet {

    public AlienBullet(int posX, int posY, boolean isPlayerBullet) {
        super(posX, posY, 5, isPlayerBullet);
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
        setPosY(getPosY() + speed);
        if (getPosY_int() <= GameFrame.getWindowSizeY()){
            this.setAlive(false);
        }
    }

    @Override
    public void animation() {

    }
}
