package Game;

import Schema.View;
import Util.ViewReader;

import java.awt.geom.Point2D;
import java.util.HashMap;

public class WorldCacher {
    private final ViewReader viewReader;
    private final HashMap<Point2D, View> store = new HashMap<>();

    public WorldCacher(String worldLabel) {
        viewReader = new ViewReader(worldLabel);
    }

    public View getView(double x, double y) {
        View view = store.get(new Point2D.Double(x, y));
        if (view == null) {
            store.put(new Point2D.Double(x,y), viewReader.readView(x,y));
        }
        return store.get(new Point2D.Double(x,y));
    }
}
