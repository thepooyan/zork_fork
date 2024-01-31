package Actions;

import Game.Game;
import Objects.Pickable;
import Schema.Action;
import Schema.Object;

import java.util.ArrayList;
import java.util.List;

public class InventoryQuery extends Action {
    @Override
    public void apply(Game game) {
        List<Pickable> inventory = game.getInventory();
        if (inventory.size() == 0) {
            System.out.println("inventory empty!");
        } else {
            System.out.print("inventory items: ");
            System.out.println(inventory);
        }
    }
}
