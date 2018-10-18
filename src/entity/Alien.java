package entity;

import output.Renderer;
import util.Util;
import world.World;


public class Alien extends Entity {
    //Legt fest ob die Animation läuft oder nicht
    public boolean animationRunning = false;
    //Legt fest ob die Animation in Status eins oder zwei ist
    public boolean animationStatus = true;
    //Legt fest nach wie vielen Ticks die Anomation beeginnt, damit nicht alle Animationen simultan sind
    public int animationStart = 0;
    public int ANIMATIONSTART = (int) ((Math.random() * 89) + 1);
    //Legt fest wie lange die Todesanimation abgespielt wird
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

    public void shoot() {
        if ((int) (Math.random() * 109 + 1) == 50 && getSHOTDELAY() <= getShotDelay()) {
            setShotDelay(0);
            for (World world : Util.getWorldList()) {
                world.getBulletList().add(new AlienBullet(getPosX_int() + (getWight() / 2), getPosY_int() - getHeight()));
            }
        }
        if (getSHOTDELAY() <= getShotDelay()) {
            setShotDelay(0);
        }
        setShotDelay(getShotDelay() + 1);
    }

    @Override
    public void animation() {
        if (!isAnimationRunning()) {
            setAnimationStart(getAnimationStart() + 1);
            if (getANIMATIONSTART() <= getAnimationStart()) {
                setAnimationRunning(true);
            }
        }
        if (isAnimationRunning()) {
            switch (getAlienType()) {
                case 1:
                    if (isAnimationStatus()) {
                        setLook(Renderer.getAlien1_0());
                    } else {
                        setLook(Renderer.getAlien1_1());
                    }
                    break;
                case 2:
                    if (isAnimationStatus()) {
                        setLook(Renderer.getAlien2_0());
                    } else {
                        setLook(Renderer.getAlien2_1());
                    }
                    break;
                case 3:
                    if (isAnimationStatus()) {
                        setLook(Renderer.getAlien3_0());
                    } else {
                        setLook(Renderer.getAlien3_1());
                    }
                    break;
                default:
                    System.out.println("Wrong Alien Type!! (Animation)");
                    setLook(Renderer.getAlien2_0());
                    break;
            }
            if (getAnimationTimer() >= getANIMATIONTIMER()) {
                setAnimationTimer(0);
                if (isAnimationStatus()) {
                    setAnimationStatus(false);
                } else {
                    setAnimationStatus(true);
                }
            }
            setAnimationTimer(getAnimationTimer() + 1);
        }
        if (!isAlive()) {
            setLook(Renderer.getAlienDestroyed());
            setDeadAnimationTimer(getDeadAnimationTimer() + 1);
        }
        if (getDEADANIMATIONTIMER() <= getDeadAnimationTimer()) {
            for (World world : Util.getWorldList()) {
                switch (getAlienType()) {
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
                        System.out.println("Wrong Alien Type!! (Dead Animation)");
                        break;
                }
            }
            setCanBeRemoved(true);
        }
    }

    @Override
    public void setStartTexture() {
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
                System.out.println("Wrong Alien Type!! (Init)");
                setLook(Renderer.getAlien2_0());
                break;
        }
    }

    @Override
    public void movement() {
        for (World world : Util.getWorldList()) {
            if (world.isRunLeft()) {
                setPosX(getPosX() - getSpeed());
            } else {
                setPosX(getPosX() + getSpeed());
            }
        }
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

    public boolean isAnimationRunning() {
        return animationRunning;
    }

    public void setAnimationRunning(boolean animationRunning) {
        this.animationRunning = animationRunning;
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

    public boolean isAnimationStatus() {
        return animationStatus;
    }

    public void setAnimationStatus(boolean animationStatus) {
        this.animationStatus = animationStatus;
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

    @Override
    public String toString() {
        return "Alien{" +
                "animationRunning=" + animationRunning +
                ", animationStatus=" + animationStatus +
                ", animationStart=" + animationStart +
                ", ANIMATIONSTART=" + ANIMATIONSTART +
                ", ANIMATIONTIMER=" + ANIMATIONTIMER +
                ", animationTimer=" + animationTimer +
                '}';
    }
}
