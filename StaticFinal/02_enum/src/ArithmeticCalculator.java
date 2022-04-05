public class ArithmeticCalculator {

    private int sum;
    private int num;
    public Operation type;//создала отдельную переменную. Для того чтобы enam заработал изменила
    // тип переменной int type на Operation type.

    public ArithmeticCalculator(int sum, int num, Operation type) {//создала конструктор с помощью которого
        //инициализировала переменную sum, num, type,и чтобы enam заработал изменила в параметрах конструктора
        //int type на Operation type.
        this.sum = sum;
        this.num = num;
        this.type = type;
        calculate(type, sum, num); //чтобы заработал метод calculate.
    }

    public Operation getType() {//возвращает тип operation. Чтобы enam заработал изменила int getType
        // на Operation getType.
        return type;//чтобы возвращал тот или иной перечисляемый тип.
    }

    public void calculate(Operation type, int sum, int num) {//метод калькулятора на вход которого
        // передаётся одна из арифметических операций (объект класса Operation)
        switch (type) {
            case ADD -> {
                System.out.println(sum + num);
                System.out.println(getType());
                return;
            }
            case MULTIPLY -> {
                System.out.println(sum * num);
                System.out.println(getType());
                return;
            }
            case SUBTRACT -> {
                System.out.println(sum - num);
                System.out.println(getType());
                return;
            }
        }
    }
}















