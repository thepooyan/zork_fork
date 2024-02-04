package Game;

import Objects.Pickable;
import Schema.Action;
import Schema.World;
import Util.Prompt;
import Schema.View;
import Util.ViewReader;
import Worlds.World_1;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Prompt prompt = new Prompt();
    private SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer();
    private World currentWorld = new ViewReader("World1");
    private View currentView = currentWorld.getView(0,0);
    private boolean stop = false;
    private List<Pickable> inventory = new ArrayList<>();
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
        action.safeApply(this);
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

    public List<Pickable> getInventory() {
        return inventory;
    }

    private void setInventory(List<Pickable> inventory) {
        this.inventory = inventory;
    }

    public void addToInventory(Pickable item) {
        boolean result = carryWeight.increaseValue(item.getWeight());
        if (result) {
            this.inventory.add(item);
            System.out.println(item + " added to inventory");
        } else {
            System.out.println("cannot pickup, inventory full!\n(drop some items to be able to pick up more)");
        }
    }
    public void dropFromInventory(Pickable item) {
        carryWeight.decreaseValue(item.getWeight());
        List<Pickable> list = getInventory().stream()
                .filter(a -> !a.equals(item)).toList();

        setInventory(list);
    }

    public int getCarryWeight() {
        return carryWeight.getValue();
    }
}