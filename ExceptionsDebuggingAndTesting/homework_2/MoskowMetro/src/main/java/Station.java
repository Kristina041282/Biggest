import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Station {

    private String name;
    //private Line lines;
    private String numberLines;

    public Station() {
        super();
    }

    public Station(String numberLines, String name) {
        this.numberLines = numberLines;
        this.name = name;

    }
    public void setName() {
        this.name = name;

    }
    public void setNumberLines() {
        this.numberLines = numberLines;

    }

    public String getName() {
        return name;
    }

    public String getNumberLines() {
        return numberLines;
    }

    public String toString() {
        return numberLines + name;
    }

}
