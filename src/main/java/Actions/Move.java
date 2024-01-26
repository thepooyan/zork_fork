package Actions;

import Util.ViewReader;
import Game.Game;
import Schema.Action;
import Schema.View;

import java.awt.geom.Point2D;

public class Move extends Action {
    public Direction direction;

    public Move(Direction direction) {
        this.direction = direction;
    }
    @Override
    public void apply(Game game) {
        if (direction == null) {
            System.out.println("moving to where?!?");
            return;
        }
        if (!game.getCurrentView().getNeighbours().contains(direction)) {
            System.out.println("there is no path there!");
            return;
        }
        Point2D dest = new Point2D.Double(0,0);
        Point2D coordinates = game.getCurrentView().getCoordinates();
        switch (direction) {
            case east:
                dest = new Point2D.Double(coordinates.getX()+1, coordinates.getY());
                break;
            case west:
                dest = new Point2D.Double(coordinates.getX()-1, coordinates.getY());
                break;
            case north:
                dest =  new Point2D.Double(coordinates.getX(), coordinates.getY()+1);
                break;
            case south:
                dest =  new Point2D.Double(coordinates.getX(), coordinates.getY()-1);
                break;
        }
        ViewReader viewReader = new ViewReader();
        View newView = viewReader.readView((int) dest.getX(), (int) dest.getY());
        game.setCurrentView(newView);
        System.out.println("moving to " + direction);
        game.describeView();
    }
}
