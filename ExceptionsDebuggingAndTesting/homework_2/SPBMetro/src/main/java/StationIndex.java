import core.Line;
import core.Station;

import java.util.*;
import java.util.stream.Collectors;

public class StationIndex {
    private final Map<Integer, Line> number2line;
    private final TreeSet<Station> stations;
    private final Map<Station, TreeSet<Station>> connections;

    public StationIndex() {
        number2line = new HashMap<>();
        stations = new TreeSet<>();
        connections = new TreeMap<>();
    }

    public void addStation(Station station) {//получаем на вход станцию
        stations.add(station);//кладем в TreeSet пришедшую станцию из класса Station
    }

    public void addLine(Line line) {//кладем в список Map пришедшую на вход линию из класса Line
        number2line.put(line.getNumber(), line);//а точнее номер, который возвращает нам метод getLine и название линии
    }

    public void addConnection(List<Station> stations) {
        for (Station station : stations) {//проходимся по списку класса Station : принятым в параметры объектом класса Station
            if (!connections.containsKey(station)) {//проверяем: если в TreeMap connections нет в виде ключа станции которая пришла нам в параметры
                connections.put(station, new TreeSet<>());//то мы кладем в TreeMap connections эту станцию и создаем новый объект в TreeSet
            }
            TreeSet<Station> connectedStations = connections.get(station);//если же есть такая станция в TreeMap, то мы достаем ее из TreeMap и кладем в connectedStations
            connectedStations.addAll(stations.stream()//(У пришедшего в параметры объекта вызываем стрим, у стрим - фильтр, он вернет нам
                    .filter(s -> !s.equals(station)).collect(Collectors.toList()));//только те станции которых нет в TreeSet) и мы добавим их в наш TreeSet connectedStations
        }
    }

    public Line getLine(int number) {//этот метод будет получать на вход какой-то номер
        return number2line.get(number);//и возвращать из списка номер
    }

    public Station getStation(String name) {
        for (Station station : stations) {//прохожусь по списку stations
            if (station.getName().equalsIgnoreCase(name)) {//если мы не находим станцию с таким же названием, что пришла в параметры
                return station;//то возвращаем название этой станции
            }
        }
        return null;
    }

    public Station getStation(String name, int lineNumber) {
        Station query = new Station(name, getLine(lineNumber));
        Station station = stations.ceiling(query);
        return station.equals(query) ? station : null;
        //assert station != null;
        //return station.equals(query) ? station : null;
    }

    public Set<Station> getConnectedStations(Station station) {
        return connections.containsKey(station) ?//если connections содержит ключ этой станции,
                connections.get(station) : new TreeSet<>();//то возвращаем индекс этой станции, если же нет, то создаем для нее новый TreeSet
    }
}
