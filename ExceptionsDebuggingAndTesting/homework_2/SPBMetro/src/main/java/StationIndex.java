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
            TreeSet<Station> connectedStations = connections.get(station);//получается, кладем в наш список new TreeSet
            connectedStations.addAll(stations.stream()//здесь заполняем connectedStations
                    .filter(s -> !s.equals(station)).collect(Collectors.toList()));
        }
    }

    public Line getLine(int number) {//этот метод будет получать на вход какой-то номер
        return number2line.get(number);//и возвращать из списка номер
    }

    public Station getStation(String name) {
        for (Station station : stations) {//прохожусь по списку TreeSet<Station> stations
            if (station.getName().equalsIgnoreCase(name)) {//Сравнивает данную строку с другой строкой, игнорируя регистр. Две строки считаются равными, если они имеют одинаковую длину и
                // соответствующие символы у двух строк равны, игнорируя регистр букв (то есть сравниваем название станции из полученного списка stations с названиваем пришедшим к нам на вход)
                //В Java equalsIgnoreCase() возвращает значение true, если аргумент не равен null и строки равны, без учета регистра букв; в противном случае значение false.
                return station;//если аргумент не равен null и строки равны вернет true (название станции)
            }
        }
        return null;//в противном случае возвращаем null
    }

    public Station getStation(String name, int lineNumber) {//приходит на вход название и номер линии
        Station query = new Station(name, getLine(lineNumber));//создали переменную, присваиваем ей новый созданный объект(название и получаем через getLine(lineNumber который пришел на вход)
        Station station = stations.ceiling(query);//ceiling - Возвращает наименьший элемент в этом наборе, больший или равный заданному элементу, или ноль, если такого элемента нет
        //if (station != null) {
            return station.equals(query) ? station : null;
            //assert station != null;
            //return station.equals(query) ? station : null;
        }
        //return query;
    //}


    public Set<Station> getConnectedStations(Station station) {
        return connections.containsKey(station) ?//если connections содержит по ключу такую станцию,
                connections.get(station) : new TreeSet<>();//то возвращаем индекс по которому находится станция в списке connections, если же нет, то создаем для нее новый TreeSet
    }
}
