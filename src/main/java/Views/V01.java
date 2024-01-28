package Views;

import Enums.Direction;
import Schema.View;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class V01 extends View {
    public V01() {
        super(
                "you reach a door.",
            new Point2D.Double(0,1),
            new ArrayList<>(List.of(Direction.east))
        );
        this.setHiddenNote("the door is locked;");
    }
}
