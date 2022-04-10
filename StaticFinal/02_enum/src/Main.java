public class Main {
    public static void main(String[] args) {

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(7, 4);

        arithmeticCalculator.calculate(Operation.ADD); // название класса.далее идет название вызываемого
        // метода и в круглых скобках (тип операции который вызываем);
        int calculate = arithmeticCalculator.calculate(Operation.ADD);// в этой переменной в
        // круглых скобках результат. Саму переменную можно назвать как угодно.
        System.out.println("Результат:" + calculate);// здесь печатаю результат, то есть здесь
        // слово сalculate будет выводить в консоль результат, в данном случае результат сложения.

        arithmeticCalculator.calculate(Operation.MULTIPLY);
        int calculate1 = arithmeticCalculator.calculate(Operation.MULTIPLY);
        System.out.println("Результат:" + calculate1);


        arithmeticCalculator.calculate(Operation.SUBTRACT);
        int calculate2 = arithmeticCalculator.calculate(Operation.SUBTRACT);
        System.out.println("Результат:" + calculate2);




    }
}
