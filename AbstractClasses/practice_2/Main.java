import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        Company company = new Company(12_000_000);

        //найм 1-го сотрудника
        for (int i = 0; i < 1; i++) {
            company.hire(new Operator());
        }
        for (int j = 0; j < 1; j++) {
            company.hire(new Manager());
        }
        for (int f = 0; f < 1; f++) {
            company.hire(new TopManager(company));
        }

        //найм всех сотрудников
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            employeeList.add(new Operator());
        }
            for (int j = 0; j < 20; j++) {
                employeeList.add(new Manager());
            }
            for (int f = 0; f < 20; f++) {
                employeeList.add(new TopManager(company));
            }
            company.hireAll(employeeList);

            //топ самых высоких з/п
            List<Employee> employ = company.getTopSalaryStaff(30);
            for (Employee e : employ) {
                System.out.println("Высокие з/п:" + " " + e.getMonthSalary());
            }
            System.out.println();
            //топ самых низких з/п
            List<Employee> employ1 = company.getLowesSalaryStaff(30);
            for (Employee e1 : employ1) {
                System.out.println("Низкие з/п:" + " " + e1.getMonthSalary());
            }

            //увольняем 50% сотрудников
            for (int s = 0; s < company.employees.size() / 2; s++) {
                company.fire(company.employees.get(s));

            }


        }
    }

