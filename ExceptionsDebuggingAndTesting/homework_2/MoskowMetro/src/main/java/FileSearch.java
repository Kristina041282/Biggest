import java.io.File;
import java.util.ArrayList;
import java.util.List;

//в этом классе достаем Json-файлы и Csv-файлы из папки data
public class FileSearch {
    List<File> foundFolders = new ArrayList<>();;

    public List<File> getJsonFile(File searchFile) {//метод принимает путь до папки
        //public StringBuilder getJsonFile(File searchFile) {
        //StringBuilder stringBuilder = new StringBuilder();
            if (searchFile.isDirectory()) { // если объект представляет каталог
                for (File item : searchFile.listFiles()) { //то проходимся по этому каталогу и получаем все вложенные объекты в каталоге (то есть папки от 0 до 9)
                    getJsonFile(new File((item.getAbsolutePath())));//затем таким макаром, получаю все вложенные в них данные (то есть ссылки на папки и файлы)
                    if (item.getAbsolutePath().endsWith(".csv") || item.getAbsolutePath().endsWith(".json")) {//затем проверяю есть ли в этих данных нужные файлы
                        foundFolders.add((item));
                    }
                    //stringBuilder.append(getJsonFile(new File(item.getAbsolutePath())));
                }
            }
        return foundFolders;
    }
}










