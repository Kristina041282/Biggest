package core;

import java.util.ArrayList;
import java.util.List;

public class Line implements Comparable<Line>
{
    private int number;
    private String name;
    private List<Station> stations;

    public Line(int number, String name)
    {
        this.number = number;
        this.name = name;
        stations = new ArrayList<>();
    }

    public int getNumber()
    {
        return number;
    }

    public String getName()
    {
        return name;
    }

    public void addStation(Station station)
    {
        stations.add(station);
    }

    public List<Station> getStations()
    {
        return stations;
    }

    @Override
    public int compareTo(Line line) {//на вход пришла линия (ее номер и название)
        return Integer.compare(number, line.getNumber());//Возвращает: compare возвращает ноль, если объекты равны. Он возвращает положительное значение, если obj1 больше, чем obj2.
        // В противном случае возвращается отрицательное значение.
    }

    @Override
    public boolean equals(Object obj)
    {
        return compareTo((Line) obj) == 0;
    }
}