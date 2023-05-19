import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Station {

    private String name;
    private Line line;
    public boolean hasConnection;

    public Station() {

    }

    public Station(String name, Line line) {
        this.line = line;
        this.name = name;
    }

    public boolean setHasConnection(boolean hasConnection) {
        this.hasConnection = hasConnection;
        return hasConnection;
    }

    public void setName() {
        this.name = name;

    }
    public void setLine() {
        this.line = line;

    }

    public String getName() {
        return name;
    }

    public Line getLine() {
        return line;
    }

    public boolean getHasConnection() { return hasConnection; }

    public String toString() {
        return line + name;
    }

}
