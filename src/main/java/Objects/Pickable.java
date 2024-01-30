package Objects;
import Game.Game;
import Schema.Object;

public class Pickable implements Object {
    private int weight;
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
}