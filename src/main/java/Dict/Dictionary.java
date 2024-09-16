package Dict;
import Util.JsonReader;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.*;

public class Dictionary {
        private final Map<String, String> actions_aliases = new HashMap<>();

        public Dictionary(String src) {
                try {
                        JsonNode rootNode = new JsonReader(src).getJsonData();
                        parseJsonToMap(rootNode);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        private void parseJsonToMap(JsonNode rootNode) {
                List<String> keysList = new ArrayList<>();
                rootNode.fieldNames().forEachRemaining(keysList::add);

                for (String actionLabel : keysList) {
                        JsonNode aliasesArray = rootNode.get(actionLabel);

                        actions_aliases.put(actionLabel, actionLabel);
                        aliasesArray.forEach(alias -> actions_aliases.put(alias.asText(), actionLabel));
                }
        }

        public Optional<String> getActionLabel(String input) {
                if (actions_aliases.get(input) == null) return Optional.empty();
                return Optional.of(capitalizeActionLabel(actions_aliases.get(input)));
        }

        private String capitalizeActionLabel(String action) {
                return action.substring(0, 1).toUpperCase() + action.substring(1).toLowerCase();
        }
}