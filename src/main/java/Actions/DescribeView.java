package Actions;

import game.Game;

public class DescribeView extends Action {
    @Override
    public void apply(Game game) {
        game.describeView();
    }
}
