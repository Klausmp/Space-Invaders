package entity;

import input.Keyboard;
import output.Renderer;

import java.awt.event.KeyEvent;

public class Player extends Entity {


    public Player(int posX, int posY, double speed) {
        super(posX, posY, speed);
    }

    @Override
    public void update() {
        movement();
    }

    @Override
    public void loadAndSetTextures() {
        look = Renderer.getShip();
    }

    public void movement() {
        if (Keyboard.isKeyDown(KeyEvent.VK_LEFT) || Keyboard.isKeyDown(KeyEvent.VK_A)) {
            setPosX(getPosX() - getSpeed());

        }
        if (Keyboard.isKeyDown(KeyEvent.VK_RIGHT) || Keyboard.isKeyDown(KeyEvent.VK_D)) {
            setPosX(getPosX() + getSpeed());
        }

    }
}
