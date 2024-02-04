package Schema;
import Game.Game;

import java.util.Arrays;

public abstract class Action {
    protected String[] arguments = {};
    protected int expectedArgumnets = 0;

    public Action() {}

    public abstract void apply(Game game);
    public void safeApply(Game game) {
        if (notEnoughArguments()) return;
        apply(game);
    }

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }

    public void setExpectedArgumnets(int expectedArgumnets) {
        this.expectedArgumnets = expectedArgumnets;
    }

    public boolean notEnoughArguments() {
        if (Arrays.stream(arguments).count() != expectedArgumnets) {
            System.out.println("you need to use " + this + " with " + expectedArgumnets + " arguments.");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().toLowerCase();
    }
}