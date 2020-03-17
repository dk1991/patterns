package decorator;

abstract public class Decorator implements Product {
    final Product product;

    public Decorator(Product product) {
        this.product = product;
    }
}
