import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        WebpageParse web = new WebpageParse();
        FileSearch fileSearch = new FileSearch();


        List<Line> lines = web.getLines();
        List<Station> stations = web.getStations();


        Set<CsvFile> csvFilesSet = new HashSet<>();
        List<File> filesCsv = fileSearch.getJsonFile(new File("data/"));
        filesCsv.forEach(file -> {
            ParsingFiles parsingFiles = new ParsingFiles(file);
            csvFilesSet.addAll(parsingFiles.getParseCsv("data/0/5/dates-2.csv"));
        });

        Set<JsonFile> jsonFileSet = new HashSet<>();
        List<File> filesJson = fileSearch.getJsonFile(new File("data/"));
        filesJson.forEach(file -> {
            ParsingFiles parsingFiles1 = new ParsingFiles(file);
            try {
                jsonFileSet.addAll(parsingFiles1.getJsonFileToListOfPojo());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        try {
            WritesJsonToDisk writesJsonToDisk = new WritesJsonToDisk(csvFilesSet, jsonFileSet);
            writesJsonToDisk.getWriteMapJson(lines);
            writesJsonToDisk.getWriteStationsJson(stations);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}










