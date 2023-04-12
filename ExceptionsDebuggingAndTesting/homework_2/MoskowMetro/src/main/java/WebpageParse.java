import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.*;

//в этом классе получаем номера и название линий и станций
public class WebpageParse {

    public List<Station> stations;
    public List<Line> lines;
    private static final String URL = "https://skillbox-java.github.io";//необходимо подключиться к нужной странице

    public List<Line> getLines() throws Exception {
        lines = new ArrayList<>();
        Document doc = Jsoup.connect(URL).get();
        Elements elements = doc.select("span.js-metro-line");//далее у document вызываем метод select и делаем запрос, получаем множество элементов (ссылок)
        //затем с помощью forEach перебираем нашу кол-цию и вносим в список number все эти ссылки и text() дает название линии и станции
        elements.forEach(element -> {
            lines.add(new Line(element.attr("data-line"), element.text()));
            //lines.add(new Line(element.text(), element.attr("data-line")));
        });
        return lines;
    }

    public List<Station> getStation() throws Exception {
        try {
            stations = new ArrayList<>();
            Document doc1 = Jsoup.connect(URL).get();
            Elements elements1 = doc1.select("p.single-station");
            elements1.forEach(element -> {
                //stations.add(new Station(element.text(), new Line(element.attr("data-line"), element.text())));
                stations.add(new Station(element.attr("data-line"), element.text()));
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
            return stations;
    }

}


