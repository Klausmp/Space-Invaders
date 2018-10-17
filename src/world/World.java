package world;

import entity.*;
import input.Keyboard;
import output.Renderer;
import util.Util;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class World {
    public int runX = 0;
    public int RUNX = 92;
    public int lives = 3;
    public int score = 0;

    public boolean runLeft = true;
    public boolean firstRunn = true;
    public boolean isGameRunning = false;
    public boolean isRendert = true;

    public List<Bullet> bulletList = new ArrayList<Bullet>();
    public List<Bullet> deadBulletList = new ArrayList<Bullet>();
    public List<Alien> alienList = new ArrayList<Alien>();
    public List<Alien> deadAlienList = new ArrayList<Alien>();
    public List<Player> playerList = new ArrayList<Player>();
    public List<Player> deadPlayerList = new ArrayList<Player>();
    public List<Shield> shieldList = new ArrayList<Shield>();
    public List<Shield> deadShieldList = new ArrayList<Shield>();
    public List<Item> itemList = new ArrayList<Item>();

    public World() {

    }

    public void update() {
        for (Player player : getPlayerList()) {
            if (!player.isAlive()) {
                setGameRunning(false);
            }
            if (!getAlienList().isEmpty())
                player.update();
        }
        if (isGameRunning()) {
            for (Alien alien : getAlienList()) {
                alien.update();
            }
            for (Bullet bullet : getBulletList()) {
                bullet.update();
            }
            for (Shield shield : getShieldList()) {
                shield.update();
            }
            for (Item item : getItemList()) {
                item.update();
            }
            if (getRUNX() <= getRunX()) {
                setRunX(0);
                for (Alien alien : getAlienList()) {
                    alien.setPosY(alien.getPosY() + (alien.height * 0.8));
                }
                if (isRunLeft()) {
                    setRunLeft(false);
                    setFirstRunn(false);

                } else {
                    setRunLeft(true);
                    setFirstRunn(false);
                }
            }
            if (!isFirstRunn()) {
                setRUNX(184);
            }
            setRunX(getRunX() + 1);
        } else {
            for (Bullet bullet : getBulletList()) {
                getDeadBulletList().add(bullet);
            }
        }
        if (getAlienList().isEmpty()) {
            setGameRunning(false);
        }
        if (Keyboard.isKeyDown(KeyEvent.VK_ENTER) && getAlienList().isEmpty()) {
            setGameRunning(true);
            resetAlien();
        }
        if (Keyboard.isKeyDown(KeyEvent.VK_ENTER) && getPlayerList().isEmpty() && getLives() > 0) {
            getPlayerList().add(new Player((Renderer.getWindowSizeX() / 2) - 12, 350));
            setGameRunning(true);
        }
        if (getLives() <= 0) {
            remove();
        }
    }

    public void remove() {
        for (World world : Util.getWorldList()) {
            Util.getDeadWorldList().add(world);
            for (Player player : world.getPlayerList()) {
                player.setCanBeRemoved(true);
            }
            for (Bullet bullet : world.getBulletList()) {
                bullet.setCanBeRemoved(true);
            }
            for (Alien alien : world.getAlienList()) {
                alien.setCanBeRemoved(true);
            }
            for (Shield shield : world.getShieldList()) {
                for (ShieldTile shieldTile : shield.getShieldTileList()) {
                    shieldTile.setCanBeRemoved(true);
                }
                shield.setCanBeRemoved(true);
            }
        }
    }

    public void resetAlien() {
        setRunX(0);
        setRUNX(92);
        setRunLeft(true);
        setFirstRunn(true);
        getShieldList().add(new Shield(1, 1));
        getAlienList().add(new Alien(10000, 1000, 1));
        /*
        for (int x = 50; x <= Renderer.getWindowSizeX() - 76; x += 26) {
            for (int y = 30; y <= 55; y += 26) {
                getAlienList().add(new Alien(x, y, 1));
            }
            for (int y = 57; y <= 108; y += 26) {
                getAlienList().add(new Alien(x, y, 2));
            }
            for (int y = 109; y <= 159; y += 26) {
                getAlienList().add(new Alien(x, y, 3));
            }
        }*/
    }

    public void render(Graphics g) {
        if (isRendert) {
            for (Alien alien : getAlienList()) {
                alien.render(g);
            }
            for (Player player : getPlayerList()) {
                player.render(g);
            }
            for (Bullet bullet : getBulletList()) {
                bullet.render(g);
            }
            for (Shield shield : getShieldList()) {
                shield.render(g);
            }
            for (Item item : getItemList()) {
                item.render(g);
            }
        }
    }

    public int getRunX() {
        return runX;
    }

    public void setRunX(int runX) {
        this.runX = runX;
    }

    public int getRUNX() {
        return RUNX;
    }

    public void setRUNX(int RUNX) {
        this.RUNX = RUNX;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isRunLeft() {
        return runLeft;
    }

    public void setRunLeft(boolean runLeft) {
        this.runLeft = runLeft;
    }

    public boolean isFirstRunn() {
        return firstRunn;
    }

    public void setFirstRunn(boolean firstRunn) {
        this.firstRunn = firstRunn;
    }

    public boolean isGameRunning() {
        return isGameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        isGameRunning = gameRunning;
    }

    public boolean isRendert() {
        return isRendert;
    }

    public void setRendert(boolean rendert) {
        isRendert = rendert;
    }

    public List<Bullet> getBulletList() {
        return bulletList;
    }

    public void setBulletList(List<Bullet> bulletList) {
        this.bulletList = bulletList;
    }

    public List<Bullet> getDeadBulletList() {
        return deadBulletList;
    }

    public void setDeadBulletList(List<Bullet> deadBulletList) {
        this.deadBulletList = deadBulletList;
    }

    public List<Alien> getAlienList() {
        return alienList;
    }

    public void setAlienList(List<Alien> alienList) {
        this.alienList = alienList;
    }

    public List<Alien> getDeadAlienList() {
        return deadAlienList;
    }

    public void setDeadAlienList(List<Alien> deadAlienList) {
        this.deadAlienList = deadAlienList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getDeadPlayerList() {
        return deadPlayerList;
    }

    public void setDeadPlayerList(List<Player> deadPlayerList) {
        this.deadPlayerList = deadPlayerList;
    }

    public List<Shield> getShieldList() {
        return shieldList;
    }

    public void setShieldList(List<Shield> shieldList) {
        this.shieldList = shieldList;
    }

    public List<Shield> getDeadShieldList() {
        return deadShieldList;
    }

    public void setDeadShieldList(List<Shield> deadShieldList) {
        this.deadShieldList = deadShieldList;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "World{" +
                "runX=" + runX +
                ", RUNX=" + RUNX +
                ", runLeft=" + runLeft +
                ", firstRunn=" + firstRunn +
                '}';
    }
}
