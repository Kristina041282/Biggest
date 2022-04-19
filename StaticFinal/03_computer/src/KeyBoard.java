public class KeyBoard {   // клавиатура

    private String type;   // тип
    private   boolean presenceOfBacklight;   // наличие подсветки
    private int weightKeyBoard;    // вес

    public KeyBoard(int weightKeyBoard) {
        this.weightKeyBoard = weightKeyBoard;
    }


    public void setWeightKeyBoard() {
        this.weightKeyBoard = weightKeyBoard;
    }
    public int getWeightKeyBoard() {
        return weightKeyBoard;
    }
}
