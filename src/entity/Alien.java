package entity;

import grafiks.Renderer;
import util.Util;
import world.World;

/**
 * @author Klausmp
 */

public class Alien extends Entity {
    //Legt fest ob die Animation läuft oder nicht
    public boolean animationRunning = false;
    //Legt fest ob die Animation in Status eins oder zwei ist
    public boolean animationStatus = true;
    //Legt fest nach wie vielen Ticks die Anomation beeginnt, damit nicht alle Animationen simultan sind
    public int animationStart = 0;
    public int ANIMATIONSTART = (int) ((Math.random() * 89) + 1);
    //Legt fest wie lange die Todesanimation abgespielt wird und bis der Alien gelöscht wird
    public int deadAnimationTimer = 0;
    public final int DEADANIMATIONTIMER = 5;
    //Legt fest zu welchem Alien Typ der Alien gehört (1-3). Davon ist die Anzahl der Punkte abhänig und auch die Textur
    public int alienType;
    //Legt die dauer eines Durchlaufes der Animation fest
    public final int ANIMATIONTIMER = 30;
    public int animationTimer = 0;
    //Legt fest in welchem Abstand der Alien versuchen kann einen Schuss abzugeben
    public final int SHOTDELAY = 10;
    public int shotDelay = 0;

    public Alien(int posX, int posY, int alienType) {
        setPosX(posX);
        setPosY(posY);
        setAlienType(alienType);
        setSpeed(0.5);
        setStartTexture();
        setBounds();

    }

    public Alien(int posX, int posY) {
        super(posX, posY, 0.5);
    }

    @Override
    public void update() {
        movement();
        setBounds();
        animation();
        shoot();
    }

    //Zuständig für das schießen des Alien
    public void shoot() {
        //Prüft ob der Delay für einen Schuss zu ende ist
        //Check Ob eine Random zahl zwischen 1 und 110 == 50 ist, wenn beides zutrifft wird ein schuss abgegeben
        if ((int) (Math.random() * 109 + 1) == 50 && getSHOTDELAY() <= getShotDelay()) {
            //Setzt den Delay für Schüsse wieder auf 0 zurück
            setShotDelay(0);
            //Initazalisiert einen Schuss
            for (World world : Util.getWorldList()) {
                world.getBulletList().add(new AlienBullet(((int) getPosX()) + (getWight() / 2), ((int) getPosY()) - getHeight()));
            }
        }
        //Wenn der Timer für einen Schuss größer als der Delay ist wieder der Timer wieder auf 0 gesetzt
        if (getSHOTDELAY() <= getShotDelay()) {
            setShotDelay(0);
        }
        //Erhöt den Timer um 1
        setShotDelay(getShotDelay() + 1);
    }

    @Override
    public void animation() {
        //Prüft ob die Animation schon begonnen hat
        if (!isAnimationRunning()) {
            //Erhöht den Animatiostimmer um 1
            setAnimationStart(getAnimationStart() + 1);
            //Prüft ob der Delay für denStart der Animation abgelaufen ist
            if (getANIMATIONSTART() <= getAnimationStart()) {
                //Startet die Amimation
                setAnimationRunning(true);
            }
        }
        //Prüfung ob die Animation leuft
        if (isAnimationRunning()) {
            //Prüft welche Art von ALien Voeliegt
            switch (getAlienType()) {
                case 1:
                    //Prüfung welche Stelle der Animation gerade vorliegt
                    if (isAnimationStatus()) {
                        //Setung der Stufe 1 der Animation
                        setLook(Renderer.getAlien1_0());
                    } else {
                        //Setzung der Stufe 2 der Animation
                        setLook(Renderer.getAlien1_1());
                    }
                    break;
                case 2:
                    //Prüfung welche Stelle der Animation gerade vorliegt
                    if (isAnimationStatus()) {
                        //Setung der Stufe 1 der Animation
                        setLook(Renderer.getAlien2_0());
                    } else {
                        //Setzung der Stufe 2 der Animation
                        setLook(Renderer.getAlien2_1());
                    }
                    break;
                case 3:
                    //Prüfung welche Stelle der Animation gerade vorliegt
                    if (isAnimationStatus()) {
                        //Setung der Stufe 1 der Animation
                        setLook(Renderer.getAlien3_0());
                    } else {
                        //Setzung der Stufe 2 der Animation
                        setLook(Renderer.getAlien3_1());
                    }
                    break;
                default:
                    //Default mit Fehlermeldung und setung einer festen Textur (Nur bei der Auswahl eines falschen AlienTypes)
                    System.out.println("Wrong Alien Type!! (Animation)");
                    setLook(Renderer.getAlien2_0());
                    break;
            }
            //Testet ob der Animationstimer größer als der Delay zum ändern des Animatios Staus ist
            if (getAnimationTimer() >= getANIMATIONTIMER()) {
                //Setzt den Timer wieder auf 0 zurück
                setAnimationTimer(0);
                //Ändert den Status der Animation in den entgegegesetzten Status
                if (isAnimationStatus()) {
                    setAnimationStatus(false);
                } else {
                    setAnimationStatus(true);
                }
            }
            //Erhöht denAnimationsTImer um 1
            setAnimationTimer(getAnimationTimer() + 1);
        }
        //Schaut ob der Alien gestorben ist
        if (!isAlive()) {
            //Setzt look auf die Exlosionstextur
            setLook(Renderer.getAlienDestroyed());
            //Erhöt den DeadAnimationsTimer um 1
            setDeadAnimationTimer(getDeadAnimationTimer() + 1);
        }
        //Prüfung ob das Limit des deadAnimationTimeres erricht ist
        if (getDEADANIMATIONTIMER() <= getDeadAnimationTimer()) {
            for (World world : Util.getWorldList()) {
                switch (getAlienType()) {
                    //Erhöht den Score jenacch AlienTyp
                    case 1:
                        world.setScore(world.getScore() + 50);
                        break;
                    case 2:
                        world.setScore(world.getScore() + 40);
                        break;
                    case 3:
                        world.setScore(world.getScore() + 20);
                        break;
                    default:
                        //Fehlermeldung bei falschem AlienTyp
                        System.out.println("Wrong Alien Type!! (Dead Animation)");
                        break;
                }
            }
            //Gibt den Alien zur Entfernung frei
            setCanBeRemoved(true);
        }
    }

