public class TopManager implements Employee {
    private final double salaryTop = 45_000;//переменная будет содержать з/п из фиксированной части
    //public Company company;//создала экземпляр класса Company, чтобы задействовать из него то, что мне нужно, а нужен мне доход компании
    public double income;//объявила переменную к которой буду приравнивать возвращаемое значение дохода компании

    public TopManager(Company company) {
        income = company.getIncome();//здесь в конструкторе приравниваю к income возвращаемое значение дохода компании
    }

    @Override
    public double getMonthSalary() {//метод будет возвращать з/п топ-менеджера
        if (income > 10_000_000) {//если доход компании больше 10 млн
            //return salaryTop += salaryTop * 1.5;//то прибавляем к зарплате бонус в виде 150% от з/п
            return salaryTop * 1.5;
        } else {
            return salaryTop;//если нет, то выдаем только оклад
        }
    }

    //@Override
    //public String toString() {//метод будет возвращать информацию о зарплате топ-менеджера
    //    if (income > 10_000_000) {
    //        return String.valueOf(getClass().getName() + " " + "Отлично поработали к Вашей з/п добавлен бонус в виде 150% от з/п." +
    //                " " + "Итого Вам начислено:" + " " + (salaryTop * 1.5)) + "рублей";
    //      //return String.valueOf(getClass().getName() + " " + "Отлично поработали к Вашей з/п добавлен бонус в виде 150% от з/п." +
    //                //" " + "Итого Вам начислено:" + " " + (salaryTop + (salaryTop * 1.5))) + "рублей";
    //    } else {
    //        return String.valueOf(getClass().getName() + " " + salaryTop);
    //    }
    //}
}

