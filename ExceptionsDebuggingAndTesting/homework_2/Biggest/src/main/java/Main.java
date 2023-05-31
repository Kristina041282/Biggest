import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        String folderPath = "C:/Users/user/Desktop/rasp";
        File file = new File(folderPath);//здесь мы создали файл
        Node root = new Node(file);//а здесь создали дерево, это будет корневая Node, добавили туда нашу папку

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);//и дальше запускаю код по этой папке, мы просто получим размер
        //вот это root содержит в себе папки и подпапки, можем запрашивать не у pool, а у нее root.getSize()
        //FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();//позволяет запускать множество развлетляющихся потоков которые потом там собираются
        pool.invoke(calculator);
        //long size = (long) pool.invoke(calculator);//этот метод invoke когда выполнится все, он вернет нам размер
        //System.out.println(getFolderSize(file));//просто распечатаем его
        //System.out.println(size);
        System.out.println(root.getSize());


        MyTread tread = new MyTread(1);
        MyTread tread1 = new MyTread(2);
        tread.start();//созданный объект вызываем метод run
        tread1.start();//и они поочереди будут печатать в консоль число, которое мы им здесь передали


        System.out.println(getHumanReadableSize(240640));
        System.out.println(getSizeFromHumanReadable("235K"));
        System.exit(0);
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

    private static char[] sizeMulti = {'B', 'K', 'M', 'G', 'T'};

    public static String getHumanReadableSize(long size) {
        for (int i = 0; i < sizeMulti.length; i++) {
            double value = size / Math.pow(1024, i);//делим размер на множитель(любое число в степени это 1)
            if (value < 1024) {
                return Math.round(value) + "" + sizeMulti[i] + (i > 0 ? "b" : "");//чтобы здесь возвращалась строка, сделали"" после value хитрый способ
                //еще плюсуем число "b" если i>0, чтобы кб или мб получались
            }
        }
        return "Very big";
    }
    public static long getSizeFromHumanReadable(String size) {
        HashMap<Character, Integer> ch = getMultipliers();
        char sizefactor = size.replaceAll("[0-9\\s+]+", "").charAt(0);
        int mul = ch.get(sizefactor);
        //long length = mul * Long.valueOf(size.replaceAll("[^0-9]", ""));//вместо этой строки можно прописать так, ниже под ней
        long length = mul * Long.parseLong(size.replaceAll("[^0-9]", ""));
        return length;
    }
    private static HashMap<Character, Integer> getMultipliers() {
        HashMap<Character, Integer> ch2 = new HashMap<>();
        for (int i = 0; i < sizeMulti.length; i++) {
            ch2.put(sizeMulti[i], (int) Math.pow(1024, i));
        }
        return ch2;
    }
}
