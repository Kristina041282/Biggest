public class MyTread extends Thread{

    private int treadNumber;

    public MyTread(int treadNumber) {
        this.treadNumber = treadNumber;
    }

    @Override
    public void run() {
        for (;;) {
            //System.out.println(treadNumber);
        }

    }

}
