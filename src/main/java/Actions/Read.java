package Actions;

import Game.Game;
import Objects.Readable;
import Schema.ActionOnObject;

public class Read extends ActionOnObject<Readable> {

    public Read(String objectName) {
        super(objectName);
    }

    @Override
    public void applyAction(Readable object, Game game) {
        object.read();
    }
}