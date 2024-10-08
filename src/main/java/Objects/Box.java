package Objects;

import Game.Game;
import Objects.Abstraction.Properties.Openable;
import Objects.Abstraction.impl.Pickable;

import java.util.ArrayList;
import java.util.List;

public class Box extends Pickable implements Openable {
    private final List<Pickable> content;
    public Box(List<Pickable> content, String desc) {
        super(
                50 + content.stream().map(Pickable::getWeight).reduce(Integer::sum).orElse(0),
                desc
        );
        this.content = content;
    }
    public Box(String desc) {
        super(50, desc);
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
