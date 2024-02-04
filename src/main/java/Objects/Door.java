package Objects;

import Game.Game;
import Schema.Object;
import Schema.View;
import java.awt.geom.Point2D;

public class Door implements Object {
    private final String ID;
    private final Point2D destination;
    private boolean isOpen = true;

    public Door(String ID, Point2D destination) {
        this.ID = ID;
        this.destination = destination;
    }

    public Door(String ID, Point2D destination, boolean isOpen) {
        this.ID = ID;
        this.destination = destination;
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

    public void enter(Game game) {
        if (!isOpen) {
            System.out.println("door locked");
            return;
        }
        View innerView = game.getCurrentWorld().getView(destination.getX(), destination.getY());
        game.setCurrentView(innerView);
        System.out.println("you enter the door.");
    }
}
