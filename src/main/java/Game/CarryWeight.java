package Game;

public class CarryWeight {
    private final int maxValue;
    private int value;

    public CarryWeight(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getValue() {
        return value;
    }

    public boolean increaseValue(int amount) {
        if (this.value + amount <= maxValue) {
            this.value += amount;
            return true;
        }
        else return false;
    }
    public void decreaseValue(int amount) {
       value -= amount;
       if (value < 0 ) value=0;
    }
}
