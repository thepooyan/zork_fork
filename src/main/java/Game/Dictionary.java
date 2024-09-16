package Game;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.*;

public class Dictionary {
        private final Map<Integer, String> actions = new HashMap<>();
        private final Map<String, Integer> aliases = new HashMap<>();

        public Dictionary(String src) {
                File dictFile = new File(src);
                ObjectMapper objectMapper = new ObjectMapper();

                try {
                        JsonNode rootNode = objectMapper.readTree(dictFile);
                        parseJsonToMaps(rootNode);
                } catch (Exception e) {
                        e.printStackTrace();
                }
        }

        private void parseJsonToMaps(JsonNode rootNode) {
                List<String> keysList = new ArrayList<>();
                rootNode.fieldNames().forEachRemaining(keysList::add);

                for (int i = 0; i < keysList.size(); i++) {
                        String actionLabel = keysList.get(i);
                        JsonNode aliasesArray = rootNode.get(actionLabel);

                        // Store action with its index
                        actions.put(i, actionLabel);
                        aliases.put(actionLabel, i);

                        // Map related names (if any) to the same index
                        // Lambda requires 'i' to be final, so we declare it as a final variable
                        final int index = i;
                        aliasesArray.forEach(name -> aliases.put(name.asText(), index));
                }
        }

        public Optional<String> getActionLabel(String input) {
                return Optional.ofNullable(aliases.get(input))
                        .map(actions::get)
                        .map(this::capitalizeActionLabel);
        }

        private String capitalizeActionLabel(String action) {
                return action.substring(0, 1).toUpperCase() + action.substring(1).toLowerCase();
        }
}