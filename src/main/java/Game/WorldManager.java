package Game;

import Schema.View;
import Schema.World;
import Util.ViewReader;

public class WorldManager implements World {
    private final ViewReader viewReader;
    public WorldManager(String worldLabel) {
        viewReader = new ViewReader(worldLabel);
    }

    @Override
    public View getView(double x, double y) {
        return viewReader.readView(x, y);
    }
}
