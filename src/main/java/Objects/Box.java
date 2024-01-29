package Objects;

import Game.Game;
import Schema.Object;

public class Box extends Pickable implements Openable {
    private Object content;
    public Box(Object content) {
        super(5);
        this.content = content;
    }

    @Override
    public void open(Game game) {
        System.out.println("opening the box...");
    }
}
