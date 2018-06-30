package world;

import entity.Alien;
import entity.Player;

public class WorldOne extends World {
    public WorldOne() {
        playerList.add(new Player(255, 400));
        alienList.add(new Alien(100, 200));
    }
}
