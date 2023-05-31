import java.io.File;
import java.util.ArrayList;
//у нас будет корневой узел и у него будут такие же узлы объекты этого же класса в потомках
//то есть это некий класс представляет собой структуру в который можно добавлять детей и соответственно в них тоже можно добавлять детей

public class Node {
    private File folder;
    private ArrayList<Node> children;
    private long size;

    public Node(File folder) {
        this.folder = folder;
        children = new ArrayList<>();
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getSize() {
        return size;
    }

    public void addChild(Node node) {
        children.add(node);
    }

    public ArrayList<Node> getChildren() {
        return children;

    }
    public File getFolder() {
        return folder;
    }
}
