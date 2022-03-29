public class Main {
    public static void main(String[] args) {

        CargoDimensions cargodimensions = new CargoDimensions(2,2,2);
        //создали объект Dimensions.

        CourierService courierService = new CourierService("Гете", 15,
                "HGF", cargodimensions);
        //добавила эту информацию в курьер.службу, передала в конструктор адрес доставки, массу,
        // регистр.номер и габариты груза.

        System.out.println(courierService);//вывожу информацию о грузе (которая в себе содержит
        //габариты груза).








    }

}
