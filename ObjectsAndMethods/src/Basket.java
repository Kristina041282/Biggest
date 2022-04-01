public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;//общая стоимость всех товаров.
    private int limit;
    private static double totalWeight = 0;//общая масса всех товаров.
    private static int totalAmount;//общее количество всех товаров во всех корзинах.
    private static int totalCost;//общая стоимость всех товаров во всех корзинах.
    private static int totalAveragePrice;//средняя цена за товар во всех корзинах.
    private static int averagePrice;//средняя стоимость корзин.

    public Basket() {
        increaseCount(1); //count увеличиваем на 1
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;

    }

    public static int getCount() {
        return count;
    }
    public static int getTotalAveragePrice() {
        return totalAveragePrice;
    }
    public static int getAveragePrice() {  //будем получать значение этой переменной.
        return averagePrice;
    }

    public static double getTotalWeight() {
        return totalWeight;
    }

    public static void increaseCount(int count) { //этот метод увеличивающий на заданное значение кол-во корзин
        Basket.count = Basket.count + count;
    }

    public static int getTotalCost() { return totalCost; } //будем получать значение этой переменной.

    public static int getTotalAmount() { return  totalAmount; } //будем получать значение этой переменной.

    public void add(String name, int price) {
        add(name, price, 0, 0);
    }

    public void add(String name, int price, int count, double weight) { //метод, который учитывает кол-во
        //товаров добавляемых в корзину.
        boolean error = false;
        if (contains(name)) {
            error = true;
        }
        if (totalPrice + count * price >= limit) {
            error = true;
        }
        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        items = items + "\n" + name + " - " + count + " шт.- " + price + " руб. ";
        totalPrice = totalPrice + count * price;
        totalWeight = totalWeight + weight * count;
        totalCost = totalCost + price * count;
        totalAmount = totalAmount + count;
        totalAveragePrice = totalCost / totalAmount;
        averagePrice = totalCost / Basket.getCount();

    }
    public void clear() { //метод, чтобы очищать корзину.
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public  int getTotalPrice() { //метод, который возвращает общую цену.
        return totalPrice;
    }

    public boolean contains(String name) { //метод определяет есть ли в корзине определенный товар.
        return items.contains(name);
    }

    public void print(String title) { //метод, который будет выводить содержимое корзины в консоль.
        System.out.println(title);
        if (items.isEmpty()) { //проверяем пуста ли корзина.
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items + "Общая стоимость за товары в корзине: "
                    + getTotalPrice() + " " + "руб.");
        }
    }
}
