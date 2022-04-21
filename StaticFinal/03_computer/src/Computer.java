public class Computer {
    private final String vendor; // производитель
    private final String name;   // название
    //private int totalWeight = 0; // общая масса компьютера
    private Processor processor; // переменная названа именем класса, чтобы создать сеттер и геттер
    private RAM ram;
    private InformationAccumulator informationAccumulator;
    private Screen screen;
    private KeyBoard keyBoard;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public int getTotalWeight() {
        return processor.getWeightProcessor() + informationAccumulator.getWeightInformationAccumulator() +
                ram.getWeightRAM() + screen.getWeightScreen() + keyBoard.getWeightKeyBoard();
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
    public Processor getProcessor() {
        return processor;
    }
    public void setRAM(RAM ram) {
        this.ram = ram;
    }
    public RAM getRam() {
        return ram;
    }
    public void setInformationAccumulator(InformationAccumulator informationAccumulator) {
        this.informationAccumulator = informationAccumulator;
    }
    public InformationAccumulator getInformationAccumulator() {
        return informationAccumulator;
    }
    public void setScreen(Screen screen) {
        this.screen = screen;
    }
    public Screen getScreen() {
        return screen;
    }
    public void setKeyBoard(KeyBoard keyBoard) {
        this.keyBoard = keyBoard;
    }

    public KeyBoard getKeyBoard() {
        return keyBoard;
    }

    public String toString() { //возвращает содержимое этого класса.
        return "Производитель:" + vendor + "\n" + "Название:" + name + "\n" + "Processor:" + processor +
                "\n" + "RAM: " + ram + "\n" + "InformationAccumulator: " + informationAccumulator + "\n" +
                "Screen: " + screen + "\n" + "KeyBoard: " + keyBoard + "\n" +
                "Cуммарный вес всех комплектующих:" + " " + getTotalWeight();
    }
}


