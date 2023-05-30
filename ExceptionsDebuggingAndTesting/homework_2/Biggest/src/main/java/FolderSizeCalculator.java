import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderSizeCalculator extends RecursiveTask {//позволяет создавать разветляющие потоки, которые потом можно будет собирать в едино

    private File folder;

    public FolderSizeCalculator(File folder){
        this.folder = folder;
    }

    @Override
    protected Long compute() {//метод compute() у унаследованного класса RecursiveTask возвращает какой-то тип данных
        if (folder.isFile()) {
            return folder.length();
        }
        long sum = 0;//если она не файл создаем переменную сумма
        List<FolderSizeCalculator> subTask = new LinkedList<>();
        File[] files = folder.listFiles();
        for (File file : files) {
            FolderSizeCalculator task = new FolderSizeCalculator(file);
            task.fork();//запускаем задачу асинхронно(то есть отделяем в отдельный поток)
            subTask.add(task);
        }
        for (FolderSizeCalculator task : subTask) {//далее этот список подзадач собираем вот таким вот образом
            sum = (long)  task.join();
            //sum += task.join();//то есть мы берем и вызываем у них метод join() (он сработает только когда соответствующий поток ответвлившийся завершит
            // свое выполнение
        }
        return sum;
    }
}
