package Objects;

import Schema.Object;
import lombok.Data;

@Data
public class Box extends Object {
    public Box(Object content) {
        this.setWeight(5);
        this.setContent(content);
    }
    private Object content;
}
