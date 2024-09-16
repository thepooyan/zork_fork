package Objects.Abstraction.Properties;

import Objects.Key;
import Schema.Object;

public interface Lockable extends Object {
    boolean lock(Key key);
    boolean unlock(Key key);
    boolean isLocked();
}
