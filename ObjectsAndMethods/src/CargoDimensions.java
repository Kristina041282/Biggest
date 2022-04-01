public class CargoDimensions {  //название класса Габариты груза

    private final int width;    //ширина.
    private final int length;   //длина.
    private final int height;   // высота.
    private final int volume;   //объем груза.

    public CargoDimensions(int width, int length, int height) {  // Для этого создала конструктор.
        this.width = width;
        this.height = height;
        this.length = length;
        this.volume = width * length * height;//вычисляю объем груза. Такой трюк,что мы считаем volume
        // в конструкторе приемлим только в случае иммутабельного класса, где мы точно уверены,
        // что размеры и собственно объем никогда не изменятся. В общем же случае мы должны
        // вычислять объем в методе getVolume (то есть volume возвращать в методе типа
        // public int getVolume()).
        //Ниже пример как делать если класс не иммутабельный.В этом случае убираем здесь с конструктора
        //этот код this.volume = width * length * height; и прописываем внизу метод getVolume()
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
    //public int getVolume() { return width * length * height;} //через этот метод возвращаем значение volume.

    public  String toString() {  // Возвращает содержимое этого класса.
        return "Объем груза: "+ volume +"" +" м3";
    } //здесь в этом случае тогда
    //прописываем getVolume()
}


