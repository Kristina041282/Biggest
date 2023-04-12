import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        WebpageParse web = new WebpageParse();
        try {
            //System.out.println(web.getLines());
            //System.out.println();
            //System.out.println(web.getStation());
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
        List<Station> stations = web.getStation();

        try {
                WritesJsonFileToDisk writesJsonFileToDisk = new WritesJsonFileToDisk(lines, stations);
                System.out.println(writesJsonFileToDisk.getStationToJson1());
            } catch (Exception e) {
                e.printStackTrace();
            }


    }
}
