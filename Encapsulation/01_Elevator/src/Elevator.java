import java.util.concurrent.atomic.AtomicInteger;

    public class Elevator {

        public int currentFloor = 1;
        public int minFloor;
        public int maxFloor;

        public Elevator(int minFloor, int maxFloor) {
            this.minFloor = minFloor;// здесь была ошибка я писала: this.currentFloor = currentFloor
            this.maxFloor = maxFloor;
        }

        public void moveDown() {
            currentFloor = currentFloor >= minFloor ? currentFloor - 1 : currentFloor;
        }

        public void moveUp() {
            currentFloor = currentFloor <= maxFloor ? currentFloor + 1 : currentFloor;
        }

        public int getCurrentFloor() {
            return currentFloor;
        }

        public void move(int floor) {
            while (floor < currentFloor) {
                moveDown();
                System.out.println(currentFloor);
            }
            while (floor > currentFloor) {
                moveUp();
                System.out.println(currentFloor);
            }
        }
    }

