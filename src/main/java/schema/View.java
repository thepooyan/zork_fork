package schema;
import lombok.Data;
import java.awt.geom.Point2D;

@Data
public class View {
    public View(String storyNote, Point2D coordinates, boolean north, boolean south, boolean east, boolean west) {
        this.storyNote = storyNote;
        this.coordinates = coordinates;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }

    private String storyNote = "nothing!";
    public Point2D coordinates = new Point2D.Double(0,0);
    private Object[] objects;
    private String hiddenNote = "nothing!";
    private boolean north = false;
    private boolean south = false;
    private boolean east = false;
    private boolean west = false;
}
