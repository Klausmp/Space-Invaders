package entity;

import output.Renderer;
import util.Util;
import world.World;

public class Alien extends Entity {
    public final int SHOTDELAY = 10;
    public int shotDelay = 0;
    public Alien(int posX, int posY) {
        super(posX, posY, 0.5);
    }

    @Override
    public void update() {
        movement();
        setBounds();
        shoot();
    }

    public void shoot(){
        if ((int) (Math.random() * 149 + 1) == 50 && getSHOTDELAY() <= getShotDelay()){
            setShotDelay(0);
            for (World world: Util.getWorldList()) {
                world.getBulletList().add(new AlienBullet(getPosX_int() + (getWight() / 2), getPosY_int() - getHeight(), false));
            }
        }
        if (getSHOTDELAY() == getShotDelay()){
            setShotDelay(0);
        }
        setShotDelay(getShotDelay() + 1);
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

    public int getSHOTDELAY() {
        return SHOTDELAY;
    }

    public int getShotDelay() {
        return shotDelay;
    }

    public void setShotDelay(int shotDelay) {
        this.shotDelay = shotDelay;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "SHOTDELAY=" + SHOTDELAY +
                ", shotDelay=" + shotDelay +
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
