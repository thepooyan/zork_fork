package Game;

import Schema.View;
import Schema.World;
import Util.ViewReader;

import java.awt.geom.Point2D;
import java.util.HashMap;

public class WorldManager implements World {
    private final ViewReader viewReader;
    private HashMap<Point2D, View> store = new HashMap<>();
    public WorldManager(String worldLabel) {
        viewReader = new ViewReader(worldLabel);
    }

    @Override
    public View getView(double x, double y) {
        View view = store.get(new Point2D.Double(x, y));
        if (view == null) {
            store.put(new Point2D.Double(x,y), viewReader.readView(x,y));
        }
        return store.get(new Point2D.Double(x,y));
    }
}
