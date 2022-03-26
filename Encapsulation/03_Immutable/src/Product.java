public class Product {

    private String name;
    private int price;
    private int barCode;

    public Product(String name, int barCode) {
        this.name = name;
        this.barCode = barCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public int getBarCode() {
        return barCode;
    }

    public void print(String message) {
        System.out.println(message);
        System.out.println(name + "\n" + "Штрихкод: "  + barCode);
    }
}

