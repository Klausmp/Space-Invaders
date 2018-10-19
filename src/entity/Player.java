package entity;

import input.Keyboard;
import output.Renderer;
import util.Util;
import world.World;
import java.awt.event.KeyEvent;

/**
 * @author Klausmp
 */

public class Player extends Entity {
    //Legt fest wie lange die Todesanimation abgespielt wird und bis der Player gelöscht wird
    public int deadAnimationTimer = 0;
    public final int DEADANIMATIONTIMER = 20;
    //Legt fest in welchem abstand zwischen den beiden Dead Texturen gewechselt wird
    public int animationTimer = 5;
    public final int ANIMATIONTIMER = 5;
    //Legt fest welche der beiden Todestexturen angezeigt wird
    public boolean animationStatus = true;

    public Player(int posX, int posY, double speed) {
        super(posX, posY, speed);
    }

    public Player(int posX, int posY) {
        super(posX, posY, 2.5);
    }

    @Override
    public void update() {
        movement();
        animation();
        shot();
    }

    @Override
    public void setStartTexture() {
        look = Renderer.getShip();
    }

    @Override
    public void movement() {
        //Abfrage ob der Player am leben ist
        if (isAlive()) {
            //Prüfung ob A oder die linke Pfeiltaste gedrückt ist
            if (Keyboard.isKeyDown(KeyEvent.VK_LEFT) || Keyboard.isKeyDown(KeyEvent.VK_A)) {
                //Änder die X Position um den speed wert nach link (verkleinert sie)
                setPosX(getPosX() - getSpeed());
                //Prüft ob der Spieler den linken Rand des Fensters erreicht hat
                if (getPosX() <= 0) {
                    //Setzt die X Position des Spielers an den Rand des Fensters zurück
                    setPosX(0);
                }
            }
            //Prüfung ob D oder die rechte Pfeiltaste gedrückt ist
            if (Keyboard.isKeyDown(KeyEvent.VK_RIGHT) || Keyboard.isKeyDown(KeyEvent.VK_D)) {
                //Änder die X Position um den speed wert nach rechts (vergrößert sie)
                setPosX(getPosX() + getSpeed());
                //Prüft ob der Spieler den rechten Rand des Fensters erreicht hat
                if (getPosX() >= Renderer.getWindowSizeX() - getWight() - 7) {
                    //Setzt die X Position des Spielers an den Rand des Fensters zurück
                    setPosX(Renderer.getWindowSizeX() - getWight() - 7);
                }
            }
            //Aktualsiert die Hitbox
            setBounds();
        }
    }

    @Override
    public void animation() {
        //Prüfung ob der Spieler am nicht leben ist
        if (!isAlive()) {
            //Prüft ob der Delay zwischen den Texturen wechsel zu ende ist
            if (getANIMATIONTIMER() <= getAnimationTimer()) {
                //Setzt den Animationstimer auf 0
                setAnimationTimer(0);
                //Negiert die Texturen der Animation
                if (isAnimationStatus()) {
                    setLook(Renderer.getShipDead0());
                    setAnimationStatus(false);
                } else {
                    setLook(Renderer.getShipDead1());
                    setAnimationStatus(true);
                }
            }
            setDeadAnimationTimer(getDeadAnimationTimer() + 1);
        }
        //Erhöt den deadAnimationTimer um 1
        setAnimationTimer(getAnimationTimer() + 1);
        //Prüft ob das Maximum des deadAnimationTimers erreicht ist
        if (getDEADANIMATIONTIMER() <= getDeadAnimationTimer()) {
            for (World world : Util.getWorldList()) {
                //Entfern ein leben
                world.setLives(world.getLives() - 1);
            }
            System.out.println("ofe");
            //Gibt den Player zur Entfernung frei
            setCanBeRemoved(true);
        }
    }

    //Abgabe von Schüssen
    public void shot() {
        //Prüft ob der Spieler schießen kann
        if (canShoot()) {
            //Prüft ob Space, W oder Pfeiltaste nach oben gedrückt ist
            if (Keyboard.isKeyDown(KeyEvent.VK_SPACE) || Keyboard.isKeyDown(KeyEvent.VK_W) || Keyboard.isKeyDown(KeyEvent.VK_UP)) {
                for (World world : Util.getWorldList()) {
                    //Initalisiert einen neuen schuss in der mitte des Spielers
                    world.bulletList.add(new PlayerBullet(((int) getPosX()) + (getWight() / 2 - 3), ((int) getPosY())));
                }
            }
        }
    }

    //Prüfung ob der Spieler einen schuss abgeben kann
    public boolean canShoot() {
        for (World world : Util.getWorldList()) {
            for (Bullet bullet : world.getBulletList()) {
                //Prüft ob ein Bullet des Spielers in Level vorhanden ist (welches nicht tot (also in der Todesanimation) ist)
                if (bullet.isPlayerBullet() && bullet.isAlive) {
                    //in diesem fall kann der Spieler keinen schuss abgeben
                    return false;
                }
            }
        }
        //in diesem fall kann der Spieler einen schuss abgeben
        return true;
    }

    public int getDeadAnimationTimer() {
        return deadAnimationTimer;
    }

    public void setDeadAnimationTimer(int deadAnimationTimer) {
        this.deadAnimationTimer = deadAnimationTimer;
    }

    public int getDEADANIMATIONTIMER() {
        return DEADANIMATIONTIMER;
    }

    public int getAnimationTimer() {
        return animationTimer;
    }

    public void setAnimationTimer(int animationTimer) {
        this.animationTimer = animationTimer;
    }

    public int getANIMATIONTIMER() {
        return ANIMATIONTIMER;
    }

    public boolean isAnimationStatus() {
        return animationStatus;
    }

    public void setAnimationStatus(boolean animationStatus) {
        this.animationStatus = animationStatus;
    }

    @Override
    public String toString() {
        return "Player{" +
                "deadAnimationTimer=" + deadAnimationTimer +
                ", DEADANIMATIONTIMER=" + DEADANIMATIONTIMER +
                ", animationTimer=" + animationTimer +
                ", ANIMATIONTIMER=" + ANIMATIONTIMER +
                ", animationStatus=" + animationStatus +
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
