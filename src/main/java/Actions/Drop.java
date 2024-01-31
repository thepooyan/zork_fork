package Actions;

import Game.Game;
import Objects.Pickable;
import Schema.Action;
import Schema.Object;

import java.util.List;
import java.util.Optional;

public class Drop extends Action {
    private String item;

    public Drop(String item) {
        this.item = item;
    }

    @Override
    public void apply(Game game) {
        Optional<Pickable> dropping = game
                .getInventory()
                .stream()
                .filter(a -> a.toString().equalsIgnoreCase(this.item))
                .findFirst();
        dropping.ifPresentOrElse(
                a -> {
                    game.dropFromInventory(a);
                    System.out.println("dropped: " + a);
                },
                () -> System.out.println("you haveee no " + this.item)
        );

    }
}
