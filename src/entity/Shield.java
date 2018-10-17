package entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Shield extends Entity {
    public List<ShieldTile> shieldTileList = new ArrayList<ShieldTile>();
    public List<ShieldTile> deadShieldTileList = new ArrayList<ShieldTile>();


    public Shield(int posX, int posY) {
        super(posX, posY, false, false);
        shieldTileList.add(new ShieldTile(100, 100, 2));
    }

    public void render(Graphics g) {
        for (ShieldTile shieldTile : getShieldTileList()) {
            shieldTile.render(g);
        }
    }

    @Override
    public void update() {
        for (ShieldTile shieldTile : getShieldTileList()) {
            shieldTile.update();
        }
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

    public List<ShieldTile> getShieldTileList() {
        return shieldTileList;
    }

    public void setShieldTileList(List<ShieldTile> shieldTileList) {
        this.shieldTileList = shieldTileList;
    }

    public List<ShieldTile> getDeadShieldTileList() {
        return deadShieldTileList;
    }

    public void setDeadShieldTileList(List<ShieldTile> deadShieldTileList) {
        this.deadShieldTileList = deadShieldTileList;
    }
}
