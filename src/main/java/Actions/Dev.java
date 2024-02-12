package Actions;

import Game.Game;
import Schema.Action;

public class Dev extends Action {
    @Override
    public void apply(Game game) {
        System.out.println(game.getCurrentView().getObjects());
    }
}
