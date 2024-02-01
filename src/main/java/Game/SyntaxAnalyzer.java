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
       Optional<String> actionLabel = dictionary.getActionLabel(chunks[0]);

       if (actionLabel.isEmpty()) {
           return new Unkown(chunks[0]);
       }

        try {
            Class<?> clazz = Class.forName("Actions." + actionLabel.get());
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