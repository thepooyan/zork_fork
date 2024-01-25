package game;

import Actions.Action;
import Util.Prompt;
import Util.ViewReader;
import schema.View;

public class Game {
    public Prompt prompt = new Prompt();
    public SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer();
    public ViewReader viewReader = new ViewReader();
    public View currentView = viewReader.readView(0,0);

    public void start() {
        String response = prompt.get(currentView.getStoryNote());
        Action action = syntaxAnalyzer.analyzeResponse(response);
        action.apply(this);
        start();
    }

    private void applyAction(Action action) {
        System.out.println("applying action " + action);
    }
}
