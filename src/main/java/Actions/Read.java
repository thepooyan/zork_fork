package Actions;

import Game.Game;
import Objects.Readable;
import Schema.ActionOnObject;

public class Read extends ActionOnObject<Readable> {

    public Read(String objectName) {
        super(objectName);
        setActionLabel("read");
    }

    @Override
    public void applyAction(Readable a, Game game) {
        a.read();
    }
}