package Objects;
import Game.Game;
import Schema.Object;

public class Pickable implements ObjectWithAction {
    private int weight;
    public Pickable(int weight) {
       this.weight = weight;
    }
    public void pickup(Game game) {
        System.out.println("picked up");
    }

    @Override
    public void action(Game game) {
        this.pickup(game);
    }
}