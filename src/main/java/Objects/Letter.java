package Objects;

public class Letter extends Pickable implements Readable {
    private final String msg;

    public Letter(String msg) {
        super(1);
        this.msg = msg;
    }

    @Override
    public void read() {
        System.out.println("letter says:\n***\n" + this.msg + "\n***");
    }
}