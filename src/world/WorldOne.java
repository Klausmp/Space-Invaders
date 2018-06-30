package world;

import entity.Alien;
import entity.Player;
import output.GameFrame;

public class WorldOne extends World {
    public WorldOne() {
        playerList.add(new Player(255, 350));
        for (int x = 50; x <= GameFrame.getWindowSizeX() - 76; x += 26) {
            for (int y = 30; y <= 159; y += 26) {
                getAlienList().add(new Alien(x, y));
            }
        }
    }
}
