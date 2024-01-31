package Actions;

import Game.Game;
import Schema.Action;

public class Describe extends Action {
    @Override
    public void apply(Game game) {
        game.describeView();
    }
}
