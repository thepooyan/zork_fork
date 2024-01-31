package Actions;

import Game.Game;
import Objects.Pickable;
import Schema.Action;

import java.util.Optional;

public class Drop extends Action {
    @Override
    public void apply(Game game) {
        if (countChunksNot(1)) return;

        Optional<Pickable> dropping = game
                .getInventory()
                .stream()
                .filter(a -> a.toString().equalsIgnoreCase(this.chunks[0]))
                .findFirst();
        dropping.ifPresentOrElse(
                a -> {
                    game.dropFromInventory(a);
                    System.out.println("dropped: " + a);
                },
                () -> System.out.println("you have no " + this.chunks[0])
        );

    }
}
