package Objects;

import Schema.Object;
import lombok.Data;

@Data
public class Letter extends Object {
    public Letter(String content) {
        setWeight(1);
        setContent(content);
    }
    private String content;
    public void Read() {
        System.out.println(this.getContent());
    }
}
