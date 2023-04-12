//этот класс нужен для связки с классом ParsingFiles
public class FilesCsv {

    private String name;
    String data;

    public FilesCsv(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public void setName(String name) {
    }

    public String getName() {
        return name;
    }

    public void setData(String data) {
        //this.data = data;
    }

    public String getData() {
        return data;
    }

    public String toString() {
        return name + data;
    }
}
