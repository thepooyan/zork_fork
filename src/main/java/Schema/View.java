package Schema;
import Actions.Direction;
import lombok.Data;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class View {
    public View(String storyNote, Point2D coordinates, List<Direction> neighbours) {
        this.storyNote = storyNote;
        this.coordinates = coordinates;
        this.neighbours = neighbours;
    }

    private String storyNote = "nothing!";
    public Point2D coordinates = new Point2D.Double(0,0);
    private Object[] objects;
    private String hiddenNote = "nothing!";
    private List<Direction> neighbours = new ArrayList<>();

    public String getStoryNote() {
        return storyNote;
    }

    public Point2D getCoordinates() {
        return coordinates;
    }

    public Object[] getObjects() {
        return objects;
    }

    public String getHiddenNote() {
        return hiddenNote;
    }

    public List<Direction> getNeighbours() {
        return neighbours;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public void setHiddenNote(String hiddenNote) {
        this.hiddenNote = hiddenNote;
    }
}
