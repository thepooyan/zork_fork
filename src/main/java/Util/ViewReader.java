package Util;

import Actions.Direction;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import schema.View;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewReader {
    private final static String viewsFolder = "src/main/java/views/";

    public View readView(int x, int y) {
        File file = new File(viewsFolder + x + "-" + y + ".xml");
        SAXBuilder builder = new SAXBuilder();
        try {
            Document document = builder.build(file);
            Element root = document.getRootElement();
            String storyNote = root.getChildTextTrim("story_note");
            List<Direction> neighbours = new ArrayList<>();
            Element route = root.getChild("route");
            if (route.getChildTextTrim("north").equals("1")) {
                neighbours.add(Direction.north);
            }
            if (route.getChildTextTrim("south").equals("1")) {
                neighbours.add(Direction.south);
            }
            if (route.getChildTextTrim("east").equals("1")) {
                neighbours.add(Direction.east);
            }
            if (route.getChildTextTrim("west").equals("1")) {
                neighbours.add(Direction.west);
            }

            return new View(storyNote, new Point2D.Double(x,y), neighbours);
        } catch (JDOMException | IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
