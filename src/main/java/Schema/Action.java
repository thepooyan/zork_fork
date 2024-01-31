package Schema;
import Game.Game;

import java.util.Arrays;

public abstract class Action {
    protected String[] chunks;

    public Action() {}

    public abstract void apply(Game game);

    public void setChunks(String[] chunks) {
        this.chunks = chunks;
    }

    public boolean countChunksNot(int count) {
        if (chunks == null) return true;
        return Arrays.stream(chunks).count() != count;
    }
}
