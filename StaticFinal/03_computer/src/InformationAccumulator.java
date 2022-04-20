public class InformationAccumulator { // накопитель информации
    private int volumeInformationAccumulator;  // объем
    private int weightInformationAccumulator;  // вес

    public InformationAccumulator(int weightInformationAccumulator, TypeInformationAccumulator informationAccumulator) {
        this.weightInformationAccumulator = weightInformationAccumulator;
    }


    public void setWeightInformationAccumulator() {
        this.weightInformationAccumulator = weightInformationAccumulator;
    }
    public int getWeightInformationAccumulator() {
        return weightInformationAccumulator;
    }
}
