package Actions;

public class Move implements Action {
    public Direction direction;
    public Move(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void apply() {
        if (direction == null) {
            System.out.println("moving to where?!?");
            return;
        }
        System.out.println("moving to " + direction);
    }
}
