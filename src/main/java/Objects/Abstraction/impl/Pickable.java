package Objects.Abstraction.impl;
import Game.Game;
import Schema.Object;
import Schema.ObjectImpl;

import java.util.Random;

public class Pickable extends ObjectImpl implements Objects.Abstraction.Properties.Pickable {
    private final int weight;
    private final int id = new Random().nextInt(10000);
    public Pickable(int weight, String desc) {
        super(desc);
        this.weight = weight;
    }

    @Override
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