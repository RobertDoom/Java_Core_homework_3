import java.util.Arrays;
import java.util.Comparator;

public class Main {

    // Класс Employee (базовый класс)
    public static abstract class Employee {
        protected String name;
        protected double monthlyPayment;

        public Employee(String name) {
            this.name = name;
        }

        public abstract double calculateAverageMonthlySalary();

        @Override
        public String toString() {
            return "Name: " + name + ", Average Monthly Salary: " + calculateAverageMonthlySalary();
        }
    }

    // Класс HourlyEmployee (класс для работников с почасовой оплатой)
    public static class HourlyEmployee extends Employee {
        private double hourlyRate;

        public HourlyEmployee(String name, double hourlyRate) {
            super(name);
            this.hourlyRate = hourlyRate;
        }

        @Override
        public double calculateAverageMonthlySalary() {
            return 20.8 * 8 * hourlyRate;
        }
    }

    // Класс FixedSalaryEmployee (класс для работников с фиксированной оплатой)
    public static class FixedSalaryEmployee extends Employee {
        public FixedSalaryEmployee(String name, double monthlyPayment) {
            super(name);
            this.monthlyPayment = monthlyPayment;
        }

        @Override
        public double calculateAverageMonthlySalary() {
            return monthlyPayment;
        }
    }

    // Класс EmployeeManager (класс, содержащий массив сотрудников и реализующий возможность сортировки и вывода данных)
    public static class EmployeeManager {
        private Employee[] employees;

        public EmployeeManager(Employee[] employees) {
            this.employees = employees;
        }

        public void printEmployees() {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }

        // Реализация сортировки массива сотрудников с помощью Comparable
        public void sortEmployees() {
            Arrays.sort(employees);
        }

        // Реализация сортировки массива сотрудников с помощью Comparator
        public void sortEmployees(Comparator<Employee> comparator) {
            Arrays.sort(employees, comparator);
        }
    }

    public static void main(String[] args) {
        Employee[] employees = {
                new HourlyEmployee("Roman", 10.0),
                new HourlyEmployee("Valentina", 12.5),
                new FixedSalaryEmployee("Mike", 2500.0),
                new FixedSalaryEmployee("Anna", 3000.0)
        };

        EmployeeManager manager = new EmployeeManager(employees);

        // Вывод данных о сотрудниках до сортировки
        System.out.println("Before sorting:");
        manager.printEmployees();

        // Сортировка и вывод данных о сотрудниках по умолчанию (среднемесячной зарплате)
        manager.sortEmployees();
        System.out.println("\nAfter sorting by average monthly salary:");
        manager.printEmployees();

        // Сортировка и вывод данных о сотрудниках по имени
        manager.sortEmployees(Comparator.comparing(employee -> employee.name));
        System.out.println("\nAfter sorting by name:");
        manager.printEmployees();
    }
}
