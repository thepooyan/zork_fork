package Objects;

import Objects.Abstraction.Properties.Readable;
import Objects.Abstraction.impl.Pickable;

public class Letter extends Pickable implements Readable {
    private final String msg;

    public Letter(String msg, String desc) {
        super(1, desc);
        this.msg = msg;
    }

    @Override
    public void read() {
        System.out.println("letter says:\n***\n" + this.msg + "\n***");
    }
}