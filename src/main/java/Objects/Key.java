package Objects;

import Objects.Abstraction.impl.Pickable;

public class Key extends Pickable {
    private final String ID;
    public Key(String ID, String desc) {
        super(2, desc);
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }
}
