package Actions;

import Game.Game;
import Objects.Readable;
import Schema.ObjectActions;

public class Read extends ObjectActions<Readable> {

    public Read(String objectName) {
        super(objectName);
        setActionLabel("read");
    }

    @Override
    public void transform(Readable a, Game game) {
        a.read();
    }
}