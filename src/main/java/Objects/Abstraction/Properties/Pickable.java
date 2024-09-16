package Objects.Abstraction.Properties;

import Game.Game;
import Schema.Object;

public interface Pickable extends Object {
    void pickup(Game game);
}
