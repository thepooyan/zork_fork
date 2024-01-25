package schema;

import java.awt.geom.Point2D;

public abstract class View {

    public String storyNote = "nothing!";
    public Point2D coordinates = new Point2D.Double(0,0);
    public Object[] objects = null;
    public String hiddenNote = "nothing!";
    public View north;
    public View south;
    public View east;
    public View west;

}
