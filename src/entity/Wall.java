package entity;

public class Wall extends Entity {
    public int wallType;

    public Wall(int posX, int posY, int wallType) {
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

    }

    @Override
    public void animation() {

    }

    public int getWallType() {
        return wallType;
    }

    public void setWallType(int wallType) {
        this.wallType = wallType;
    }
}