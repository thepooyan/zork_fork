package Actions;

import Game.Game;
import Objects.Openable;
import Schema.ActionOnObject;

public class Open extends ActionOnObject<Openable> {
    public Open(String objectName) {
        super(objectName);
        setActionLabel("open");
    }

    @Override
    public void applyAction(Openable a, Game game) {
        a.open(game);
    }
}
