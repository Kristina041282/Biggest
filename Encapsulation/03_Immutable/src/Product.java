public class Product {
    private String name;
    public int price;
    private int barCode;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void print(String message){
        System.out.println(message);
        System.out.println(name);
    }
}
