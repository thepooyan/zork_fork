package Actions;


import Game.Game;
import Objects.Pickable;
import Schema.ObjectActions;

public class Pick extends ObjectActions<Pickable> {
    public Pick(String objectName) {
        super(objectName);
        setActionLabel("pick");
    }


    @Override
    public void transform(Pickable a, Game game) {
        a.pickup(game);
    }
}
