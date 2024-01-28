package Objects;
import Game.Game;
import Schema.Object;

public class Pickable implements Object {
    private int weight;
    public Pickable(int weight) {
       this.weight = weight;
    }
    void pickup(Game game) {
        System.out.println("picked up");
    }
}