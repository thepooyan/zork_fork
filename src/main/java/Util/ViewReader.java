package Util;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import schema.View;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;

public class ViewReader {
    private final static String viewsFolder = "src/main/java/views/";

    public View readView(int x, int y) {
        File file = new File(viewsFolder + x + "-" + y + ".xml");
        SAXBuilder builder = new SAXBuilder();
        try {
            Document document = builder.build(file);
            Element root = document.getRootElement();
            String storyNote = root.getChildTextTrim("story_note");
            boolean north=false, ease=false, west=false, south=false;
            Element route = root.getChild("route");
            if (route.getChildTextTrim("north").equals("1")) {
                north = true;
            }
            if (route.getChildTextTrim("south").equals("1")) {
                south = true;
            }
            if (route.getChildTextTrim("east").equals("1")) {
                ease = true;
            }
            if (route.getChildTextTrim("west").equals("1")) {
                west = true;
            }
            System.out.println(storyNote);

            return new View(storyNote, new Point2D.Double(x,y), north,south,ease,west);
        } catch (JDOMException | IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
