package Objects;

import Game.Game;
import Schema.Object;

public interface ObjectWithAction extends Object {
    void action(Game game);
}
