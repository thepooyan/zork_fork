package game;

import Util.Prompt;
import Util.ViewReader;
import schema.Action;
import schema.View;

public class Game {
    private Prompt prompt = new Prompt();
    private SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer();
    private ViewReader viewReader = new ViewReader();
    private View currentView = viewReader.readView(0,0);
    private View[] views;

    public void start() {
        String response = prompt.get(currentView.getStoryNote());
        Action action = syntaxAnalyzer.analyzeResponse(response);
        applyAction(action);
    }

    private void applyAction(Action action) {
        System.out.println("applying action " + action);
    }
}
