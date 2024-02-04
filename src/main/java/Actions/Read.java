package Actions;

import Game.Game;
import Objects.Readable;
import Schema.ActionOnObject;

public class Read extends ActionOnObject<Readable> {
    public Read() {
        setExpectedArguments(1);
    }

    @Override
    public void applyAction(Readable object, Game game) {
        object.read();
    }
}