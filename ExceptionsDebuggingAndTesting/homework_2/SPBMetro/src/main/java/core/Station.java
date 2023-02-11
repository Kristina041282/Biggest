package core;

public class Station implements Comparable<Station>
{
    private Line line;
    private String name;

    public Station(String name, Line line)
    {
        this.name = name;
        this.line = line;
    }

    public Line getLine()
    {
        return line;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(Station station)//получаем на вход станцию
    {
        int lineComparison = line.compareTo(station.getLine());//compareTo сравнивает вызывающий объект с объектом переданным в качестве параметра и возвращает положительное если вызывающий
        // объект больше объекта переданного в качестве параметра, отрицательное если вызывающий объект меньше объекта переданного в качестве параметра и ноль если объекты равны.
        if(lineComparison != 0) {
            return lineComparison;//то возвращаем полученное число
        }
        return name.compareToIgnoreCase(station.getName());//Сравнивает две строки, игнорируя различия в нижнем и верхнем регистре и возвращаем полученное число
        //В Java compareToIgnoreCase() возвращает 0, если строка равна другой строке, меньше 0 возвращается если строка меньше другой строки (меньше символов), и значение больше 0 если строка
        // больше другой строки (больше символов)
    }

    @Override
    public boolean equals(Object obj)
    {
        return compareTo((Station) obj) == 0;
    }

    @Override
    public String toString()
    {
        return name;
    }
}