    @Override
    public void setStartTexture() {
        //Setzt die Richtige StartTextur je nacch AlienTyp
        switch (getAlienType()) {
            case 1:
                setLook(Renderer.getAlien1_0());
                break;
            case 2:
                setLook(Renderer.getAlien2_0());
                break;
            case 3:
                setLook(Renderer.getAlien3_0());
                break;
            default:
                //Fehlermeldung bei falschem AlienTyp
                System.out.println("Wrong Alien Type!! (Init)");
                //Setzt die StandartAlienTextur
                setLook(Renderer.getAlien2_0());
                break;
        }
    }

    @Override
    public void movement() {
        for (World world : Util.getWorldList()) {
            //Lässt je nach Status die Aliens nach Lings oder Rechts laufen
            if (world.isRunLeft()) {
                setPosX(getPosX() - getSpeed());
            } else {
                setPosX(getPosX() + getSpeed());
            }
        }
    }

    public boolean isAnimationRunning() {
        return animationRunning;
    }

    public void setAnimationRunning(boolean animationRunning) {
        this.animationRunning = animationRunning;
    }

    public boolean isAnimationStatus() {
        return animationStatus;
    }

    public void setAnimationStatus(boolean animationStatus) {
        this.animationStatus = animationStatus;
    }

    public int getAnimationStart() {
        return animationStart;
    }

    public void setAnimationStart(int animationStart) {
        this.animationStart = animationStart;
    }

    public int getANIMATIONSTART() {
        return ANIMATIONSTART;
    }

    public void setANIMATIONSTART(int ANIMATIONSTART) {
        this.ANIMATIONSTART = ANIMATIONSTART;
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

    public int getAlienType() {
        return alienType;
    }

    public void setAlienType(int alienType) {
        this.alienType = alienType;
    }

    public int getANIMATIONTIMER() {
        return ANIMATIONTIMER;
    }

    public int getAnimationTimer() {
        return animationTimer;
    }

    public void setAnimationTimer(int animationTimer) {
        this.animationTimer = animationTimer;
    }

    public int getSHOTDELAY() {
        return SHOTDELAY;
    }

    public int getShotDelay() {
        return shotDelay;
    }

    public void setShotDelay(int shotDelay) {
        this.shotDelay = shotDelay;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "animationRunning=" + animationRunning +
                ", animationStatus=" + animationStatus +
                ", animationStart=" + animationStart +
                ", ANIMATIONSTART=" + ANIMATIONSTART +
                ", deadAnimationTimer=" + deadAnimationTimer +
                ", DEADANIMATIONTIMER=" + DEADANIMATIONTIMER +
                ", alienType=" + alienType +
                ", ANIMATIONTIMER=" + ANIMATIONTIMER +
                ", animationTimer=" + animationTimer +
                ", SHOTDELAY=" + SHOTDELAY +
                ", shotDelay=" + shotDelay +
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
