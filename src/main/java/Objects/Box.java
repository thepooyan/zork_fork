package Objects;

import Schema.Object;
import lombok.Data;

@Data
public class Box extends Object {
    public Box() {
        this.setWeight(5);
    }
    private Object content;
}
