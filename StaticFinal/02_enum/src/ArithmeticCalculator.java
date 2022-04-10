public class ArithmeticCalculator {

    private int sum;
    private int num;
    //public Operation type;//создала отдельную переменную. Для того чтобы enam заработал изменила
    // тип переменной int type на Operation type.
    public int result = 0;

    public ArithmeticCalculator(int sum, int num) {//создала конструктор с помощью которого
        //инициализировала переменную sum, num, type,и чтобы enam заработал изменила в параметрах конструктора
        //int type на Operation type.
        this.sum = sum;
        this.num = num;
    }

    public int calculate(Operation type) {//метод калькулятора на вход которого передаётся одна из
        // арифметических операций (объект класса Operation).
        switch (type) {
            case ADD -> result = sum + num;
            case MULTIPLY -> result = sum * num;
            case SUBTRACT -> result = sum - num;
        }
        return result;

    }
}
// public void calculate(Operation type) {//метод калькулятора на вход которого передаётся одна из
//        // арифметических операций (объект класса Operation).
//        switch (type) {
//            case ADD -> System.out.println(sum + num);
//            case MULTIPLY -> System.out.println(sum * num);
//            case SUBTRACT -> System.out.println(sum - num);
//        }
//        return ; // Так прописывая этот метод получается просто печатаю в консоль результат расчета, то есть
//        // не возвращаю. А нужно возвращать.
















