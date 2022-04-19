public class RAM {  // оперативная память
    private String typeRAM;  // тип
    private int volumeRAM;   // объем
    private int weightRAM;   // вес

    public RAM(int weightRAM) {
        this.weightRAM = weightRAM;
    }


    public void setWeightRAM() {
        this.weightRAM = weightRAM;
    }
    public int getWeightRAM() {
        return weightRAM;
    }
}
