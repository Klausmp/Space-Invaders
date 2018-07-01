package entity;

public abstract class Bullet extends Entity{
    public boolean isPlayerBullet = false;
    public Bullet(int posX, int posY, boolean isPlayerBullet) {
        super(posX, posY, 6);
        setPlayerBullet(isPlayerBullet);
    }

    public Bullet(int posX, int posY, double speed, boolean isPlayerBullet) {
        super(posX, posY, speed);
        setPlayerBullet(isPlayerBullet);
    }

    public abstract void hit();

    @Override
    public void update() {
        movement();
        setBounds();
        animation();
        hit();
    }

    public boolean isPlayerBullet() {
        return isPlayerBullet;
    }

    public void setPlayerBullet(boolean playerBullet) {
        isPlayerBullet = playerBullet;
    }
}
