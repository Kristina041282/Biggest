import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> r;
    List<Station> r1;
    List<Station> r2;
    List<Station> r3;
    StationIndex stationIndex;//создала объект от класса StationIndex
    RouteCalculator routeCalculator;

    @Override
    protected void setUp() throws Exception {
        r = new ArrayList<>();
        r1 = new ArrayList<>();
        r2 = new ArrayList<>();
        r3 = new ArrayList<>();
        stationIndex = new StationIndex();
        //создаю три линии (в классе Line конструктор public Line(int number, String name){ )
        Line line1 = new Line(1,"Red");
        Line line2 = new Line(2,"Blue");
        Line line3 = new Line(3,"Yellow");
        //создаю станции ( в классе Station конструктор public Station(String name, Line line){ )
        Station s1 = new Station("Невский проспект", line1);//привязала эти станции к 1-й линии
        Station s2 = new Station("Горьковская", line1);
        Station s3 = new Station("Петроградская", line1);

        Station s4 = new Station("Гостиный двор", line2);//привязала эти станции ко 2-й линии
        Station s5 = new Station("Василеостровская", line2);
        Station s6 = new Station("Приморская", line2);

        Station s7 = new Station("Площадь Восстания", line3);//привязала эти станции к 3-й линии
        Station s8 = new Station("Чернышевская", line3);
        Station s9 = new Station("Площадь Ленина", line3);

        line1.addStation(s1);//привязываю к каждой линии станцию
        line1.addStation(s2);
        line1.addStation(s3);
        line2.addStation(s4);
        line2.addStation(s5);
        line2.addStation(s6);
        line3.addStation(s7);
        line3.addStation(s8);
        line3.addStation(s9);
        //затем, чтобы смочь вызывать методы для работы с класса StationIndex создала (наверху) объект от этого класса и теперь можем складывать в список и вызывать нужные нам методы
        stationIndex.addStation(s1);
        stationIndex.addStation(s2);//и вот собственно добавляю в список станции с помощью метода addStation который вызываю из класса StationIndex, за счет выше созданного объекта:
        stationIndex.addStation(s3);//вот этого я имею ввиду StationIndex stationIndex = new StationIndex();
        stationIndex.addStation(s4);
        stationIndex.addStation(s5);
        stationIndex.addStation(s6);
        stationIndex.addStation(s7);
        stationIndex.addStation(s8);
        stationIndex.addStation(s9);

        stationIndex.addLine(line1);//так же добавляю в список линии
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        List<Station> c1 = List.of(s1, s4);//создаю пересадку с 1-ветки на 2-ю
        List<Station> c2 = List.of(s5, s7);//и создаю пересадку со 2-й ветки на 3-ю
        stationIndex.addConnection(c1);//добавляю пересадки в список
        stationIndex.addConnection(c2);//добавляю пересадки в список

        //прописываю ожидаемый expected маршрут для тестирования метода testRouteOnTheLine()
        r.add(s2);
        r.add(s3);
        //testRouteWithOneConnection()
        r1.add(s3);
        r1.add(s2);
        r1.add(s1);
        r1.add(s4);
        r1.add(s5);
        //testRouteWithTwoConnections()
        r2.add(s1);
        r2.add(s4);
        r2.add(s5);
        r2.add(s7);
        r2.add(s8);
        //route2.add(c1.get(2));
        //testRouteViaConnectedLine()
        r3.add(s1);
        r3.add(s4);
        //чтобы можно было использовать в тестировании, методы из класса RouteCalculator, создала объект от класса RouteCalculator и кладу в него наш список
        routeCalculator = new RouteCalculator(stationIndex);
    }
    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(r);//testRouteOnTheLine()
        double expected = 2.5;
        assertEquals(expected, actual);

        double actual1 = RouteCalculator.calculateDuration(r1);//testRouteWithOneConnection()
        double expected1 = 11;
        assertEquals(expected1, actual1);

        double actual2 = RouteCalculator.calculateDuration(r2);//testRouteWithTwoConnections()
        double expected2 = 12;
        assertEquals(expected2, actual2);
    }

    public void testShortestRoute() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Горьковская", 1),stationIndex.getStation("Петроградская", 1));
        List<Station> expected = r;
        assertEquals(expected, actual);
    }
    public void testRouteOnTheLine() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Горьковская", 1),stationIndex.getStation("Петроградская", 1));
        List<Station> expected = r;
        assertEquals(expected, actual);
    }
    public void testRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Петроградская", 1), stationIndex.getStation("Василеостровская", 2));
        List<Station> expected = r1;
        assertEquals(expected, actual);
    }
    public void testRouteWithTwoConnections() {
        //List<Station> actual = routeCalculator.getShortestRoute(r.get(0), r.get(6));
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Невский проспект", 1),stationIndex.getStation("Чернышевская",3));
        List<Station> expected = r2;
        assertEquals(expected, actual);
    }
    public void testRouteViaConnectedLine() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Невский проспект", 1),stationIndex.getStation("Гостиный двор", 2));
        List<Station> expected = r3;
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
    }
}
