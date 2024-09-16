package Game;

import Objects.Abstraction.impl.Pickable;
import Schema.Action;
import Util.Prompter;
import Schema.View;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Prompter prompter = new Prompter();
    private final SyntaxAnalyzer syntaxAnalyzer = new SyntaxAnalyzer();
    private final CarryWeight carryWeight = new CarryWeight(100);
    private final List<Pickable> inventory = new ArrayList<>();
    private final WorldCacher currentWorld;
    private final String username;
    private View currentView;
    private boolean stop = false;

    public Game(String username, String worldName) {
        this.username = username;
        this.currentWorld = new WorldCacher(worldName);
        this.currentView = currentWorld.getView(0,0);
    }

    public void start() {
        describeView();
        gameLoop();
    }

    public String getUsername() {
        return username;
    }

    public void end() {
         this.stop = true;
    }

    public void gameLoop() {
        String response = prompter.prompt("=> ");
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
        this.currentView.getObjects().forEach(object -> {
            System.out.println( object.getDescription() );
        });
    }

    public WorldCacher getCurrentWorld() {
        return currentWorld;
    }

    public List<Pickable> getInventory() {
        return inventory;
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
        getInventory().remove(item);
    }

    public int getCarryWeight() {
        return carryWeight.getValue();
    }
}