package Schema;

import Game.Game;
import Util.ObjectChecker;
import java.util.List;
import java.util.Optional;

public class ActionOnObject<O extends Object> extends Action {
    ObjectChecker objectChecker = new ObjectChecker();
    public void applyAction(O subject, Game game) {}
    @Override
    public void apply(Game game) {
        String objectName = arguments[0];

        List<Object> objectList = game.getCurrentView().getObjects();
        objectList.addAll(game.getInventory());
        Optional<Object> objInList = objectChecker.findObjInList(objectList, objectName);

            objInList.ifPresentOrElse(
                    a -> {
                        try {
                            O cast = (O) a;
                            this.applyAction(cast, game);
                        } catch (ClassCastException e) {
                            System.out.println("how should i " + this + " the " + objectName + "?!?! :/");
                        }
                    },
                    ()->{
                        boolean result = objectChecker.objectExists(objectName);
                        if (result) {
                            System.out.println("there is no " + objectName + " here :/");
                        } else {
                            System.out.println("what's a \"" + objectName + "\"?? :))");
                        }
                    }
            );

    }
}
