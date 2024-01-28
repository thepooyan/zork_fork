package Objects;

import Game.Game;

public class Letter extends Pickable implements Readable{
    private String msg;

    public Letter(String msg) {
        super(1);
        this.msg = msg;
    }

    @Override
    public void read() {
        System.out.println("letter says:\n***\n" + this.msg + "\n***");
    }
}