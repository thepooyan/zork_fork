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
        Optional<Object> objInList = objectChecker.findObjInList(objectList, objectName);

        try {
            objInList.ifPresentOrElse(
                    a -> {
                        this.applyAction((O) a, game);
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

        } catch (Exception e) {
            System.out.println("how should i " + this + " the " + objectName + "?!?! :/");
        }
    }
}
