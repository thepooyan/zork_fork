package Schema;

import Game.Game;

import java.util.Arrays;
import java.util.Optional;

public class ActionOnObject<O extends Object> extends Schema.Action {
    public void applyAction(O a, Game game) {}
    @Override
    public void apply(Game game) {
        if (countChunksNot(1)) {
            System.out.println("open what?!?");
            return;
        }
        String objectName = chunks[0];

        try {
            Optional<O> object = game.getCurrentView()
                    .getObjects()
                    .stream()
                    .filter(a -> a.toString().equalsIgnoreCase(objectName))
                    .map(a -> (O) a)
                    .findFirst(); //cannot handle more than one action at a view
            object.ifPresentOrElse(
                    a -> { this.applyAction(a, game); },
                    ()->{
                        try {
                            String a = objectName.toLowerCase();
                            Class.forName("Objects" + "." + a.substring(0,1).toUpperCase() + a.substring(1));
                            System.out.println("there is no " + objectName + " here :/");
                        } catch (ClassNotFoundException e) {
                            System.out.println("what's a \"" + objectName + "\"?? :))");
                        }
                    }
            );

        } catch (Exception e) {
            System.out.println("how should i " + this.getClass().getSimpleName() + " the " + objectName + "?!?! :/");
        }
    }
}
