package Views;

import Actions.Direction;
import Objects.Box;
import Schema.Object;
import Schema.View;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class V00 extends View {
    public V00() {
        super(
                "this is story note, there's a box here on the table.",
            new Point2D.Double(0,0),
            new ArrayList<>(List.of(Direction.north))
        );
        Object[] a = {new Box()};
        this.setObjects(a);
        this.setHiddenNote("there is this code written under table: 663");
    }
}
