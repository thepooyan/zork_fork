package Actions;

import Game.Game;
import Schema.Action;

public class DescribeView extends Action {
    @Override
    public void apply(Game game) {
        game.describeView();
    }
}
