//этот класс нужен для связки с классом ParsingFiles
public class CsvFile {

    private String name;
    private String date;

    public CsvFile(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public void setName(String name) {
    }

    public String getName() {
        return name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String toString() {
        return name + date;
    }
}
