package Actions;

import Game.Game;
import Schema.Action;

public class Hi extends Action {
    @Override
    public void apply(Game game) {
        System.out.println("Hi " + game.username + "!");
    }
}
