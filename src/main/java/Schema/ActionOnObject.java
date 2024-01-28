package Schema;
import Game.Game;

public abstract class ActionOnObject<T> {
    abstract public void apply(T t, Game game);
}
