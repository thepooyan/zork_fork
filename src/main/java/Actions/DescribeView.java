package Actions;

import game.Game;

public class DescribeView implements Action {
    @Override
    public void apply(Game game) {
        game.describeView();
    }
}
