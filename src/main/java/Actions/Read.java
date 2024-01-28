package Actions;

import Game.Game;
import Objects.Letter;

import java.util.Arrays;
import java.util.Optional;

public class Read extends Schema.Action {
    @Override
    public void apply(Game game) {
        Optional<Letter> letter = Arrays.stream(game.getCurrentView().getObjects())
                .filter(a -> a instanceof Letter)
                .map(a -> (Letter) a)
                .findFirst(); //cannot handle more than one letter at a view
        letter.ifPresent(a-> System.out.println("***\n" + a.getContent() + "\n***"));
    }
}
