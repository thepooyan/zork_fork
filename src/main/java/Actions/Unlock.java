package Actions;

import Game.Game;
import Objects.Key;
import Objects.Lock;
import Schema.ActionOnObject;

public class Unlock extends ActionOnObject<Lock> {
    public Unlock() {
        setExpectedArguments(3);
    }

    @Override
    public void applyAction(Lock a, Game game) {
        a.unlock(new Key("12s"));
    }
}
