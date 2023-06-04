import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        //String[] argums = {"-d", "C:/Users/user/Desktop/JAVA", "-l", "54G"};
        //ParametrsBag bag = new ParametrsBag(argums);
        ParametrsBag bag = new ParametrsBag(args);//чтобы отсюда то нужно либо в командную строку вписать или в Main->Edit Configurations

        String folderPath = bag.getPath();
        long sizeLimit = bag.getLimit();//а родителю этот лимит установлен здесь

        //String folderPath = "C:/Users/user/Desktop/JAVA";
        File file = new File(folderPath);//здесь мы создали файл
        //long sizeLimit = 50 * 1024 * 1024;
        Node root = new Node(file, sizeLimit);//а здесь создали дерево, это будет корневая Node, добавили туда нашу папку

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);//и дальше запускаю код по этой папке, мы просто получим размер
        //вот это root содержит в себе папки и подпапки, можем запрашивать не у pool, а у нее root.getSize()
        //FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();//позволяет запускать множество развлетляющихся потоков которые потом там собираются
        pool.invoke(calculator);
        //long size = (long) pool.invoke(calculator);//этот метод invoke когда выполнится все, он вернет нам размер
        //System.out.println(getFolderSize(file));//просто распечатаем его
        //System.out.println(size);
        //System.out.println(root.getSize());
        System.out.println(root);


        MyTread tread = new MyTread(1);
        MyTread tread1 = new MyTread(2);
        tread.start();//созданный объект вызываем метод run
        tread1.start();//и они поочереди будут печатать в консоль число, которое мы им здесь передали


        //System.out.println(getHumanReadableSize(240640));
        //System.out.println(getSizeFromHumanReadable("235K"));
        //System.exit(0);
    }

    private static long getFolderSize(File folder) {
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
