import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {
    //private static void download(String link, String filePath) throws Exception {//метод будет принимать две строки на вход
        //URLConnection connection = new URL(link).openConnection();//openConnection() класса URL открывает соединение с указанным URL-адресом и экземпляром
        //InputStream inStream = connection.getInputStream();//URLConnection, который представляет соединение с удаленным объектом, на который ссылается URL-адрес
        //FileOutputStream outStream = new FileOutputStream(filePath);//записывает в файл
        //int b;
        //while((b = inStream.read()) != -1) {//read() method reads the next byte of the data from the input stream and returns int in the range of 0 to 255
        //    outStream.write(b);//if no byte is available because the end of the stream has been reached, the returned value is -1.
        //}
        //outStream.flush();
        //outStream.close();
        //inStream.close();
    //}
//}


    public static void main(String[] args) throws Exception {
        String url = "https://skillbox.ru"; //код, который будет получать страницу сайта
        Document doc = Jsoup.connect(url).get();//в виде объекта класса Document

        HashSet<String> links = new HashSet<>();

        Elements images = doc.select("img");//Получите все элементы веб-страницы, созданные при помощи тэга “img”
        for (Element image : images) {
            links.add(image.attr("abs:src"));//и добавьте ссылки на изображения из этих тэгов в какой-нибудь HashSet:
        }
        images.forEach(System.out::println);//просто распечатали все элементы веб-страницы
        //for (String r : links.stream().toList()) {//через стрим распечатала (получилось только синие (ссылки то есть))
        //    System.out.println(r);
        //}

        int count = 1;
        PrintWriter printWriter = new PrintWriter("data/file.txt");//для записи в файл, на вход принимает имя файла
        for (String link : links) {//цикл по всем полученным ссылкам в списке нашего HashSet
            printWriter.write(link + "\n");//записываем в файл
            String extension = link.replaceAll("^.+\\.", "").replace("?.+$", "");//необходимо писать расширение
            //count++;//можно здесь счетчик, а можно сразу в строке как ниже прописано
            String filePath = "data/file.txt" + " " + count++ + "." + extension;//для каждой из них сформируем имя файла из числа и расширения
            System.out.println(filePath);
            //try {
            //    download(link, filePath);
            //} catch (Exception ex) {
            //    System.out.println("Couldn't download " + link);
            //}
        //}

    }
        printWriter.flush();//позволяет разом все записать
        printWriter.close();//закрывает файл, чтобы никакая другая программа в файл не могла записывать кроме нас
        }
    }


