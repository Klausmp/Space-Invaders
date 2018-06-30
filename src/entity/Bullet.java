package entity;

public abstract class Bullet extends Entity{
    public boolean isPlayerBullet = false;
    public Bullet(int posX, int posY, boolean isPlayerBullet) {
        super(posX, posY, 6);
        this.isPlayerBullet = isPlayerBullet;
    }

    public Bullet(int posX, int posY, double speed, boolean isPlayerBullet) {
        super(posX, posY, speed);
        this.isPlayerBullet = isPlayerBullet;
    }

    public abstract void hit();

    @Override
    public void update() {
        movement();
        setBounds();
        hit();
    }

    public boolean isPlayerBullet() {
        return isPlayerBullet;
    }

    public void setPlayerBullet(boolean playerBullet) {
        isPlayerBullet = playerBullet;
    }
}
