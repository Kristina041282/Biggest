public class CourierService {

    private final int weight; //масса груза
    private final String deliveryAddress; //адрес доставки
    private boolean possibleToFlip = true; //можно ли переворачивать
    private final String registrationNumber; //регистрационный номер
    private boolean productBrittle = true; //товар хрупкий
    private final Dimensions dimensions;  //габариты груза

    public CourierService(String deliveryAddress, int weight, String registrationNumber,
                          Dimensions dimensions) {
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.possibleToFlip = possibleToFlip;
        this.registrationNumber = registrationNumber;
        this.productBrittle = productBrittle;
        this.dimensions = dimensions;
    }

    public CourierService setWeight(int weight) { // чтобы сеттеры возвращали нам новые объекты класса.
        return new CourierService(deliveryAddress, weight, registrationNumber, dimensions);
    }
    public CourierService setDeliveryAddress(String deliveryAddress) {
        return new CourierService(deliveryAddress, weight, registrationNumber, dimensions);
    }
    public CourierService setDimensions(Dimensions dimensions) {
        return new CourierService(deliveryAddress, weight, registrationNumber, dimensions);
    }
    public CourierService setRegistrationNumber(String registrationNumber) {
        return new CourierService(deliveryAddress, weight, registrationNumber, dimensions);
    }

    public int getWeight() {
        return weight;
    }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public boolean isPossibleToFlip() {
        return possibleToFlip;
    }
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public boolean getProductBrittle() {
        return productBrittle;
    }
    public Dimensions getDimensions() {
        return dimensions;
    }
    public String toString() {
        return "масса: " + weight + "\n" +
                "адрес доставки: " + deliveryAddress + "\n" +
                "можно ли переворачивать:" + possibleToFlip + "\n" +
                "регистрационный номер: " + registrationNumber + "\n" +
                "хрупкий ли товар: " + productBrittle + "\n" + dimensions;
    }
}
