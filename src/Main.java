public class Main {
    public static void main(String[] args) {
        Employee[] eList = new Employee[10];

        eList[0] = new Employee("Алексев Алексей Алексеевич", 1, 123123);
        eList[4] = new Employee(); // случайные данные на одного сотрудника

        fillList(eList);// заполняем все пустые поля списка случайными данными
        eList[3].setSalary(100_000);
        eList[1].setDepartment(5);

        System.out.println("Полные данные сотрудников:");
        printList(eList);
        printList(eList, 2);
        System.out.println("\nСумма затрат в месяц: " + calculateTotalSalary(eList));
        System.out.println("\nСумма затрат в месяц в 1-м отделе: " + calculateTotalSalary(eList, 1));
        System.out.println("\nСотрудник с минимальной зарплатой: ");
        printEmployee(eList, findMinSalary(eList));
        System.out.println("\nСотрудник с максимальной зарплатой: ");
        printEmployee(eList, findMaxSalary(eList));
        System.out.println("\nСотрудник с максимальной зарплатой в 4-м отделе: ");
        printEmployee(eList, findMaxSalary(eList, 4));
        System.out.println("\nСотрудник с минимальной зарплатой в 5-м отделе: ");
        printEmployee(eList, findMinSalary(eList, 5));
        System.out.println("\nСредняя зарплата: " + calculateAverageSalary(eList));
        System.out.println("\nСредняя зарплата в 3-м отделе: " + calculateAverageSalary(eList, 3));
        System.out.println("\nСписок сотрудников:");
        printNameList(eList);
        System.out.println("\nИндексация на 15 %");
        indexSalary(eList, 15);
        printList(eList);
        System.out.println("\nСотрудники с зарплатой меньше 5 000:");
        findLessList(eList, 5_000);
        System.out.println("\nСотрудники с зарплатой от 150 000:");
        findMoreList(eList, 150000);
    }

    public static void printList(Employee[] list) { // Полный список
        int count = 0;
        for (Employee employee : list) {
            if (employee == null) continue;
            System.out.println(employee);
            count++;
        }
        if (count == 0) printEmployee(list, -1); // при пустом списке вывод "Cотрудников нет"
    }

    public static void printList(Employee[] list, int dep) { // Список отдела dep
        int count = 0;
        System.out.println("Отдел " + dep + ":");
        for (int i = 1; i < list.length; i++) {
            if (list[i] == null) continue;
            if (list[i].getDepartment() == dep) {
                printEmployee(list, i);
                count++;
            }
        }
        if (count == 0) printEmployee(list, -1);
    }

    public static void printEmployee(Employee[] list, int n) { // Вывод данных одного сорудника
        String string = n >= 0 ? ("id:" + list[n].getId() + ", " + list[n].getFullName() + ". Оклад: " + String.format("%.2f", list[n].getSalary())) : "Cотрудников нет";
        System.out.println(string);
    }

    public static void printNameList(Employee[] list) { // Cписок Ф. И. О. всех сотрудников
        int count = 0;
        for (Employee employee : list) {
            if (employee == null) continue;
            System.out.println(employee.getFullName());
            count++;
        }
        if (count == 0) printEmployee(list, -1);
    }

    public static void fillList(Employee[] list) { // Пустые поля списка случайными данными
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = new Employee();
            }
        }
    }

    public static double calculateTotalSalary(Employee[] list) { // Сумма затрат на зарплаты
        double totalSalary = 0;
        for (Employee employee : list) {
            if (employee == null) continue;
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    public static double calculateTotalSalary(Employee[] list, int dep) { // Сумма затрат на зарплаты в отделе dep
        double totalSalary = 0;
        for (Employee employee : list) {
            if (employee == null) continue;
            if (employee.getDepartment() == dep) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public static double calculateAverageSalary(Employee[] list) { // Среднее значение зарплат
        int n = 0;
        for (Employee employee : list) {
            if (employee == null) continue;
            n++;
        }
        return n == 0 ? 0 : calculateTotalSalary(list) / n; // Ноль при пустом списке
    }

    public static double calculateAverageSalary(Employee[] list, int dep) { // Среднее значение зарплат в отделе dep
        int n = 0;
        for (Employee employee : list) {
            if (employee == null) continue;
            if (employee.getDepartment() == dep) {
                n++;
            }
        }
        return n == 0 ? 0 : calculateTotalSalary(list) / n;
    }

    public static int findMinSalary(Employee[] list) { // индекс сотрудника с максимальной зарплатой
        double minSalary = Double.MAX_VALUE;
        int n = -1; // для проверки если сотрудников нет
        for (int i = 1; i < list.length; i++) {
            if (list[i] == null) continue;
            if (list[i].getSalary() < minSalary) {
                minSalary = list[i].getSalary();
                n = i;
            }
        }
        return n;
    }

    public static int findMinSalary(Employee[] list, int dep) { // индекс сотрудника с максимальной зарплатой в отделе dep
        double minSalary = Double.MAX_VALUE;
        int n = -1;
        for (int i = 1; i < list.length; i++) {
            if (list[i] == null) continue;
            if (list[i].getDepartment() == dep) {
                if (list[i].getSalary() < minSalary) {
                    minSalary = list[i].getSalary();
                    n = i;
                }
            }
        }
        return n;
    }

    public static int findMaxSalary(Employee[] list) { // индекс сотрудника с min зарплатой
        double maxSalary = -1; // оклад не может быть отрицательным
        int n = -1;
        for (int i = 1; i < list.length; i++) {
            if (list[i] == null) continue;
            if (list[i].getSalary() > maxSalary) {
                maxSalary = list[i].getSalary();
                n = i;
            }
        }
        return n;
    }

    public static int findMaxSalary(Employee[] list, int dep) { // индекс сотрудника с min зарплатой в отделе dep
        double maxSalary = -1;
        int n = -1;
        for (int i = 1; i < list.length; i++) {
            if (list[i] == null) continue;
            if (list[i].getDepartment() == dep) {
                if (list[i].getSalary() > maxSalary) {
                    maxSalary = list[i].getSalary();
                    n = i;
                }
            }
        }
        return n;
    }

    public static void indexSalary(Employee[] list, double value) { //индексация зарплаты на value%
        for (Employee employee : list) {
            if (employee == null) continue;
            employee.setSalary(employee.getSalary() * (100 + value) / 100);
        }
    }

    public static void findLessList(Employee[] list, double value) { // выводк сотрудников с зарплатой меньше value
        int count = 0;
        for (int i = 1; i < list.length; i++) {
            if (list[i] == null) continue;
            if (list[i].getSalary() < value) {
                printEmployee(list, i);
                count++;
            }
        }
        if (count == 0) printEmployee(list, -1);
    }

    public static void findMoreList(Employee[] list, double value) { // вывод сотрудников с зарплатой больше value
        int count = 0;
        for (int i = 1; i < list.length; i++) {
            if (list[i] == null) continue;
            if (list[i].getSalary() >= value) {
                printEmployee(list, i);
                count++;
            }
        }
        if (count == 0) printEmployee(list, -1);
    }

}
