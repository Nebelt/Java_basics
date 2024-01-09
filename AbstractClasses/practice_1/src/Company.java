import java.util.*;

public class Company implements Comparator<Employee> {

    List<Employee> employees = new ArrayList<>();
    static int BIG_MONEY = 10_000_000;


    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(Collection<Employee> employees) {
        for (Employee worker : employees) {
            employees.add(worker);
        }

    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public double getIncome() {
        double income = Math.round((Math.random() * (140 - 115))) + 115;
        return income * 1000;
    }


    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.getMonthSalary(), o2.getMonthSalary());
    }

    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        Collections.sort(sortedEmployees);
        Collections.reverse(sortedEmployees);
        List<Employee> targetValueOfEmployees = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            targetValueOfEmployees.add(sortedEmployees.get(i));
        }
        return targetValueOfEmployees;
    }


    public List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        Collections.sort(sortedEmployees);
        List<Employee> targetValueOfEmployees = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            targetValueOfEmployees.add(sortedEmployees.get(i));
        }
        return targetValueOfEmployees;
    }

    public void getSalaryList(List<Employee> employeeList) {
        List<Employee> sortedList = new ArrayList<>();
        Collections.sort(employeeList);
        if (employeeList.get(0).getMonthSalary() > 2000) {
            System.out.println("Cписок из " + employeeList.size() + " самых высоких зарплат в компании");
            for (int i = employeeList.size() - 1; i >= 0; i--) {
                sortedList.add(employeeList.get(i));
                Collections.sort(sortedList);
                Collections.reverse(sortedList);
            }
        } else {
            System.out.println("Cписок из " + employeeList.size() + " самых низких зарплат в компании");
            sortedList.addAll(employeeList);
        }

        for (Employee worker : sortedList) {
            System.out.println(worker.getMonthSalary() + " руб.");
        }
        System.out.println();
    }

}
