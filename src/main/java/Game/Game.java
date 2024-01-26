package Game;

import Schema.Action;
import Util.Prompt;
import Util.ViewReader;
import Schema.View;

public class Game {
    public Prompt prompt = new Prompt();
    public SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer();
    public ViewReader viewReader = new ViewReader();
    private View currentView = viewReader.readView(0,0);
    private boolean stop = false;

    public void start() {
        describeView();
        gameLoop();
    }

    public void end() {
         this.stop = true;
    }

    public void gameLoop() {
        String response = prompt.get("=> ");
        Action action = syntaxAnalyzer.analyzeResponse(response);
        action.apply(this);
        if (stop) return;
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
