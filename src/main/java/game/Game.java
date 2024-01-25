package game;

import Util.Prompt;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import schema.Action;
import schema.View;
import views.View0_0;

import java.io.File;
import java.io.IOException;

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
        readViews();
    }

    private void applyAction(Action action) {
        System.out.println("applying action " + action);
    }

    private void readViews() {

    }
}
