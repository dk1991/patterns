package decorator;

public class DecoratorTutorial {
    public static void main(String[] args) {
        Product milk = new Milk(50);

        Product milkDiscount = new MilkDiscount(milk);
        System.out.println(milkDiscount.getPrice()); // 35

        Product milkDiscount2 = new MilkDiscount(new MilkDiscount(milk));
        System.out.println(milkDiscount2.getPrice()); // 20
    }
}
