package Actions;

import Game.Game;
import Schema.Action;

import java.util.Optional;

public class Search extends Action {
    public Search() {
        setExpectedArgumnets(1);
    }

    @Override
    public void apply(Game game) {
        Optional<String> hiddenNote = game.getCurrentView().getHiddenNote(arguments[0]);
        hiddenNote.ifPresentOrElse(
                System.out::println,
                ()->{
                    System.out.println("found nothing!");
                });
    }
}
