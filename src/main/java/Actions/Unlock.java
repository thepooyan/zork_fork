package Actions;

import Game.Game;
import Objects.Key;
import Objects.Lock;
import Schema.ActionOnObject;

import java.util.Optional;

public class Unlock extends ActionOnObject<Lock> {
    public Unlock() {
        setExpectedArguments(3);
    }

    @Override
    public void applyAction(Lock a, Game game) {
        if (!arguments[1].equals("with")) {
            System.out.println("unlock with what?");
            return;
        }

        Optional<Key> key = game.getInventory()
                .stream()
                .filter(f -> f.toString().equalsIgnoreCase(arguments[2]))
                .map(m -> (Key) m)
                .findFirst();
        key.ifPresentOrElse(a::unlock, () -> {
            System.out.println("you have no " + arguments[2] + " in your inventory");
        });

    }
}
