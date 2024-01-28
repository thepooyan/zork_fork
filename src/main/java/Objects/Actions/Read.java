package Objects.Actions;

import Game.Game;
import Objects.Letter;
import Schema.ActionOnObject;

public class Read extends ActionOnObject<Letter> {
    @Override
    public void apply(Letter letter, Game game) {
        System.out.println(letter.getContent());
    }
}
