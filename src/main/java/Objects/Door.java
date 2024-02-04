package Objects;

import Schema.Object;

public class Door implements Object {
    private final String ID;
    private boolean isOpen = true;

    public Door(String ID) {
        this.ID = ID;
    }

    public Door(String ID, boolean isOpen) {
        this.ID = ID;
        this.isOpen = isOpen;
    }

    public boolean open(Key key) {
        if (isOpen) {
            System.out.println("Already open");
            return true;
        }

       isOpen = key.getID().equals(this.ID);
       if (isOpen)
           System.out.println("door opened!");
       else
           System.out.println("wrong key");

       return isOpen;
    }

    public boolean lock(Key key) {
        if (!isOpen) {
            System.out.println("Already locked");
            return true;
        }

        isOpen = !key.getID().equals(this.ID);
        if (!isOpen)
            System.out.println("locked");
        else
            System.out.println("wrong key");

        return !isOpen;
    }
}
