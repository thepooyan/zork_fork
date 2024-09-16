package Actions;

import Game.Game;
import Objects.Abstraction.Properties.Readable;
import Schema.ActionOnObject;

public class Read extends ActionOnObject<Readable> {
    public Read() {
        setExpectedArguments(1);
    }

    @Override
    public void applyAction(Readable subject, Game game) {
        subject.read();
    }
}