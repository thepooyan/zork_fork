package Objects;

import Schema.Object;

public interface Lock extends Object {
    boolean lock(Key key);
    boolean unlock(Key key);
    boolean isLocked();
}
