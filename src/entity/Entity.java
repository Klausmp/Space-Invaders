package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    // X und Y Koordinaten der Entity (Position im Raum)
    public double posX;
    public double posY;
    //Geschwindigkeit der Entity bei Bewegungen
    public double speed;
    //Höhe und Breite der Entity (wird von der Größe der Textur übernommen, gillt auch für Bounding)
    public int wight;
    public int height;

    //Sagt aus ob die Entity lebendig ist oder nicht
    public boolean isAlive = true;
    //Sagt aus ob die Entity gelöscht werden kann oder nicht
    public boolean canBeRemoved = false;

    //Textur die auf den Screeen angezeigt wird
    public BufferedImage look;

    //Hitbox der Entity
    public Rectangle bounding = new Rectangle();

    public Entity() {
    }

    public Entity(int posX, int posY, boolean loadAndSetTextures, boolean setBounds) {
        setPosX(posX);
        setPosY(posY);
        if (loadAndSetTextures) setStartTexture();
        if (setBounds) setBounds();
    }

    public Entity(int posX, int posY, double speed) {
        setPosX(posX);
        setPosY(posY);
        setSpeed(speed);
        setStartTexture();
        setBounds();
    }

    /**
     * Updatet die Entity bei jedem Tick
     * (Muss in World.update() in der Liste,
     * der jewaligen Entity aufgerufen werden)
     */
    public abstract void update();

    /**
     * Legt die erste Textur fest muss (muss in update() aufgerufen werden)
     */
    public abstract void setStartTexture();

    /**
     * Setzt das Movemnet der Entity fest (muss in update() aufgerufen werden)
     */
    public abstract void movement();

    /**
     *Steuert die Animation der Entity. Muss mit einme Timer fersehen werdern,
     * um die richtige Zeit für den wechsel der Texturen zu erkennen
     * (muss in update() auferufen werden)
     */
    public abstract void animation();

    /**
     *Lässt Entity.look auf dem Screen an den x und y Koordinaten darstellen
     * (Muss in World.render() in der Liste,
     *der jewaligen Entity aufgerufen werden)
     */
    public void render(Graphics g) {
        g.drawImage(getLook(), getPosX_int(), getPosY_int(), getWight(), getHeight(), null);
    }

    /**
     *Setzt die Hitbox auf den Aktuellen standort der Entity
     * (muss in update() aufgerufen werden)
     */
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

    public int getPosX_int() {
        return (int) posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public int getPosY_int() {
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
