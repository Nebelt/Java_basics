public class Main {
    public static void main(String[] args) {
//        // task 1
//        Elevator elevator = new Elevator(-3, 26);
//        while (true) {
//            System.out.print("¬ведите номер этажа: ");
//            int floor = new Scanner(System.in).nextInt();
//            elevator.move(floor);
//        }

        // task 2
        Dimensions size = new Dimensions(45, 50, 90);
        Goods boil = new Goods(size, 5, "Moscow, st. Lenina - 1", true, "8834671", false);
        boil.getInfo();
        boil.setWeight(150);
        boil.setAddress("Moscow, st. Paul - 4");
        boil.getInfo();

        System.out.println("boil to Paul");
        Goods boilToPaul = boil.setAddress("Moscow, st. Paul - 4");
        boilToPaul.getInfo();

        System.out.println("heavy boil");
        Goods heavyBoil = boil.setWeight(150);
        heavyBoil.getInfo();

        System.out.println("heavy boil to Paul");
        Goods heavyBoilToPaul = boilToPaul.setWeight(150);
        heavyBoilToPaul.getInfo();

        System.out.println("try to change size");
        Goods smallBoil = boil.setSize(10,10,25);
        smallBoil.getInfo();
    }
}
