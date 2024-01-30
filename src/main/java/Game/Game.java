package Game;

import Objects.Pickable;
import Schema.Action;
import Schema.Object;
import Util.Prompt;
import Schema.View;
import Schema.World;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Prompt prompt = new Prompt();
    private SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer();
    private World currentWorld = new World();
    private View currentView = currentWorld.getView(0,0);
    private boolean stop = false;
    private List<Object> inventory = new ArrayList<>();
    private CarryWeight carryWeight = new CarryWeight(100);

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

    public World getCurrentWorld() {
        return currentWorld;
    }

    public List<Object> getInventory() {
        return inventory;
    }

    public void addToInventory(Pickable inventory) {
        boolean result = carryWeight.increaseValue(inventory.getWeight());
        if (result) {
            this.inventory.add(inventory);
            System.out.println(inventory.getClass().getSimpleName() + " added to inventory");
        } else {
            System.out.println("cannot pickup, inventory full!\n(drop some items to be able to pick up more)");
        }
    }
}