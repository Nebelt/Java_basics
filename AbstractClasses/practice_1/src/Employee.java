public interface Employee extends Comparable<Employee> {
    int getMonthSalary();

    default int compareTo(Employee e) {
        return Double.compare(getMonthSalary(), e.getMonthSalary());
    }

    static int RandomSalary(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
}
