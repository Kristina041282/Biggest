import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.nio.file.Paths;
import java.util.*;

//в этом классе записываем станции и линии в 1-й json-файл по заданию
public class WritesJsonFileToDisk {
    private List<Line> lines;
    private List<Station> stations;
    WebpageParse webpage = new WebpageParse();//инициализировала объект класса Webpage, чтобы вызвать из него нужные методы

    Map<String, List<Station>> json1 = new LinkedHashMap<>();//здесь будет храниться номер линии и список станций
    Map<String, Object> map = new LinkedHashMap<>();//сюда вложу json1 для вывода в json-файл

    public WritesJsonFileToDisk(List<Line> lines, List<Station> stations) {
        this.lines = lines;
        this.stations = stations;
    }

    public ObjectWriter getStationToJson1() throws Exception {

        for (Line line : webpage.getLines()) {
            for (Station station : webpage.getStation()) {
                String f = line.getNumber();
                String v = station.getNumberLines();
                //station = new Station((String) f, v);
                if (f.equals(v)) {
                    line.addStation(station);
                }
            }
            json1.put(line.getNumber(), line.getStations());
            map.put("stations", json1);
            map.put("lines", lines);
        }
        ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get("src/main/resources/map.json").toFile(), map);
            return writer;
    }

}

