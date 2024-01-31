package Actions;

import Game.Game;
import Objects.Openable;
import Schema.ActionOnObject;

public class Open extends ActionOnObject<Openable> {
    @Override
    public void applyAction(Openable object, Game game) {
        object.open(game);
    }
}
