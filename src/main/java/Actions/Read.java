package Actions;

import Game.Game;
import Objects.Letter;

import java.util.Arrays;
import java.util.Optional;

public class Read extends Schema.Action {
    private String type;
    public Read(String type) {
        this.type = type;
    }
    @Override
    public void apply(Game game) {
        Optional<Letter> letter = Arrays.stream(game.getCurrentView().getObjects())
                .filter(a -> a.getClass().getSimpleName().equalsIgnoreCase(type))
                .map(a -> (Letter) a)
                .findFirst(); //cannot handle more than one letter at a view
        letter.ifPresentOrElse(
                a-> System.out.println("***\n" + a.getContent() + "\n***"),
                ()->{ System.out.println("there is no " + type + " to read here :/");
        });
    }
}