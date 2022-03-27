public class Main {
    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions();//создали объект Dimensions.

        CourierService courierService = new CourierService("ул.Гете", 25,
                "kpr", dimensions);
        //добавила эту информацию в компанию и передала в конструктор адрес доставки и габариты груза.

        System.out.println(courierService);//вывожу информацию о грузе (которая в себе содержит
        //габариты груза).








    }

}
