package Objects;

import Schema.Object;

public class Box extends Pickable {
    private Object content;
    public Box(Object content) {
        super(5);
        this.content = content;
    }
    public void Open() {
        System.out.println("opening the box...");
    }
}
