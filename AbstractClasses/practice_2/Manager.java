public class Manager implements Employee{

    private double salaryManager = 60_000;//переменная будет содержать з/п из фиксированной части
    public int companyIncome;

    public Manager () {//конструктор (доход приносимый менеджерами: указываем в main)
        this.companyIncome = (int) (Math.random() * 25000) + 115000;//набор будет от 115000 до 140000
        this.salaryManager = (int) salaryManager + companyIncome * 0.05;
    }

    @Override
    public double getMonthSalary () { //метод будет возвращать з/п менеджера
            return salaryManager;
    }

   // @Override
    //public String toString() {//метод будет возвращать информацию о менеджере с его окладом и бонусом к з/п
    //    return getClass().getName() + " " + "Ваша з/п составила в этом месяце:" + " " + (salaryManager) + "рублей";
   // }


}
