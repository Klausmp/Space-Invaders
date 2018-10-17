package entity;

import output.Renderer;

public class ShieldTile extends Entity {
    public int wallType;

    public ShieldTile(int posX, int posY, int wallType) {
        setPosX(posX);
        setPosY(posY);
        setWallType(wallType);
        loadAndSetTextures();
        setBounds();
    }

    @Override
    public void update() {

    }

    @Override
    public void loadAndSetTextures() {
        switch (getWallType()) {
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
        //noting 2 do here
    }


    @Override
    public void animation() {
        //todo finde heraus wie die partikel der zerstörten blöcke funktionieren
    }

    public int getWallType() {
        return wallType;
    }

    public void setWallType(int wallType) {
        this.wallType = wallType;
    }
}