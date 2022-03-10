public class Main {

    public static void main(String[] args) {

        Basket basket = new Basket();
        basket.add("Milk", 40,7,5);
        basket.print("Корзина 1");

        basket = new Basket(1000);
        basket.add("Sugar", 35,4,6);
        basket.print("Корзина 2");

        basket = new Basket("Book", 50);
        basket.add("lamp", 50,9,5);
        basket.print("Корзина 3");


    }

}
