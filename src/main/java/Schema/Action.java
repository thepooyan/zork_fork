package Schema;
import Game.Game;

import java.util.Arrays;

public abstract class Action {
    protected String[] arguments = {};
    private int expectedArgumnets = 0;
    private boolean isMininmum = false;


    public Action() {}

    public abstract void apply(Game game);
    public void safeApply(Game game) {
        if (notEnoughArguments()) return;
        apply(game);
    }

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }

    public void setExpectedArguments(int expectedArguments) {
        this.expectedArgumnets = expectedArguments;
        isMininmum = false;
    }

    public void setMinimumExpectedArguments(int minimumExpectedArguments) {
        this.expectedArgumnets = minimumExpectedArguments;
        isMininmum = true;
    }

    public boolean notEnoughArguments() {
        if (isMininmum) {
           if (Arrays.stream(arguments).count() < expectedArgumnets) {
               System.out.println("you need to use " + this + " with at least " + expectedArgumnets + " arguments.");
               return true;
           }
        } else {
            if (Arrays.stream(arguments).count() != expectedArgumnets) {
               System.out.println("you need to use " + this + " with " + expectedArgumnets + " arguments.");
               return true;
           }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().toLowerCase();
    }
}