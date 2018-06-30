package entity;

import output.Renderer;
import util.Util;
import world.World;

public class Alien extends Entity {
    public Alien(int posX, int posY) {
        super(posX, posY, 0.5);
    }

    @Override
    public void update() {
        movement();
        setBounds();
    }

    @Override
    public void loadAndSetTextures() {
        look = Renderer.getAlien2_0();
    }

    @Override
    public void movement() {
        for (World world : Util.getWorldList()) {
            if (world.isRunLeft()) {
                setPosX(getPosX() - getSpeed());
            } else {
                setPosX(getPosX() + getSpeed());
            }
        }
    }

    @Override
    public void animation() {

    }
}
