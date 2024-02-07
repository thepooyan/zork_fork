package Objects;

import Game.Game;

import java.util.List;

public class LockedBox extends Box implements Lock {
    private final LockImpl innerLock;
    public LockedBox(List<Pickable> content, String ID) {
        super(content);
        innerLock = new LockImpl(ID);
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
