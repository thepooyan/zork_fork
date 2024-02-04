package Actions;


import Game.Game;
import Objects.Pickable;
import Schema.ActionOnObject;

public class Pick extends ActionOnObject<Pickable> {
    public Pick() {
        setExpectedArgumnets(1);
    }

    @Override
    public void applyAction(Pickable object, Game game) {
        object.pickup(game);
    }
}
