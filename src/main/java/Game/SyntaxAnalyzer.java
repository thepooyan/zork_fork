package Game;

import Actions.*;
import Schema.Action;
import java.util.Arrays;
import java.util.Optional;

public class SyntaxAnalyzer {
    private final Dictionary dictionary = new Dictionary("src/main/java/Dict/Dict.json");
    public Action analyzeResponse(String response) {

       response = response.toLowerCase();
       if (response.trim().isEmpty()) return new Idol();

       String[] chunks = response.split(" ");
       Optional<Action> optionalAction = searchActions(chunks[0]);

       if (optionalAction.isPresent()) {
           Action action = optionalAction.get();
           return prepareAction(action, chunks);
       }

       Optional<String> actionLabel = dictionary.getActionLabel(chunks[0]);

       if (actionLabel.isPresent()) {
           String[] actionLabelParts = actionLabel.get().split(" ");
           //if there are more than one word in it, it is an alias
           Action action = searchActions(actionLabelParts[0]).get();
           if (actionLabelParts.length > 1) chunks = actionLabelParts;
           return prepareAction(action, chunks);
       }

        return new Unkown(chunks[0]);
    }
    private Optional<Action> searchActions(String actionLabel) {
        actionLabel = toCamelCase(actionLabel);
        try {
            Class<?> clazz = Class.forName("Actions." + actionLabel);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof Action action) {
                return Optional.of(action);
            }
        } catch (Exception ignored) {}
        return Optional.empty();
    }
    private String toCamelCase(String string) {
        string = string.toLowerCase();
        return string.substring(0,1).toUpperCase().concat(string.substring(1));
    }
    private Action prepareAction(Action action, String[] chunks) {
        if (chunks.length > 1) {
            String[] newArray = Arrays.copyOfRange(chunks, 1, chunks.length);
            action.setArguments(newArray);
        }
        return action;
    }
}