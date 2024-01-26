package Objects;

import Schema.Object;
import lombok.Data;

@Data
public class Letter extends Object {
    public Letter() {
        setWeight(1);
    }
    private String content;
}
