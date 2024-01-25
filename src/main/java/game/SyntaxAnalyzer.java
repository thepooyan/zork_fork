package game;

import schema.Action;

public class SyntaxAnalyzer {
    public Action analyzeResponse(String response) {
        System.out.println("analyzing " + response);
       return Action.move;
    }
}
