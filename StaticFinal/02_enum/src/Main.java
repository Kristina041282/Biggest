public class Main {
    public static void main(String[] args) {

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(7, 4);

        arithmeticCalculator.calculate(Operation.ADD); // название класса.далее идет название вызываемого
        // метода и в круглых скобках (тип операции который вызываем);

        arithmeticCalculator.calculate(Operation.MULTIPLY);

        arithmeticCalculator.calculate(Operation.SUBTRACT);

    }
}
