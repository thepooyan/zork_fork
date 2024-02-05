package Objects;

public interface Lock {
    boolean lock(Key key);
    boolean open(Key key);
    boolean isOpen();
}
