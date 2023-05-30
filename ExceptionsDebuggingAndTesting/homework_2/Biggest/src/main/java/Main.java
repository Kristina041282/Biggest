import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        String folderPath = "C:/Users/user/Desktop/rasp";
        File file = new File(folderPath);

        FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();//позволяет запускать множество развлетляющихся потоков которые потом там собираются
        long size = (long) pool.invoke(calculator);//этот метод invoke когда выполнится все, он вернет нам размер
        System.out.println(getFolderSize(file));//просто распечатаем его
        System.out.println(size);


        MyTread tread = new MyTread(1);
        MyTread tread1 = new MyTread(2);
        tread.start();//созданный объект вызываем метод run
        tread1.start();//и они поочереди будут печатать в консоль число, которое мы им здесь передали
    }

    public static long getFolderSize(File folder) {
        if (folder.isFile()) {
            return folder.length();
        }
        long sum = 0;
        File[] files = folder.listFiles();
        for (File file : files) {
            sum += getFolderSize(file);
        }
        return sum;
    }
}
