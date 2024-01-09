public class Arithmetic {
    int a;
    int b;

    public Arithmetic(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public static int amount(int a, int b){
        int amount = a + b;
        return amount;
    }

    public static int difference(int a, int b){
        int difference = a - b;
        return difference;
    }

    public static int multiplication(int a, int b){
        int multiplication = a * b;
        return multiplication;
    }

    public static int division(int a, int b){
        int division = a / b;
        return division;
    }
}
