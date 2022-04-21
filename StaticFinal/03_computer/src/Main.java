public class Main {
    public static void main(String[] args) {

        Computer computer = new Computer("Japan", "sony");

        computer.setProcessor(new Processor(5)); // (создала здесь в классе main комплектующие и добавила
        // в computer). Для того чтобы в консоль вышло toString нужно, чтобы заработали сеттеры для всех комплектующих
        // компьютера, которые создала в классе computer.
        computer.setInformationAccumulator(new InformationAccumulator(5, TypeInformationAccumulator.HDD));
        computer.setRAM(new RAM(5));
        computer.setScreen(new Screen(5, TypeScreen.VA));
        computer.setKeyBoard(new KeyBoard(5));

        System.out.println(computer); // в () прописала название класса, получается что прописано
        // в toString все это выйдет в консоль.

    }
}

