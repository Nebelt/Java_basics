public class Main {
    public static void main(String[] args) {
        Company bounty = new Company();

        for (int i = 0; i < 180; i++) {
            bounty.hire(new Operator(Employee.RandomSalary(100, 1100)));
        }

        for (int i = 0; i < 80; i++) {
            bounty.hire(new Manager(Employee.RandomSalary(1500, 8000)));
        }

        for (int i = 0; i < 10; i++) {
            bounty.hire(new TopManager(Employee.RandomSalary(8000, 40000)));
        }

        bounty.getSalaryList(bounty.getTopSalaryStaff(13));
        bounty.getSalaryList(bounty.getLowestSalaryStaff(30));

    }
}
