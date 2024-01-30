package Views;

import Enums.Direction;
import Objects.Letter;
import Schema.Object;
import Schema.View;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class V01 extends View {
    public V01() {
        super(
                "you reach a door. there's a letter",
            new Point2D.Double(0,1),
            new ArrayList<>(List.of(Direction.east))
        );
        this.addObjects(new Letter("this is the letter itself"));
        this.setHiddenNote("the door is locked;");
    }
}
