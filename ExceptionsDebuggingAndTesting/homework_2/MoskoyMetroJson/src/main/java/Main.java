import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        WebpageParse web = new WebpageParse();
        //Station station = new Station();
        //Line line = new Line();
        try {
            //System.out.println(web.getLines());
            //System.out.println();
            System.out.println(web.getStation());
            //System.out.println(station.getNumberLines() + station.getName());
            //System.out.println(line.getNumber() + line.getName() + line.getStations());
            //System.out.println();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        FileSearch fileSearch = new FileSearch();
        //System.out.println(fileSearch.getJsonFile(new File("data/")));
        //System.out.println();

        ParsingFiles parsingFiles = new ParsingFiles();
        //System.out.println(parsingFiles.getJsonFileToListOfPojo());
        //System.out.println();
        //System.out.println(parsingFiles.getParseCsv("data/0/5/dates-2.csv"));



        List<Line> lines = web.getLines();
        //List<Station> stations = web.getStation();

        try {
            WritesJsonFileToDisk writesJsonFileToDisk = new WritesJsonFileToDisk();
            System.out.println(writesJsonFileToDisk.getStationToJson1(lines));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

