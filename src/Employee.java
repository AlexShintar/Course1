public class Employee {
    private final String fullName;
    private int department;
    private double salary;
    private static int counter = 0;
    private final int id;

    public Employee(String name, int department, double salary) {
        this.fullName = name;
        this.department = department;
        this.salary = salary;
        this.id = ++counter;
    }

    public Employee() {
        this.fullName = generateName();
        this.department = rndN(5) + 1;
        this.salary = 1.0 * rndN(200_000);
        this.id = ++counter;
    }

    private static String generateName() {
        String[] names = {"Петр", "Роман", "Степан", "Даниил", "Максим", "Глеб", "Марк", "Владислав", "Иван", "Федор",
                "Егор", "Виктор", "Денис", "Леонид", "Руслан", "Семён"};
        int n = names.length;
        return names[rndN(n)] + "ов " + names[rndN(n)] + " " + names[rndN(n)] + "ович";
    }

    private static int rndN(int range) {
        return (int) (Math.random() * range);
    }

    @Override
    public String toString() {
        return fullName + ", id:" + id + ". Отдел: " + department + ". Оклад: " + String.format("%.2f", salary);
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        if (department < 0 || department > 5) {
            throw new IllegalArgumentException("Неверно указан отдел");
        }
        this.department = department;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной.");
        }
        this.salary = salary;
    }
}

