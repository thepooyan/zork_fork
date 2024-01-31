package Actions;

import Game.Game;
import Schema.Action;

public class Clear extends Action {

    @Override
    public void apply(Game game) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
