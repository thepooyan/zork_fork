package Objects.Abstraction.impl;

import Objects.Key;

public class Lock implements Objects.Abstraction.Properties.Lock {
    private final String ID;
    private boolean isOpen = false;

    public Lock(String ID) {
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
