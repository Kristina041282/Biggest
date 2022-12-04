public class Operator implements Employee {

    private final double salaryOperation = 27000;

    public Operator() {
    }

    @Override
    public double getMonthSalary () {//метод будет возвращать з/п оператора, которая состоит только из фиксированной части
        return salaryOperation;
    }

    // @Override
   // public String toString() {//метод будет возвращать информацию о зарплате топ-менеджера
   //     return String.valueOf(getClass().getName() + " " + salaryOperation);
   // }



}
