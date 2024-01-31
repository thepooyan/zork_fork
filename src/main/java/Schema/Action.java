package Schema;
import Game.Game;

import java.util.Arrays;

public abstract class Action {
    protected String[] chunks = {};

    public Action() {}

    public abstract void apply(Game game);

    public void setChunks(String[] chunks) {
        this.chunks = chunks;
    }

    public boolean countChunksNot(int count) {
        if (chunks == null | Arrays.stream(chunks).count() != count) {
            System.out.println(this + " what?!?");
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName().toLowerCase();
    }
}