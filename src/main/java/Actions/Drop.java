package Actions;

import Game.Game;
import Objects.Pickable;
import Schema.Action;

import java.util.Optional;

public class Drop extends Action {
    public Drop() {
        setExpectedArguments(1);
    }
    @Override
    public void apply(Game game) {

        Optional<Pickable> dropping = game
                .getInventory()
                .stream()
                .filter(a -> a.toString().equalsIgnoreCase(this.arguments[0]))
                .findFirst();
        dropping.ifPresentOrElse(
                a -> {
                    game.dropFromInventory(a);
                    System.out.println("dropped: " + a);
                },
                () -> System.out.println("you have no " + this.arguments[0])
        );

    }
}
