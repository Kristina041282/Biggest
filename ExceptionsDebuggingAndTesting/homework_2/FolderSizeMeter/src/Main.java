import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String[] sizeNames = {"b", "kb", "Mb", "Gb"};

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите путь к папке или файлу:");
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);//Создала на основе полученной строки объект класса File
            String size = getHumanReadableSize(getFolderSize(file));
            System.out.println("Размер папки / файла: " + size);

        }
    }


    public static long getFolderSize(File file) {
        if (file.isFile()) {
            return file.length();
        }
        File[] files = file.listFiles();//метод получает список лежащих в ней файлов и папок
        long length = 0;
        for (File f : files) {
            length += getFolderSize(f);//и вызывает для каждой из них сам себя, суммируя возвращаемые значения
        }
        return length;
    }

    public static String getHumanReadableSize(long length) {//принимает в качестве параметра размер папки или файла в байтах в виде числа
        int power = (int) (Math.log(length) / Math.log(1024));
        double value = length / Math.pow(1024, power);
        double roundedValue = Math.round(value * 100) / 100.;
        return roundedValue + " " + sizeNames[power];//возвращать строку, содержащую размер в понятном человеку виде, например: 5b, 10kb, 20Mb или 3Gb
    }

}
