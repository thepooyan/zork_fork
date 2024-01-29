package Schema;

import Game.Game;
import Objects.ObjectWithAction;
import java.util.Arrays;
import java.util.Optional;

public class ObjectActions<Actionable extends ObjectWithAction> extends Schema.Action {
    private String actionLabel;
    private String objectName;
    public void transform(Actionable a, Game game) {

    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public ObjectActions(String objectName) {
        this.objectName = objectName;
    }
    @Override
    public void apply(Game game) {
        try {
            Optional<Actionable> object = Arrays.stream(game.getCurrentView().getObjects())
                    .filter(a -> a.getClass().getSimpleName().equalsIgnoreCase(objectName))
                    .map(a -> (Actionable) a)
                    .findFirst(); //cannot handle more than one action at a view
            object.ifPresentOrElse(
                    a -> { this.transform(a, game); },
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
            System.out.println("how should i " + actionLabel + " the " + objectName + "?!?! :/");
        }
    }
}