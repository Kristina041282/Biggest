public class Processor {  // процессор

    private int frequencyProcessor;        // частота
    private int NumberOfCoresProcessor;    // количество ядер
    private String manufacturerProcessor;  // производитель
    private int weightProcessor;           // вес

    public Processor(int weightProcessor) {
        this.weightProcessor = weightProcessor;
    }


    public void setWeightProcessor() {
        this.weightProcessor = weightProcessor;
    }
    public int getWeightProcessor() {
        return weightProcessor;
    }
}

