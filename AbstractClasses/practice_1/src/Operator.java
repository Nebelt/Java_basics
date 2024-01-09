public class Operator extends Company implements Employee {

    private final int salary;

    public Operator(int salary) {
        this.salary = salary;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }


}
