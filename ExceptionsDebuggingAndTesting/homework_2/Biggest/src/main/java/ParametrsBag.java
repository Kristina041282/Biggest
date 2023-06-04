import java.io.File;
public class ParametrsBag {

    private long limit;
    private String path;

    public ParametrsBag(String args[]) {//здесь в конструкторе проверяю длину аргумента
        if (args.length != 4) {
            throw new IllegalArgumentException("Укажите два параметра -l (лимит по объему) и -d (путь к папке ");
        }
        
        limit = 0;
        path = "";
        for (int i = 0; i < 4; i = i + 2) {//далее я двигаюсь по этим аргументам парами, потому что они помуг быть поменены в команд.строке это допустимо
        if (args[i].equals("-l")) {
            limit = SizeCalculator.getSizeFromHumanReadable(args[i + 1]);//здесь устанавливаю лимит
    } else if(args[i].equals("-d")) {
        path = args[i + 1];//и устанавливаю path
    }
}
        if (limit <= 0) {
            throw new IllegalArgumentException("Лимит не указан или указан не верно");
        }
        File folder = new File(path);
        if (folder.exists() || folder.isDirectory()) {
            throw new IllegalArgumentException("Путь к папке не указан или указан не верно");
        }
    }

    public long getLimit() {//получается, лимит передается нам в виде строки
        return limit;
    }

    public String getPath() {
        return path;
    }
}
