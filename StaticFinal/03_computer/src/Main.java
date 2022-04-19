public class Main {
    public static void main(String[] args) {

        Computer computer = new Computer("Japan", "sony");

        Processor processor = new Processor(5);
        InformationAccumulator informationAccumulator = new InformationAccumulator(5);
        RAM ram = new RAM(5);
        Screen screen = new Screen(5);
        KeyBoard keyBoard = new KeyBoard(5);

        System.out.println(computer); // в () прописала название класса, получается что прописано
        // в toString все это выйдет в консоль.
    }
}

