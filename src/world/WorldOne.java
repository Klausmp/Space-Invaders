package world;

import entity.Alien;
import entity.Shield;
import output.Renderer;

public class WorldOne extends World {
    public WorldOne() {
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

    @Override
    public void update() {
        super.update();
    }
}
