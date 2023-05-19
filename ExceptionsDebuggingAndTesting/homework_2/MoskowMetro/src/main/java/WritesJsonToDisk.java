import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

//в этом классе записываем станции и линии в 1-й json-файл (по заданию)
public class WritesJsonToDisk {

    Set<JsonFile> jsonFiles;//буду складывать в set это даст возможность сразу отсекать дубликаты станций
    Set<CsvFile> csvFiles;
    Map<String, String[]> jsonMap = new LinkedHashMap<>();
    Map<String, Object> mapJson = new LinkedHashMap<>();


    public WritesJsonToDisk(Set<CsvFile> csvFiles, Set<JsonFile> jsonFiles) throws IOException {
        this.csvFiles = csvFiles;
        this.jsonFiles = jsonFiles;
    }


    public ObjectWriter getWriteMapJson(List<Line> lines) throws Exception {
        for (Line line : lines) {
            String[] array = new String[line.getStations().size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = line.getStations().get(i).getName();
            }
                jsonMap.put(line.getNumber(), array);
                mapJson.put("stations", jsonMap);
                mapJson.put("lines", lines);
        }
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(Paths.get("src/main/resources/map.json").toFile(), mapJson);
        return writer;
    }


    public ObjectWriter getWriteStationsJson(List<Station> stations) throws Exception {//передаю в параметры список станций спарсированные с сайта
        Map<String, Object> map = new LinkedHashMap<>();
        List<StationsJson> stationInfoList = new ArrayList<>();
        stations.forEach(station ->
        {
                stationInfoList.add(new StationsJson(station.getName(), station.getLine().getName(), getDateStation(station), getDepthStation(station),
                        station.getHasConnection()));
        });
        map.put("stations", stationInfoList);

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(Paths.get("src/main/resources/stations.json").toFile(), map);
        return writer;
    }


    private String getDateStation(Station station) {
        String date = null;
        String nextDate;
        String stationName = station.getName().replaceAll("ё", "е");

        List<CsvFile> dateAndName = csvFiles.stream()
                .filter(csvFile -> csvFile.getName()
                        .replaceAll("ё", "е").equalsIgnoreCase(stationName)).toList();

        if (dateAndName.size() != 0) {
            date = dateAndName.get(0).getDate();
        }
        for (CsvFile csvFile : dateAndName) {
            nextDate = csvFile.getDate();
            if (!nextDate.equals(date)) {
                return nextDate;
            }
        }
        return date;
    }


    private Double getDepthStation(Station station) {

        String result = jsonFiles.stream()
                .filter(jsonFile -> jsonFile.getStationName()
                        .replaceAll("ё", "е")
                        .equalsIgnoreCase(station.getName().replaceAll("ё", "е")))
                .filter(jsonFile -> !jsonFile.getDepth().equals("?"))
                .map(jsonFile -> jsonFile.getDepth().replaceAll(",", "."))
                .min(Comparator.comparing(Double::parseDouble))
                .orElse("");
        if (!result.isEmpty()) {
            return Double.parseDouble(result);
        }
        return null;
    }
}
