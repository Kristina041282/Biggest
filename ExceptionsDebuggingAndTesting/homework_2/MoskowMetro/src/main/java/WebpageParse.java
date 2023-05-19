import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.*;

//в этом классе получаем номера и название линий и станций с сайта
public class WebpageParse {
    Line line;
    public List<Line> lines;
    public List<Station> stations;
    private final Document document = Jsoup.connect("https://skillbox-java.github.io").get();
    Elements elements;

    public WebpageParse() throws IOException {
    }

    public List<Line> getLines() {
        lines = new ArrayList<>();
        elements = document.select("span.js-metro-line");//далее у document вызываем метод select и делаем запрос, получаем множество
        elements.forEach(element -> {// элементов (ссылок), после forEach перебираем нашу кол-цию и вносим в список все эти ссылки, а text() дает название линии и станции.
            lines.add(new Line(element.text(), element.attr("data-line")));
        });
        return lines;
    }

    public List<Station> getStations() {
        stations = new ArrayList<>();
        Elements elementsStations = document.select("div.js-metro-stations");
        for (Element element : elementsStations) {
            Elements stationNames = element.select("span.name");
            for (Element stationName : stationNames) {
                String name = stationName.text();
                line = getLineStation(element.attr("data-line"));
                Station station = new Station(name, line);
                station.setHasConnection(getConnection(name));
                line.addStation(station);
                stations.add(station);
            }
        }
        return stations;
    }

    private Line getLineStation(String lineNumber) {
        for (Line line : lines) {
            if (line.getNumber().equals(lineNumber)) {
                return line;
            }
        }
        return null;
    }

    public boolean getConnection(String stationName) {
        Elements singleStation = document.select("p.single-station");
        for (Element e : singleStation) {
            Elements title = e.getElementsByAttribute("title");
            if (!title.isEmpty() && e.text().contains(stationName)) {
                return true;
            }
        }
        return false;
    }
}



