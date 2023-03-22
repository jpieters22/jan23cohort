import java.util.ArrayList;

public class TestIceCream {
    public static void main(String[] args) {
        IceCream HoneyBeePlace = new IceCream();
        HoneyBeePlace.sellIceCream();
        HoneyBeePlace.createArrayList();

        HoneyBeePlace.orderIceCream("Chocolate");
        HoneyBeePlace.orderIceCream("Rocky Road");
        HoneyBeePlace.orderIceCream("Raspberry");
        HoneyBeePlace.orderIceCream("Chocolate");
    }
}
