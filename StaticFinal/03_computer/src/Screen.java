public class Screen {  // экран
    private int weightScreen;  // вес
    private int diagonalScreen;         // диагональ

    public Screen(int weightScreen, TypeScreen screen) {
        this.weightScreen = weightScreen;
    }


    public void setWeightScreen() {
        this.weightScreen = weightScreen;
    }
    public int getWeightScreen() {
        return  weightScreen;
    }
}

