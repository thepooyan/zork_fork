package Actions;

import Game.Game;
import Schema.Action;

public class Unkown extends Action {
    private String actionS;
    public Unkown(String actionS) {
        this.actionS = actionS;

    }
    @Override
    public void apply(Game game) {
        System.out.println("i don't know what \"" + actionS + "\" is!");
    }
}
