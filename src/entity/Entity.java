package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    public double posX;
    public double posY;
    public double speed;
    public int wight;
    public int height;

    public boolean isAlive = true;
    public boolean canBeRemoved = false;

    public BufferedImage look;

    public Rectangle bounding = new Rectangle();


    public Entity(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        loadAndSetTextures();
        setBounds();
    }

    public Entity(int posX, int posY, double speed) {
        this.posX = posX;
        this.posY = posY;
        this.speed = speed;
        loadAndSetTextures();
        setBounds();
    }

    public abstract void update();

    public abstract void loadAndSetTextures();

    public abstract void movement();

    public abstract void animation();

    public void render(Graphics g) {
        g.drawImage(getLook(), getPosX_int(), getPosY_int(), getWight(), getHeight(), null);
    }

    public void setBounds() {
        setWight(getLook().getWidth());
        setHeight(getLook().getHeight());
        getBounding().setBounds(getPosX_int(), getPosY_int(), getWight(), getHeight());
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public BufferedImage getLook() {
        return look;
    }

    public void setLook(BufferedImage look) {
        this.look = look;
    }

    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getBounding() {
        return bounding;
    }

    public void setBounding(Rectangle bounding) {
        this.bounding = bounding;
    }

    public double getPosX() {
        return posX;
    }

    public int getPosX_int(){
        return (int) posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public int getPosY_int(){
        return (int) posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isCanBeRemoved() {
        return canBeRemoved;
    }

    public void setCanBeRemoved(boolean canBeRemoved) {
        this.canBeRemoved = canBeRemoved;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "posX=" + posX +
                ", posY=" + posY +
                ", speed=" + speed +
                ", wight=" + wight +
                ", height=" + height +
                ", isAlive=" + isAlive +
                ", look=" + look +
                ", bounding=" + bounding +
                '}';
    }
}
