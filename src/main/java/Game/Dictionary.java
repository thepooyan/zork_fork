package Game;

import java.util.*;

public class Dictionary {

    public Map<Integer, String> actions = new HashMap<>();
    public Map<String, Integer> maps = new HashMap<>();

    public Dictionary() {
        actions.put(0, "move");
        maps.put("move", 0);
        maps.put("go", 0);
        maps.put("travel", 0);

        actions.put(1, "describe");
        maps.put("describe", 1);
        maps.put("tell", 1);
    }
}