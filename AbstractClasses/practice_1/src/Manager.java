public class Manager extends Company implements Employee {

    private int salary;
    private final double bonus = 0.05;

    public Manager(int salary) {
        this.salary = salary;
    }

    @Override
    public int getMonthSalary() {
        salary += getIncome() * bonus;
        return salary;
    }


}
