import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    List<Station> route1;
    List<Station> route2;
    StationIndex stationIndex;//создала объект от класса StationIndex
    RouteCalculator routeCalculator;
    List<Station> connection;

    @Override
    protected void setUp() throws Exception {
        route2 = new ArrayList<>();
        route1 = new ArrayList<>();
        route = new ArrayList<>();
        stationIndex = new StationIndex();
        connection = new ArrayList<>();
        //routeCalculator = new RouteCalculator(stationIndex);

        Line line1 = new Line(1,"Red");//создала три линии
        Line line2 = new Line(2,"Blue");
        Line line3 = new Line(3,"Yellow");

        Station s1 = new Station("Невский проспект", line1);//привязала эти три станции к 1-й линии
        Station s2 = new Station("Горьковская", line1);
        Station s3 = new Station("Петроградская", line1);

        Station s4 = new Station("Гостиный двор", line2);//привязала эти три станции ко 2-й линии
        Station s5 = new Station("Василеостровская", line2);
        Station s6 = new Station("Приморская", line2);

        Station s7 = new Station("Площадь Восстания", line3);//привязала эти три станции к 3-й линии
        Station s8 = new Station("Чернышевская", line3);
        Station s9 = new Station("Площадь Ленина", line3);

        stationIndex.addStation(s1);//добавила в список станции
        stationIndex.addStation(s2);
        stationIndex.addStation(s3);
        stationIndex.addStation(s4);
        stationIndex.addStation(s5);//Василеостровская находится на 2 линии Blue
        stationIndex.addStation(s6);
        stationIndex.addStation(s7);
        stationIndex.addStation(s8);
        stationIndex.addStation(s9);
        line1.addStation(s1);
        line1.addStation(s2);
        line1.addStation(s3);
        line2.addStation(s4);
        line2.addStation(s5);
        line2.addStation(s6);
        line3.addStation(s7);
        line3.addStation(s8);
        line3.addStation(s9);

        stationIndex.addLine(line1);//добавила в список линии
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        //Station transfer1 = new Station("s1", line1);//создала пересадку на 1 линии Red - "Невский проспект"
        //Station transfer2 = new Station("s4", line2);//создала пересадку на 2 линии Blue - "Гостиный двор"
        //Station transfer3 = new Station("s7", line3);//создала пересадку на 3 линии Yellow - "Площадь Восстания"

        connection.add(s1);//создала список, чтобы добавить в него станции, где будет возможность сделать пересадку
        connection.add(s4);
        connection.add(s7);

        stationIndex.addConnection(connection);//добавила в список stationIndex - пересадки

        //testRouteOnTheLine()
        route.add(s2);
        route.add(s3);
        //testRouteWithOneConnection()
        route1.add(s1);
        route1.add(s7);
        route1.add(s8);
        //testRouteWithTwoConnections()
        route2.add(s7);
        route2.add(s5);
        route2.add(s1);

        routeCalculator = new RouteCalculator(stationIndex);
    }
    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);//testRouteOnTheLine()
        double expected = 2.5;
        assertEquals(expected, actual);

        double actual1 = RouteCalculator.calculateDuration(route1);//testRouteWithOneConnection()
        double expected1 = 6;
        assertEquals(expected1, actual1);

        double actual2 = RouteCalculator.calculateDuration(route2);//testRouteWithTwoConnections()
        double expected2 = 7;
        assertEquals(expected2, actual2);

    }

    public void testShortestRoute() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Горьковская", 1),stationIndex.getStation("Петроградская", 1));
        List<Station> expected = route;
        assertEquals(expected, actual);
    }
    public void testRouteOnTheLine() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Горьковская", 1),stationIndex.getStation("Петроградская", 1));
        List<Station> expected = route;
        assertEquals(expected, actual);
    }
    public void testRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Невский проспект", 1), stationIndex.getStation("Чернышевская", 3));
        List<Station> expected = route1;
        assertEquals(expected, actual);
    }
    public void testRouteWithTwoConnections() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Площадь Восстания", 3), stationIndex.getStation("Невский проспект", 1));
        List<Station> expected = route2;
        assertEquals(expected, actual);
    }




    @Override
    protected void tearDown() throws Exception {
    }
}
