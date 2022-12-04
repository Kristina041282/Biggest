import java.util.*;
public class Company {

    public ArrayList<Employee> employees;////создала кол-цию в которой будут хранится все объекты разных классов имплементирующий единый интерфейс Employee

    public double cash;

    public Company(double cash) {
        this.cash = cash;
        employees = new ArrayList<>();//инициализируем этот объект в конструкторе
    }

    public void hire(Employee employee) {//найм 1-го сотрудника
        employees.add(employee);
    }

    public void hireAll(Collection<Employee> employeeList) {//найм списка всех сотрудников
        employees.addAll(employeeList);
    }

    public void fire(Employee employee) {//метод увольнение сотрудника
        employees.remove(employee);
    }

    List<Employee> getTopSalaryStaff(int count) {
        Collections.sort(employees);//отсортировываем общий список
        Collections.reverse(employees);//переворачиваем массив
        List<Employee> list = new ArrayList<>();//создаем новый список
        for (int i = 0; i < count ; i++) {//цикл будет продолжаться пока i меньше запрашиваемого списка сотрудников (в main)
            list.add(employees.get(i));//из общей кол-ции извлекаем сотрудника по индексу и вносим его в наш новый список
        }
        return list;//возвращает наш новый список с положенными в него объектами
    }


    List<Employee> getLowesSalaryStaff(int count) {
        Collections.sort(employees);
        List<Employee> list1 = new ArrayList<>();
        for (int z = 0; z < count; z++) {
            list1.add(employees.get(z));
        }
        return list1;
    }


    public double getIncome() {//метод возвращает доход компании
        if (cash > 10_000_000) {
            return cash;
        }
        return 0;
    }


    //public String toString() {//метод будет возвращать информацию о кол-ве сотрудников
    //    return "Кол-во сотрудников: " + String.valueOf(employees); }


}



