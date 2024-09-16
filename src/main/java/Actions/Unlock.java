package Actions;

import Game.Game;
import Objects.Abstraction.Properties.Lock;
import Objects.Key;
import Schema.ActionOnObject;
import Schema.Object;
import Util.ObjectChecker;
import java.util.List;
import java.util.Optional;

public class Unlock extends ActionOnObject<Lock> {
    public Unlock() {
        setExpectedArguments(3);
    }

    @Override
    public void applyAction(Lock subject, Game game) {
        if (!arguments[1].equals("with")) {
            System.out.println("unlock with what?");
            return;
        }
        String objectName = arguments[2];
        ObjectChecker objectChecker = new ObjectChecker();

        List<Object> inventory = new java.util.ArrayList<>(game.getInventory().stream().map(f -> (Object) f).toList());
        inventory.addAll(game.getCurrentView().getObjects());
        Optional<Object> objInList = objectChecker.findObjInList(inventory, objectName);

        try {

        objInList.ifPresentOrElse(
                p->{
                    Key cast =(Key) p;
                    subject.unlock(cast);
                },
                ()->{
                    boolean b = objectChecker.objectExists(objectName);
                    if (b)
                        System.out.println("you have no " + objectName + " in your inventory");
                    else
                        System.out.println("what's a \"" + objectName + "\" ?!");
                });
        } catch (Exception e) {
            System.out.println("how should i unlock it with a " + objectName + "?!?");
        }
    }
}
