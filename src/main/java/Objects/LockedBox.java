package Objects;

import Game.Game;
import Objects.Abstraction.impl.Lock;
import Objects.Abstraction.impl.Pickable;

import java.util.List;

public class LockedBox extends Box implements Objects.Abstraction.Properties.Lock {
    private final Lock innerLock;
    public LockedBox(List<Pickable> content, String ID) {
        super(content);
        innerLock = new Lock(ID);
    }

    @Override
    public boolean lock(Key key) {
        return innerLock.lock(key);
    }

    @Override
    public boolean unlock(Key key) {
        return innerLock.unlock(key);
    }

    @Override
    public boolean isLocked() {
        return innerLock.isLocked();
    }

    @Override
    public void open(Game game) {
        if (!innerLock.isLocked()) {
            System.out.println("box is locked!");
            return;
        }
        super.open(game);
    }

    @Override
    public String toString() {
        return "Box";
    }
}
