package Actions;

import Game.Game;
import Schema.Action;

public class Exit extends Action {
    @Override
    public void apply(Game game) {
        System.out.println("end signal...");
        game.end();
    }
}
