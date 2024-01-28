package Views;

import Schema.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class World {
    private Map<String, View> views = new HashMap<>();
    public World() {
        views.put("00", new V00());
        views.put("01", new V01());
    }

    public View getView(int x, int y) {
       return views.get(Integer.toString(x)+Integer.toString(y));
    }
}
