package Actions;


import Game.Game;
import Objects.Pickable;
import Schema.ActionOnObject;

public class Pick extends ActionOnObject<Pickable> {
    public Pick() {
        setExpectedArguments(1);
    }

    @Override
    public void applyAction(Pickable subject, Game game) {
        subject.pickup(game);
    }
}
