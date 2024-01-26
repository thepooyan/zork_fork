package game;

import schema.Action;
import Util.Prompt;
import Util.ViewReader;
import schema.View;

public class Game {
    public Prompt prompt = new Prompt();
    public SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer();
    public ViewReader viewReader = new ViewReader();
    private View currentView = viewReader.readView(0,0);

    public void start() {
        describeView();
        gameLoop();
    }

    public void gameLoop() {
        String response = prompt.get("=> ");
        Action action = syntaxAnalyzer.analyzeResponse(response);
        action.apply(this);
        gameLoop();
    }

    public View getCurrentView() {
        return currentView;
    }

    public void setCurrentView(View currentView) {
        this.currentView = currentView;
    }

    public void describeView() {
        System.out.println(this.currentView.getStoryNote());
    }
}
