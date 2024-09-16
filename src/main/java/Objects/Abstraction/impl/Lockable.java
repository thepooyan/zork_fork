package Objects.Abstraction.impl;

import Objects.Key;
import Schema.ObjectImpl;

public class Lockable extends ObjectImpl implements Objects.Abstraction.Properties.Lockable {
    private final String ID;
    private boolean isOpen = false;

    public Lockable(String ID, String desc) {
        super(desc);
        this.ID = ID;
    }

    public boolean unlock(Key key) {
        if (isOpen) {
            System.out.println("Already open");
            return true;
        }

       isOpen = key.getID().equals(this.ID);
       if (isOpen)
           System.out.println("lock opened!");
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

    public boolean isLocked() {
        return isOpen;
    }
}
