package game;

import Util.Prompt;
import Util.ViewReader;
import schema.Action;
import schema.View;

public class Game {
    private Prompt prompt = new Prompt();
    private SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer();
    private View currentView;
    private View[] views;
    private final String viewsFolder = "src/main/java/views/";

    public void start() {
//        String response = prompt.get("hello => ");
//        Action action = syntaxAnalyzer.analyzeResponse(response);
//        applyAction(action);
        View view = new ViewReader().readView(0,0);
        System.out.println(view);
    }

    private void applyAction(Action action) {
        System.out.println("applying action " + action);
    }
}
