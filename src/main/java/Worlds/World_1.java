package Worlds;

import Enums.Direction;
import Objects.Box;
import Objects.Letter;
import Schema.View;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World_1 implements Schema.World {
    private final Map<String, View> views = new HashMap<>();
    public World_1() {
        views.put("00", new View(
                "there's a box here on the table",
                new Point2D.Double(0,0),
                List.of(Direction.north, Direction.east),
                List.of(new Box(new Letter("this is letter"))),
                "a code written under the table: 663"
              ));
        views.put("01", new View(
                "you reach a door, there's a letter",
                new Point2D.Double(0,1),
                List.of(Direction.south),
                List.of(new Letter("shout the code")),
                "door is locked"
        ));
        views.put("10", new View(
                "slsls", new Point2D.Double(1,0), List.of(Direction.west)
        ));
    }

    @Override
    public View getView(int x, int y) {
       return views.get(Integer.toString(x)+Integer.toString(y));
    }
}
