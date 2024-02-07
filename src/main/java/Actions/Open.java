package Actions;

import Game.Game;
import Objects.Openable;
import Schema.ActionOnObject;

public class Open extends ActionOnObject<Openable> {
    public Open() {
        setExpectedArguments(1);
    }

    @Override
    public void applyAction(Openable subject, Game game) {
        subject.open(game);
    }
}
