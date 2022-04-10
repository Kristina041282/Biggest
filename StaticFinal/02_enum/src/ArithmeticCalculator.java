public class ArithmeticCalculator {

    private int sum;
    private int num;

    public ArithmeticCalculator(int sum, int num) {//создала конструктор с помощью которого
        //инициализировала переменную sum, num.
        this.sum = sum;
        this.num = num;
    }

    public int calculate(Operation type) {//метод калькулятора на вход которого передаётся одна из
        // арифметических операций (объект класса Operation).
        int result = 0;
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
//        // то есть не возвращаю. А нужно возвращать.
















