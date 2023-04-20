import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private  String number;
    private  String name;
    @JsonIgnore
    private List<Station> stations;

    public Line() {
        super();
    }
    public Line(String number, String name) {
        this.number = number;
        this.name = name;
        stations = new ArrayList<>();
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public List<Station> getStations() {
        return stations;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String toString() {
        return number + " " + name + stations;
    }


}
