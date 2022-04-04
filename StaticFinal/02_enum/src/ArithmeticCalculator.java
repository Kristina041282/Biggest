public class ArithmeticCalculator {

    private int sum;
    private int var;
    public Operation type;

    public ArithmeticCalculator(int sum, int var) {
        this.sum = sum;
        this.var = var;
    }

    public ArithmeticCalculator(Operation type) {
        this.type = type;
        calculate(type);
    }

    public Operation getType() {
        return type;
    }

    public void calculate(Operation type) {

            switch (type) {
                case ADD -> System.out.println(sum + var);
                case MULTIPLY -> System.out.println(sum * var);
                case SUBTRACT -> System.out.println(sum - var);
            }
        }
    }














