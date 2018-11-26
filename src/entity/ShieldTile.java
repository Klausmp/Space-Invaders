package entity;

import grafiks.Renderer;

/**
 * @author Klausmp
 */

public class ShieldTile extends Entity {
    public int shieldType;

    public ShieldTile(int posX, int posY, int wallType) {
        setPosX(posX);
        setPosY(posY);
        setShieldType(wallType);
        setStartTexture();
        setBounds();
    }

    @Override
    public void update() {

    }

    @Override
    public void setStartTexture() {
        switch (getShieldType()) {
            case 1:
                setLook(Renderer.getShield());
                break;
            case 2:
                setLook(Renderer.getShield_0_0());
                break;
            case 3:
                setLook(Renderer.getShield_0_3());
                break;
            case 4:
                setLook(Renderer.getShield_3_0());
                break;
            case 5:
                setLook(Renderer.getShield_3_3());
                break;
        }
    }

    @Override
    public void movement() {

    }

    @Override
    public void animation() {
        //todo finde heraus wie die partikel der zerstörten blöcke funktionieren
    }

    public int getShieldType() {
        return shieldType;
    }

    public void setShieldType(int shieldType) {
        this.shieldType = shieldType;
    }

    @Override
    public String toString() {
        return "ShieldTile{" +
                "shieldType=" + shieldType +
                ", posX=" + posX +
                ", posY=" + posY +
                ", speed=" + speed +
                ", wight=" + wight +
                ", height=" + height +
                ", isAlive=" + isAlive +
                ", canBeRemoved=" + canBeRemoved +
                ", look=" + look +
                ", bounding=" + bounding +
                '}';
    }
}