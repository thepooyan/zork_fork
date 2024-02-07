package Objects;
import Game.Game;
import Schema.Object;

import java.util.Random;

public class Pickable implements Object {
    private final int weight;
    private final int id = new Random().nextInt(10000);
    public Pickable(int weight) {
       this.weight = weight;
    }
    public void pickup(Game game) {
        game.addToInventory(this);
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public boolean equals(Pickable item) {
        return item.id == this.id;
    }
}