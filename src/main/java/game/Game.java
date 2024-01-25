package game;

import Actions.Action;
import Util.Prompt;
import Util.ViewReader;
import schema.View;

public class Game {
    public Prompt prompt = new Prompt();
    public SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer();
    public ViewReader viewReader = new ViewReader();
    private View currentView = viewReader.readView(0,0);

    public void start() {
        String response = prompt.get(currentView.getStoryNote());
        Action action = syntaxAnalyzer.analyzeResponse(response);
        action.apply(this);
        start();
    }

    public View getCurrentView() {
        return currentView;
    }

    public void setCurrentView(View currentView) {
        this.currentView = currentView;
    }
}
