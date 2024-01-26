package Actions;

import game.Game;
import schema.Action;

public class DescribeView extends Action {
    @Override
    public void apply(Game game) {
        game.describeView();
    }
}
