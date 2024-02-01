package Game;

import Actions.*;
import Schema.Action;
import java.util.Arrays;
import java.util.Optional;

public class SyntaxAnalyzer {
    Dictionary dictionary = new Dictionary();
    public Action analyzeResponse(String response) {
       response = response.toLowerCase();
       if (response.trim().equals("")) return new Idol();

       String[] chunks = response.split(" ");
       Optional<Action> optionalAction = searchActions(toCamelCase(chunks[0]));


       if (optionalAction.isPresent()) {
           Action action = optionalAction.get();
                if (chunks.length > 1) {
                    String[] newArray = Arrays.copyOfRange(chunks, 1, chunks.length);
                    action.setChunks(newArray);
                }
           return action;
       }

       Optional<String> actionLabel = dictionary.getActionLabel(chunks[0]);

       if (actionLabel.isEmpty()) {
           return new Unkown(chunks[0]);
       }

       Action action = searchActions(actionLabel.get()).get();
        if (chunks.length > 1) {
            String[] newArray = Arrays.copyOfRange(chunks, 1, chunks.length);
            action.setChunks(newArray);
        }

       return action;

    }
    public Optional<Action> searchActions(String actionLabel) {
        try {
            Class<?> clazz = Class.forName("Actions." + actionLabel);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof Action action) {
                return Optional.of(action);
            }
        } catch (Exception ignored) {}
        return Optional.empty();
    }
    public String toCamelCase(String string) {
        string = string.toLowerCase();
        return string.substring(0,1).toUpperCase().concat(string.substring(1));
    }
}