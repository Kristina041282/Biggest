import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();//ObjectMapper – основной актерский класс библиотеки Джексона
        String jsonFile = Files.readString(Paths.get("src/main/resources/map.json"));//читает JSON-файл в строку
        JsonNode jsonData = objectMapper.readTree(jsonFile);//будет парсить JSON-данные в объект класса JsonNode(то есть получаем доступ ко всем данным в этом файле)
        JsonNode stations = jsonData.get("stations");//Получаем из этого объекта данные о станциях
        JsonNode lines = jsonData.get("lines");//Получаем из этого объекта данные о линиях

        for (JsonNode line : lines) {//обходим массив с линиями
            ObjectNode lineNode = (ObjectNode) line;//и получим на основе каждой линии объект, который можно будет изменять
            lineNode.remove("color");//Удаляю из них ключ “color”
            String lineNumber = line.get("number").asText();//на основе этих данных получаю номера линий 1 2 3 4 5
            JsonNode stationsList = stations.get(lineNumber);//затем получаю станции на каждой из этих линий 1-й 2-й 3-й 4-й 5-й
            int stationsCount = stationsList.size();//затем общее кол-во станций на каждой из этих линий присваиваю к этой переменной
            lineNode.put("stationsCount", stationsCount);//добавляю ключи “stationsCount” со значениями, равными кол-ву станций на каждой из линий
            //Напишите код, который запишет изменённый объект “lines” в отдельный JSON-файл. Пример:
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());//если добавить эту
            //File output = new File("src/main/resources/export.json");//и эту закомитить
            writer.writeValue(Paths.get("src/main/resources/export.json").toFile(), lines);//и эту строку кода
            //mapper.writeValue(output, lines);//а эту закомитить, то будет вывод в столбик красиво
        }
    }
}
