import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//в этом классе парсируем Json и Csv, то есть получаем данные из этих файлов
public class ParsingFiles {

        public ParsingFiles(File file) {
        }


        public List<JsonFile> getJsonFileToListOfPojo() throws IOException {
                File file = new File("data/2/4/depths-1.json");
                ObjectMapper mapper = new ObjectMapper();
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                List<JsonFile> filesJson = mapper.readValue(file, new TypeReference<List<JsonFile>>() {
                });
                return filesJson;
        }


        public List<CsvFile> getParseCsv(String file) {
                List<CsvFile> filesCsvs = new ArrayList<>();
                try {
                        List<String> lines = Files.readAllLines(Paths.get(String.valueOf(file)));
                        for (String line : lines) {
                                String[] fragments = line.split(",");
                                if (fragments.length != 2) {
                                        System.out.println("Wrong line: " + line);
                                        continue;
                                }
                                filesCsvs.add(new CsvFile(
                                        fragments[0], " " + (fragments[1])));}
                } catch (Exception ex) {
                        ex.printStackTrace();
                }

                return filesCsvs;
        }
}







