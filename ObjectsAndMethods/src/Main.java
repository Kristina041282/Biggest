public class Main {
    public static void main(String[] args) {

       // CargoDimensions cargodimensions = new CargoDimensions(3, 3, 3);
        //создали объект Dimensions.

       // CourierService courierService = new CourierService("Гете", 15,
         //       "HGF", cargodimensions);
        //добавила эту информацию в курьер.службу, передала в конструктор адрес доставки, массу,
        // регистр.номер и габариты груза.

        //System.out.println(courierService);//вывожу информацию о грузе (которая в себе содержит
        //габариты груза).

        Basket basket = new Basket();
        basket.add("Milk", 20,1,5);
        basket.add("water", 10, 1,2);
        basket.print("Корзина 1");

        basket = new Basket(1000);
        basket.add("Sugar", 10,1,6);
        basket.add("butter",5,3,5);
        basket.print("Корзина 2");


        System.out.println("Всего у нас: " + Basket.getCount() + " " +"корзины. " +
                "\n " + "Общая стоимость за товары во всех корзинах: "
                + Basket.getTotalCost() + " " + "руб." + "\n" +
               "Общее кол-во товаров во всех корзинах: " + Basket.getTotalAmount() + " " + "шт" +
                "\n" + "Средняя цена за товар во всех корзинах: " + Basket.getTotalAveragePrice() +
                "\n" + "Средняя стоимость корзин: " + Basket.getAveragePrice());

    }
}
