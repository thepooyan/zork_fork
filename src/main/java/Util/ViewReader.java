package Util;

import Actions.Pick;
import Enums.Direction;
import Objects.Box;
import Objects.Letter;
import Objects.Pickable;
import Schema.Object;
import Schema.World;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import Schema.View;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViewReader implements World {
    private final String viewsFolder;

    public ViewReader(String worldLabel) {
        String viewsFolderBase = "src/main/java/Worlds/";
        this.viewsFolder = viewsFolderBase + worldLabel + "/";
    }
    private String getFileName(double x, double y) {
       return viewsFolder + x + "_" + y + ".xml";
    }

    private String trimXmlIndent(String input) {
        input = input.replaceAll(" +", " ");
        input = input.replaceAll("\n ", "\n");
        return input;
    }

    private List<Object> getObjectsFromNode(Element node) {
        List<Object> objects = new ArrayList<>();

        node.getChildren().forEach(child->{
            switch (child.getName()) {
                case "box" -> {
                    List<Object> innerObjs = getObjectsFromNode(child);
                    List<Pickable> content = new ArrayList<>();
                    innerObjs.forEach(i -> {
                        if (i instanceof Pickable) {
                           content.add((Pickable) i);
                        }
                    });
                    objects.add(new Box(content));
                }
                case "letter" -> {
                    String content = child.getTextTrim();
                    content = trimXmlIndent(content);
                    objects.add(new Letter(content));
                }
                case "key" -> {
                    System.out.println("it's a key");
                }
                case "lock" -> {
                    System.out.println("it's a lock");
                }
            }
        });
        return objects;
    }
    private List<Direction> getPositionNeighbours(double x, double y) {
        List<Direction> neighbours = new ArrayList<>();

        File file1 = new File(getFileName(x-1, y));
        if (file1.exists()) {
            neighbours.add(Direction.west);
        }
        File file2 = new File(getFileName(x+1, y));
        if (file2.exists()) {
            neighbours.add(Direction.east);
        }
        File file3 = new File(getFileName(x, y+1));
        if (file3.exists()) {
            neighbours.add(Direction.north);
        }
        File file4 = new File(getFileName(x, y-1));
        if (file4.exists()) {
            neighbours.add(Direction.south);
        }

        return neighbours;
    }

    @Override
    public View getView(double x, double y) {
        File file = new File(getFileName(x,y));
        SAXBuilder builder = new SAXBuilder();
        try {
            //get root element
            Document document = builder.build(file);
            Element root = document.getRootElement();

            //get story note
            String storyNote = root.getChildTextTrim("story_note");
            storyNote = trimXmlIndent(storyNote);

            //get neighbours
            List<Direction> neighbours = getPositionNeighbours(x, y);

            //get objects
            Element objectsNode = root.getChild("objects");
            List<Object> objects = new ArrayList<>();
            if (objectsNode != null)
                objects = getObjectsFromNode(objectsNode);

            //get hidden massage
            HashMap<String, String> hiddenNote = new HashMap<>();
            Element hiddenNotesNode = root.getChild("hidden_notes");

            if (hiddenNotesNode != null)
                hiddenNotesNode.getChildren().forEach(child -> {
                    hiddenNote.put(
                            child.getAttributeValue("keyword"),
                            trimXmlIndent(child.getTextTrim())
                    );
                });

            return new View(storyNote, new Point2D.Double(x,y), neighbours, objects, hiddenNote);

        } catch (JDOMException | IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
