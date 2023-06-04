import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
//у нас будет корневой узел и у него будут такие же узлы объекты этого же класса в потомках
//то есть это некий класс представляет собой структуру в который можно добавлять детей и соответственно в них тоже можно добавлять детей

public class Node {
    private File folder;
    private ArrayList<Node> children;
    private long size;
    private int level;
    private long limit;

    public Node(File folder, long limit) {
        this(folder);
        this.limit = limit;
    }
    public Node(File folder) {
        this.folder = folder;
        children = new ArrayList<>();

    }

    public void setSize(long size) {
        this.size = size;
    }

    private long setLimit(long limit) {
        return limit;
    }

    public long getSize() {
        return size;
    }

    public void addChild(Node node) {//устанавливаем node следующий уровень вот таким макаром node.setLevel(level + 1);
        node.setLevel(level + 1);//текущий +1 то есть 0 будет по умолчанию у node, добавляем следующего ребенка то у него будет level+1
        node.setLimit(limit);
        children.add(node);//и добавляет к ней в список children еще одну node, которую передали в параметры
    }
    private void setLevel(int level) {//сделали его private чтобы никто не залезал в его реализацию
        this.level = level;
    }

    public ArrayList<Node> getChildren() {
        return children;

    }
    public File getFolder() {//этот метод возвращает File
        return folder;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        String size = SizeCalculator.getHumanReadableSize(getSize());
        builder.append(folder.getName() + "-" + size + "\n");//добавляем имя текущей папки
        for (Node child : children) {
            if (child.getSize() < limit) {
                continue;
            }
            builder.append("  ".repeat(level + 1) + child.toString());//мы делаем repeat для детей и у детей уровень на 1 больше чем у текущей строки, поэтому
        }// level и имеет значение (объяснение зачем здесь прибавили к level + 1
        return builder.toString();
    }
}
