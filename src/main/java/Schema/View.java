package Schema;
import Enums.Direction;

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
    private List<Object> objects = new ArrayList<>();
    private String hiddenNote = "nothing!";
    private List<Direction> neighbours = new ArrayList<>();

    public String getStoryNote() {
        return storyNote;
    }

    public Point2D getCoordinates() {
        return coordinates;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void addObjects(Object object) {
        this.objects.add(object);
    }

    public String getHiddenNote() {
        return hiddenNote;
    }

    public List<Direction> getNeighbours() {
        return neighbours;
    }

    public void setHiddenNote(String hiddenNote) {
        this.hiddenNote = hiddenNote;
    }
}
