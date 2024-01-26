package Schema;

import Game.Game;

public abstract class Action {
    public abstract void apply(Game game);
    public Action() {

    }
}
