import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderSizeCalculator extends RecursiveTask {//позволяет создавать разветляющие потоки, которые потом можно будет собирать в едино

    private File folder;
    private Node node;

    public FolderSizeCalculator(Node node){
        this.node = node;
    }
    //public FolderSizeCalculator(File folder, Node node){
    //    this.folder = folder;
    //    this.node = node;


        @Override
    protected Long compute() {//метод compute() у унаследованного класса RecursiveTask возвращает какой-то тип данных
        File f = node.getFolder();
        if (f.isFile()) {
            return f.length();
        }
        //if (folder.isFile()) {
        //    return folder.length();
        //}
        long sum = 0;//если она не файл создаем переменную сумма
        List<FolderSizeCalculator> subTask = new LinkedList<>();
            //File[] files = folder.listFiles();
        File[] files = f.listFiles();
        for (File file : files) {
            Node child = new Node(file);
            FolderSizeCalculator task = new FolderSizeCalculator(child);
            //FolderSizeCalculator task = new FolderSizeCalculator(file);
            task.fork();//запускаем задачу асинхронно(то есть отделяем в отдельный поток)
            subTask.add(task);
            node.addChild(child);
        }
        for (FolderSizeCalculator task : subTask) {//далее этот список подзадач собираем вот таким вот образом
            sum = (long)  task.join();
            //sum += task.join();//то есть мы берем и вызываем у них метод join() (он сработает только когда соответствующий поток ответвлившийся завершит
            // свое выполнение
        }
        node.setSize(sum);
        return sum;
    }
}
