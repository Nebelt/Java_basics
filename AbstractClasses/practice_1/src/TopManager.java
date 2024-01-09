public class TopManager extends Company implements Employee {

    private int salary;
    private final double bonus = 1.5;

    public TopManager(int salary) {
        this.salary = salary;
    }

    @Override
    public int getMonthSalary() {
        if (getIncome() > BIG_MONEY) salary += salary * bonus;
        return salary;
    }

}
