public class Main {

    public static void main(String[] args) {

        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.print("Корзина 1");

        basket  = new Basket(1000);
        basket.add("Sugar", 35);
        basket.print("Корзина 2");

        basket = new Basket(2000);
        basket.add("lamp", 50);
        basket.print("Корзина 3");


    }
}
