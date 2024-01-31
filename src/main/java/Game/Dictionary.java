package Game;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.*;

public class Dictionary {
    private final Map<Integer, String> actions = new HashMap<>();
    private final Map<String, Integer> maps = new HashMap<>();

    public Dictionary() {
        File dict = new File("src/main/java/Dict/Dict.json");

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(dict);

            List<String> keysList = new ArrayList<>();
            jsonNode.fieldNames().forEachRemaining(keysList::add);

            for (int i = 0; i < keysList.size(); i++) {
                String node = keysList.get(i);
                JsonNode namesArray = jsonNode.get(node);
                actions.put(i, node);
                maps.put(node, i);
                int finalI = i;
                namesArray.forEach(inner -> {
                    maps.put(inner.asText(), finalI);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String getActionLabel(String input) {
        Integer actionID = maps.get(input);
        String action = actions.get(actionID);
        return action.substring(0,1).toUpperCase().concat(action.substring(1).toLowerCase());
    }
}
