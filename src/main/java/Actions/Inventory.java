package Actions;

import Game.Game;
import Objects.Pickable;
import Schema.Action;

import java.util.List;

public class Inventory extends Action {
    @Override
    public void apply(Game game) {
        List<Pickable> inventory = game.getInventory();
        System.out.println("carry weight: " + game.getCarryWeight());
        if (inventory.size() == 0) {
            System.out.println("inventory empty!");
        } else {
            System.out.print("inventory items: ");
            System.out.println(inventory);
        }
    }
}
