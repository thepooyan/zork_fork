package Schema;
import Enums.Direction;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class View {
    public View(String storyNote, Point2D coordinates, List<Direction> neighbours) {
        this.storyNote = storyNote;
        this.coordinates = coordinates;
        this.neighbours = neighbours;
    }
    public View(String storyNote, Point2D coordinates, List<Direction> neighbours, List<Object> objects) {
        this.storyNote = storyNote;
        this.coordinates = coordinates;
        this.neighbours = neighbours;
        this.objects = objects;
    }
    public View(String storyNote, Point2D coordinates, List<Direction> neighbours, List<Object> objects, HashMap<String, String> hiddenNote) {
        this.storyNote = storyNote;
        this.coordinates = coordinates;
        this.neighbours = neighbours;
        this.objects = objects;
        this.hiddenNote = hiddenNote;
    }

    private String storyNote = "nothing!";
    public Point2D coordinates = new Point2D.Double(0,0);
    private List<Object> objects = new ArrayList<>();
    private List<Direction> neighbours = new ArrayList<>();
    private HashMap<String, String> hiddenNote = new HashMap<>();

    public String getStoryNote() {
        return storyNote;
    }

    public Point2D getCoordinates() {
        return coordinates;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void addObject(Object object) {
        this.objects.add(object);
    }

    public Optional<String> getHiddenNote(String keyword) {
        if (hiddenNote.containsKey(keyword))
            return Optional.of(hiddenNote.get(keyword));
        return Optional.empty();
    }

    public List<Direction> getNeighbours() {
        return neighbours;
    }
}
