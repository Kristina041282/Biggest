public class Dimensions {

    private final int width;   //ширина
    private final int height;  // высота
    private final int length;  //длина
    private  int sum;          // ширина * длину
    private  Object dimensions;

    public Dimensions(int width, int height, int length) {  // Для этого создала конструктор.
        this.width = width;
        this.height = height;
        this.length = length;
    }
    public Dimensions() {
        width = 2;
        height = 2;
        length = 2;
    }

    public Dimensions setWidth(int width) {  // Чтобы setter возвращал нам новые объекты класса.
        return new Dimensions(width, height, length);
    }

    public Dimensions setHeight(int height) {
        return new Dimensions(width, height, length);
    }
    public Dimensions setLength(int length) {
        return new Dimensions(width, height, length);
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public int getLength() {
        return length;
    }
    public  String toString() {  // Возвращает содержимое этого класса.
        sum = width * length;
        this.dimensions = sum * height;
        return "Объем груза: " + dimensions + "" +" м3";
    }
}


