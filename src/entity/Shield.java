package entity;

public class Shield extends Entity {
    public int wallType;

    public Shield(int posX, int posY, int wallType) {
        super(posX, posY);
        setWallType(wallType);
    }

    @Override
    public void update() {

    }

    @Override
    public void loadAndSetTextures() {

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