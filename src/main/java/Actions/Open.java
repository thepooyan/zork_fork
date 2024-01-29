package Actions;

import Game.Game;
import Objects.Openable;
import Schema.ObjectActions;

public class Open extends ObjectActions<Openable> {
    public Open(String objectName) {
        super(objectName);
        setActionLabel("open");
    }

    @Override
    public void transform(Openable a, Game game) {
        a.open(game);
    }
}
