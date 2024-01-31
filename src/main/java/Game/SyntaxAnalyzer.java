package Game;

import Actions.*;
import Schema.Action;
import java.util.Arrays;

public class SyntaxAnalyzer {
    Dictionary dictionary = new Dictionary();
    public Action analyzeResponse(String response) {
       response = response.toLowerCase();
       if (response.trim().equals("")) return new Idol();

       String[] chunks = response.split(" ");
       String actionLabel = dictionary.getActionLabel(chunks[0]);

       if (actionLabel == null) {
           return new Unkown(chunks[0]);
       }
       String className = actionLabel.substring(0, 1).toUpperCase().concat(actionLabel.substring(1));

        try {
            Class<?> clazz = Class.forName("Actions." + className);
            Object instance = clazz.getDeclaredConstructor().newInstance();

            if (instance instanceof Action action) {

                if (chunks.length > 1) {
                    String[] newArray = Arrays.copyOfRange(chunks, 1, chunks.length);
                    action.setChunks(newArray);
                }

                return action;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Idol();
    }
}