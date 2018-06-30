package world;

import entity.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class World {
    public List<Bullet> bulletList = new ArrayList<Bullet>();
    public List<Bullet> deadBulletList = new ArrayList<Bullet>();
    public List<Alien> alienList = new ArrayList<Alien>();
    public List<Alien> deadAlienList = new ArrayList<Alien>();
    public List<Player> playerList = new ArrayList<Player>();
    public List<Player> deadPlayerList = new ArrayList<Player>();
    public List<Item> itemList = new ArrayList<Item>();

    public void update() {
        for (Alien alien : getAlienList()) {
            alien.update();
        }
        for (Player player : getPlayerList()) {
            player.update();
        }
        for (Bullet bullet: getBulletList()) {
            bullet.update();
        }
        for (Item item : getItemList()) {
            item.update();
        }
    }

    public void render(Graphics g) {
        for (Alien alien : getAlienList()) {
            alien.render(g);
        }
        for (Player player : getPlayerList()) {
            player.render(g);
        }
        for (Bullet bullet: getBulletList()) {
            bullet.render(g);
        }
        for (Item item : getItemList()) {
            item.render(g);
        }
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

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "World{" +
                "bulletList=" + bulletList +
                ", deadBulletList=" + deadBulletList +
                ", alienList=" + alienList +
                ", deadAlienList=" + deadAlienList +
                ", playerList=" + playerList +
                ", deadPlayerList=" + deadPlayerList +
                ", itemList=" + itemList +
                '}';
    }
}
