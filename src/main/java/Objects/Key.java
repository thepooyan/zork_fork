package Objects;

public class Key extends Pickable {
    private final String ID;
    public Key(String ID) {
        super(2);
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }
}
