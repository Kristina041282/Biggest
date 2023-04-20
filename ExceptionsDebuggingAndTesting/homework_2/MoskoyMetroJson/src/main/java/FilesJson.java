import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
//этот класс нужен для связки с классом ParsingFiles
public class FilesJson {
    private String station_name;
    private String depth;

    public FilesJson() {
        super();
    }

    public FilesJson(String station_name, String depth) {
        this.station_name = station_name;
        this.depth = depth;
    }

    public void setStation_name() {
    }
    public void setDepth() {
    }

    public String getStation_name() {
        return station_name;
    }
    public String getDepth() {
        return depth;
    }
    public String toString() {
        return station_name + depth;
    }
}
