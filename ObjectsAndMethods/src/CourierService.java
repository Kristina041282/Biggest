public class CourierService {

    public int weight; //масса груза
    public String deliveryAddress; //адрес доставки
    public boolean possibleToFlip = true; //можно ли переворачивать
    public String registrationNumber; //регистрационный номер
    public boolean productBrittle = true; //товар хрупкий
    public Dimensions dimensions;  //габариты груза

    public CourierService(String deliveryAddress, int weight, String registrationNumber,
                          Dimensions dimensions) {
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.possibleToFlip = possibleToFlip;
        this.registrationNumber = registrationNumber;
        this.productBrittle = productBrittle;
        this.dimensions = dimensions;
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
                "хрупкий ли товар: " + productBrittle + "\n" +
                "габариты груза: " +  "\n" + dimensions;
    }
}
