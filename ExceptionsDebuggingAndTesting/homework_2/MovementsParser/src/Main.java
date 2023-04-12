import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static String getPaymentType(String info) {//на вход приходит какая-то информация
        String regex = "[^a-zA-Z0-9]([a-zA-Z0-9\s]+)[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}\s[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}";//создали р.в
        Pattern pattern = Pattern.compile(regex);//вызываем статический метод compile и передаем в качестве первого аргумента строку с р.в
        Matcher matcher = pattern.matcher(info);//проверяем содержит ли подстроку в строке которая пришла на вход
        return matcher.find() ? matcher.group(1).trim() : null;//метод find() найдет подстроку, тогда вернем group(1), если же нет, то вернем null
    }


    public static void main(String[] args) {

        String path1 = "data/movementList.csv";
        HashMap<String, Integer> count = new HashMap<>();
        List<String> lines = new ArrayList<>();//создали кол-цию
        try {
            lines = Files.readAllLines(Paths.get(path1));//здесь через класс Files читаются все строки файла path и загоняются в кол-цию lines
        } catch (IOException e) {
            e.printStackTrace();
        }

        String firstLine = null;
        for (String line : lines) {
            if (firstLine == null) {
                firstLine = line;
                continue;
            }
                String[] fragments = line.split(",");//разбиваем строку на компоненты по запятой
                if (fragments.length != 8) {
                    System.out.println("Wrong line:" + line);
                    continue;
                }

                double expense = Double.parseDouble(fragments[7]);
                if (expense == 0) {
                    continue;
                }

                String word = getPaymentType(fragments[5]);
                if (!count.containsKey(word)) {
                    count.put(word, 0);
                }
                count.put(word, (int) (count.get(word) + expense));

                for (String y : count.keySet()) {
                    double sum = count.get(y);
                    System.out.println(y + " - " + sum);
                }
            }
        }
    }

