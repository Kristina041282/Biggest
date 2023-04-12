import core.Line;
import core.Station;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String DATA_FILE = "src/main/resources/map.json";
    private static Scanner scanner;

    private static StationIndex stationIndex;

    public static void main(String[] args) {
        RouteCalculator calculator = getRouteCalculator();

        System.out.println("Программа расчёта маршрутов метрополитена Санкт-Петербурга\n");
        scanner = new Scanner(System.in);
        for (; ; ) {
            Station from = takeStation("Введите станцию отправления:");
            Station to = takeStation("Введите станцию назначения:");

            List<Station> route = calculator.getShortestRoute(from, to);
            System.out.println("Маршрут:");
            printRoute(route);//получается, здесь выдает список станций нужных нам сделать, чтобы добраться от пункта отправления до пункта назначения

            System.out.println("Длительность: " +
                    RouteCalculator.calculateDuration(route) + " минут");//здесь же, показывает время поездки
        }
    }

    private static RouteCalculator getRouteCalculator() {
        createStationIndex();
        return new RouteCalculator(stationIndex);
    }

    private static void printRoute(List<Station> route) {//получаем на вход список
        Station previousStation = null;//создали объект класса Station для того, чтобы здесь в будущем записывать предыдущую станцию
        for (Station station : route) {//проходимся по списку route
            if (previousStation != null) {//проверяем наш объект previousStation: если он != null
                Line prevLine = previousStation.getLine();//то создаем объект Line и присваиваем ему getLine() полученную у нашего объекта previousStation
                Line nextLine = station.getLine();//то создаем объект Line и присваиваем ему getLine() полученную у нашего объекта previousStation
                if (!prevLine.equals(nextLine)) {//проверяем не находится ли они на одной линии, и если нет то
                    System.out.println("\tПереход на станцию " +
                            station.getName() + " (" + nextLine.getName() + " линия)");//выводим в консоль информацию о пересадки на такую то линию
                }
            }
            System.out.println("\t" + station.getName());//если выше в if проверку не проходит, то печатаем название станции
            previousStation = station;// и записываем в previousStation название станции
        }
    }

    private static Station takeStation(String message) {
        for (; ; ) {
            System.out.println(message);
            String line = scanner.nextLine().trim();
            Station station = stationIndex.getStation(line);
            if (station != null) {
                return station;
            }
            System.out.println("Станция не найдена :(");
        }
    }

    private static void createStationIndex() {
        stationIndex = new StationIndex();
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            JSONArray linesArray = (JSONArray) jsonData.get("lines");
            parseLines(linesArray);

            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            parseStations(stationsObject);

            JSONArray connectionsArray = (JSONArray) jsonData.get("connections");
            parseConnections(connectionsArray);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parseConnections(JSONArray connectionsArray) {
        connectionsArray.forEach(connectionObject ->
        {
            JSONArray connection = (JSONArray) connectionObject;
            List<Station> connectionStations = new ArrayList<>();
            connection.forEach(item ->
            {
                JSONObject itemObject = (JSONObject) item;
                int lineNumber = ((Long) itemObject.get("line")).intValue();
                String stationName = (String) itemObject.get("station");

                Station station = stationIndex.getStation(stationName, lineNumber);
                if (station == null) {
                    throw new IllegalArgumentException("core.Station " +
                            stationName + " on line " + lineNumber + " not found");
                }
                connectionStations.add(station);
            });
            stationIndex.addConnection(connectionStations);
        });
    }

    private static void parseStations(JSONObject stationsObject) {//пришел на вход объект станций
        stationsObject.keySet().forEach(lineNumberObject ->//мы берем у этого объекта ключи и проходясь по ним
        {
            int lineNumber = Integer.parseInt((String) lineNumberObject);//присваиваем наши ключи переменной int lineNumber
            Line line = stationIndex.getLine(lineNumber);//затем присваиваем объекту Line line вернувшиеся номера линий (те же ключи)
            JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);//затем разбираем на массив наши полученные ключи из пришедшего в параметры объекта станций
            stationsArray.forEach(stationObject ->//далее проходимся по этому массиву с помощью forEach
            {
                Station station = new Station((String) stationObject, line);//и присваиваем к объекту Station station новый Station вкладывая в него ключ и номер линии
                stationIndex.addStation(station);//и кладем станцию в метод addStation из класса stationIndex
                line.addStation(station);//и в Line кладем станцию
            });
        });
    }

    private static void parseLines(JSONArray linesArray) {
        linesArray.forEach(lineObject -> {
            JSONObject lineJsonObject = (JSONObject) lineObject;
            Line line = new Line(
                    ((Long) lineJsonObject.get("number")).intValue(),
                    (String) lineJsonObject.get("name")
            );
            stationIndex.addLine(line);
        });
    }

    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(DATA_FILE));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}