import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

public class Line {
    private  String number;
    private  String name;
    @JsonIgnore
    private List<Station> stations;

    public Line() {
    }
    public Line(String name, String number) {
        this.name = name;
        this.number = number;
        stations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
    public void addStation(Station station) {
        stations.add(station);
    }
    public List<Station> getStations() {
        return stations;
    }

    public String toString() {
        return number + " " + name;
    }


}
