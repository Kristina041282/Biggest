public interface Employee extends Comparable<Employee> {//имплементс не получается написать потому что это уже интерфейс, поэтому пишем extends


    double getMonthSalary();//метод возвращающий месячную з/п

    @Override
    default int compareTo(Employee e) {//получается, сделала общий compareTo для всех подклассов, ведь он же интерфейс, а все подклассы от него имплементируются
        return  Integer.compare((int) getMonthSalary(), (int) e.getMonthSalary());//таким образом будут сравниваться з/п всех спецов
    }

}
