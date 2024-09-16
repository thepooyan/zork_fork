package Schema;
import Game.Game;

import java.util.Arrays;

public abstract class Action {
    protected String[] arguments = {};
    private boolean hasExpectedArguments = false;
    private int expectedArguments = 0;
    private boolean hasMinimumExpectedArguments = false;
    private int minimumExpectedArguments = 0;


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
        this.expectedArguments = expectedArguments;
        this.hasExpectedArguments = true;
    }

    public void setMinimumExpectedArguments(int minimumExpectedArguments) {
        this.minimumExpectedArguments = minimumExpectedArguments;
        this.hasMinimumExpectedArguments = true;
    }

    public boolean notEnoughArguments() {
        if (hasExpectedArguments) {
            if (Arrays.stream(arguments).count() != expectedArguments) {
                System.out.println("you need to use " + this + " with " + expectedArguments + " arguments.");
                return true;
            }
        } else if (hasMinimumExpectedArguments) {
            if (Arrays.stream(arguments).count() < minimumExpectedArguments) {
                System.out.println("you need to use " + this + " with at least " + minimumExpectedArguments + " arguments.");
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