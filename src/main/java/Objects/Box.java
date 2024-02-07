package Objects;

import Game.Game;
import java.util.ArrayList;
import java.util.List;

public class Box extends Pickable implements Openable {
    private final List<Pickable> content;
    public Box(List<Pickable> content) {
        super(50 + content.stream().map(Pickable::getWeight).reduce(Integer::sum).orElse(0));
        this.content = content;
    }
    public Box() {
        super(50);
        content = new ArrayList<>();
    }

    @Override
    public void open(Game game) {
        if (content.isEmpty()) {
            System.out.println("the box is empty!");
            return;
        }
        String contentS = content.stream().map(Pickable::toString).reduce((p,c)-> p + " and a " + c).get();

        System.out.println("opening the box: there's a " + contentS + " inside.");

        game.getCurrentView().getObjects().addAll(content);
    }
}
