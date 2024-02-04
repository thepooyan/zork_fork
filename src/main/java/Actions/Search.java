package Actions;

import Game.Game;
import Schema.Action;

import java.util.Optional;

public class Search extends Action {
    public Search() {
        setMinimumExpectedArguments(1);
    }

    @Override
    public void apply(Game game) {
        boolean noResult = true;

        for (String argument : arguments) {
            Optional<String> hiddenNote = game.getCurrentView().getHiddenNote(argument);
            hiddenNote.ifPresent(System.out::println);
            if (hiddenNote.isPresent()) noResult = false;
        }
        if (noResult)
            System.out.println("found nothing!");
    }
}
