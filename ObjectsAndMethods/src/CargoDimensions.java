public class CargoDimensions {  //название класса Габариты груза

    private final int width;    //ширина.
    private final int length;   //длина.
    private final int height;   // высота.
    private final int volume;   //объем груза.

    public CargoDimensions(int width, int length, int height) {  // Для этого создала конструктор.
        this.width = width;
        this.height = height;
        this.length = length;
        this.volume = width * length * height;
    }

    public CargoDimensions setWidth(int width) {  // Чтобы setter возвращал нам новые объекты класса.
        return new CargoDimensions(width, length,  height);
    }
    public CargoDimensions setHeight(int length) {
        return new CargoDimensions(width, length,  height);
    }
    public CargoDimensions setLength(int height) {
        return new CargoDimensions(width, length,  height);
    }
    public int getWidth() {
        return width;
    }
    public int getLength() {
        return length;
    }
    public int getHeight() {
        return height;
    }
    public  String toString() {  // Возвращает содержимое этого класса.
        return "Объем груза: "+ volume +"" +" м3";
    }
}


