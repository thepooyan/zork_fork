package Actions;

import Game.Game;
import Objects.Readable;
import java.util.Arrays;
import java.util.Optional;

public class Read extends Schema.Action {
    private String type;
    public Read(String type) {
        this.type = type;
    }
    @Override
    public void apply(Game game) {
        try {
            Optional<Readable> letter = Arrays.stream(game.getCurrentView().getObjects())
                    .filter(a -> a.getClass().getSimpleName().equalsIgnoreCase(type))
                    .map(a -> (Readable) a)
                    .findFirst(); //cannot handle more than one letter at a view
            letter.ifPresentOrElse(
                    Readable::read,
                    ()->{
                        try {
                            String a = type.toLowerCase();
                            Class.forName("Objects" + "." + a.substring(0,1).toUpperCase() + a.substring(1));
                            System.out.println("there is no " + type + " to read here :/");
                        } catch (ClassNotFoundException e) {
                            System.out.println("what's a \"" + type + "\"?? :))");
                        }
                    }
            );

        } catch (Exception e) {
            System.out.println("how should i read the " + type + "?!?! :/");
        }
    }
}