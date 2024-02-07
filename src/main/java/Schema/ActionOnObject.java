package Schema;

import Game.Game;
import Util.ObjectChecker;
import java.util.List;
import java.util.Optional;

public class ActionOnObject<O extends Object> extends Schema.Action {
    ObjectChecker objectChecker = new ObjectChecker();
    public void applyAction(O a, Game game) {}
    @Override
    public void apply(Game game) {
        String objectName = arguments[0];

        try {
            List<Object> objectList = game.getCurrentView().getObjects();
            Optional<Object> objInList = objectChecker.findObjInList(objectList, objectName);

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
            System.out.println("how should i " + this.getClass().getSimpleName() + " the " + objectName + "?!?! :/");
        }
    }
}
