package entity;

import grafiks.Renderer;
import util.Util;
import world.World;

/**
 * @author Klausmp
 */

public class AlienBullet extends Bullet {
    //Legt fest wie lange die Todesanimation nach einem Treffer angezeigt wird
    public int deadAnimationTimer = 0;
    public final int DEADANIMATIONTIMER = 7;
    //Leget fest in welchem abstand die Texturen für die Animation geändert wird
    public int animationTimer = 0;
    public final int ANIMATIONTIMER = 6;
    //Speichert den Momentanen Status der Animation (welche der beiden Texturen gerade angezeigt wird)
    public boolean animationStatus = true;

    public AlienBullet(int posX, int posY) {
        super(posX, posY, 5, false);
    }

    @Override
    public void hit() {
        for (World world: Util.getWorldList()) {
            for (Player player: world.getPlayerList()) {
                //Prüfung ob die Hitbox des Bullet sich mit der des Spielers Überschneidet
                if (getBounding().intersects(player.getBounding())){
                    //Gibt das Bullet zur entfernung frei
                    this.setCanBeRemoved(true);
                    //Tötet den Spieler
                    player.setAlive(false);
                }
            }
        }
        //Prüft ob ein Shield getroffen wird
        hitShield();
    }

    @Override
    public void setStartTexture() {
        look = Renderer.getAlienBullet0();
    }

    @Override
    public void movement() {
        //Testet ob das Bullet am leben ist
        if (isAlive()) {
            //Lässt den Schuss mit dem Speed nach unten fallen (plus auf der Y-Achse)
            setPosY(getPosY() + speed);
        }
        //Testet ob der Schuss das Fenster am unteren ende (Positive Y Richtung)
        if ((int) getPosY() >= Renderer.getWindowSizeY()) {
            //Tötet den Schuss
            this.setAlive(false);
        }
    }

    @Override
    public void animation() {
        //Erhöht den wert des AnimationTImers um 1
        setAnimationTimer(getAnimationTimer() + 1);
        //Früft ob der Delay zwischen dem Wechsel der Texturen zu ende ist
        if (getANIMATIONTIMER() == getAnimationTimer()) {
            //Negiert die Texturen der Animation
            if (isAnimationStatus()) {
                look = Renderer.getAlienBullet0();
                setAnimationStatus(false);
            } else {
                look = Renderer.getAlienBullet1();
                setAnimationStatus(true);
            }
            //Startet den Delay zwischen den Wechseln der Textur von neuem
            setAnimationTimer(0);
        }
        //Prüfung ob der Schuss nicht am leben ist
        if (!isAlive()) {
            //Setzt die Textur auf die Todestextur
            look = Renderer.getAlienBulledDead();
            //Erhöt den TodesTimer um 1
            setDeadAnimationTimer(getDeadAnimationTimer() + 1);
        }
        //Prüft ob die Todesanimation abgeschlossen ist
        if (getDEADANIMATIONTIMER() <= getDeadAnimationTimer()) {
            //Gibt den Schuss zum Löschen frei
            setCanBeRemoved(true);
        }
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
        return "AlienBullet{" +
                "deadAnimationTimer=" + deadAnimationTimer +
                ", DEADANIMATIONTIMER=" + DEADANIMATIONTIMER +
                ", animationTimer=" + animationTimer +
                ", ANIMATIONTIMER=" + ANIMATIONTIMER +
                ", animationStatus=" + animationStatus +
                ", isPlayerBullet=" + isPlayerBullet +
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