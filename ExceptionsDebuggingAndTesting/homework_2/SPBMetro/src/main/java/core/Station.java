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
        int lineComparison = line.compareTo(station.getLine());//присваиваем к этой переменной сравнение линий, существующую с той что пришла на вход
        if(lineComparison != 0) {//если две строки не совпадают (ноль выдает если 2 строки одинаковы)
            return lineComparison;// то вернем это линейное сравнение
        }
        return name.compareToIgnoreCase(station.getName());//если же они совпадают, то вернем это сравнение названия этой станции
        //В Java compareToIgnoreCase() возвращает отрицательное целое число - если заданная строка меньше, ноль - равна, или положительное целое число - больше сравниваемой строки
        //игнорируя регистр.
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