public class Elevator {
    int currentFloor = 1;
    int minFloor;
    int maxFloor;


    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int moveDown(int currentFloor) {
        if (currentFloor > minFloor) {
            currentFloor--;
            System.out.println("Current floor: " + currentFloor);
            return currentFloor;
        } else System.out.println("I cant move lower");
        return currentFloor;
    }

    public int moveUp(int currentFloor) {
        if (currentFloor < maxFloor) {
            currentFloor++;
            System.out.println("Current floor: " + currentFloor);
            return currentFloor;
        } else System.out.println("I cant move upper");
        return currentFloor;
    }

    public boolean checkFloor(int floor) {
        if (floor >= minFloor && floor <= maxFloor) {
            return true;
        } else {
            System.out.println("Wrong input data");
            return false;
        }
    }

    public void move(int floor) {
        if (checkFloor(floor)) {
            while (currentFloor != floor) {
                if (currentFloor > floor) {
                    currentFloor = moveDown(currentFloor);
                } else if (currentFloor < floor) {
                    currentFloor = moveUp(currentFloor);
                }
            }
            if (currentFloor == floor) {
                System.out.println("We are here");
            }
        }
    }
}
