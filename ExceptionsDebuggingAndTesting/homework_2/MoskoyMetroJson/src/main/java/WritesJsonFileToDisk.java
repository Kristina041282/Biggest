import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.nio.file.Paths;
import java.util.*;

//в этом классе записываем станции и линии в 1-й json-файл (по заданию)
public class WritesJsonFileToDisk {

    WebpageParse webpage = new WebpageParse();//инициализировала объект класса Webpage, чтобы вызвать из него нужные методы
    Map<String, String[]> json1 = new LinkedHashMap<>();
    Map<String, Object> mapjson1 = new LinkedHashMap<>();


    public ObjectWriter getStationToJson1(List<Line> lines) throws Exception {
        for (Line line : webpage.getLines()) {
            String f = line.getNumber();
            for (Station station : webpage.getStation()) {
                String v = station.getNumberLines();
                if (f.equals(v)) {
                    line.addStation(station);
                    json1.put(line.getNumber(), getStationsOneLine(line.getStations()));
                    mapjson1.put("stations", json1);
                    mapjson1.put("lines", lines);
                }
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(Paths.get("src/main/resources/map.json").toFile(), mapjson1);
        return writer;
    }


    private String[] getStationsOneLine(List<Station> stations) {
        String[] array = new String[stations.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = stations.get(i).getName();
        }
        return array;
    }
}

