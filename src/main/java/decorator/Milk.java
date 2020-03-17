package decorator;

public class Milk implements Product {
    private final int price;

    public Milk(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }
}
