public class EmployeeBook {
    private final Employee[] eList;

    public EmployeeBook() {
        this.eList = new Employee[10];
        fillList(eList);
    }

    private static void fillList(Employee[] list) { //Автозаполнение списка
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = new Employee();
            }
        }
    }

    public void printList() { // Полный список
        int count = 0;
        for (Employee employee : this.eList) {
            if (employee == null) continue;
            System.out.println(employee);
            count++;
        }
        if (count == 0) printEmployee(-1); // при пустом списке вывод "Сотрудников нет"
    }

    public void printEmployee(int n) { // Вывод данных на одного сорудника
        String string = n >= 0 ? ("id:" + this.eList[n].getId() + ", " + this.eList[n].getFullName() + ". Оклад: " + String.format("%.2f", this.eList[n].getSalary())) : "Сотрудников нет";
        System.out.println(string);
    }

    public void printNameList() { // Список Ф. И. О. всех сотрудников
        int count = 0;
        for (Employee employee : this.eList) {
            if (employee == null) continue;
            System.out.println(employee.getFullName());
            count++;
        }
        if (count == 0) printEmployee(-1);
    }

    public double calculateTotalSalary() { // Сумма затрат на зарплаты
        double totalSalary = 0;
        for (Employee employee : this.eList) {
            if (employee == null) continue;
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }

    public double calculateTotalSalary(int dep) { // Сумма затрат на зарплаты в отделе dep
        double totalSalary = 0;
        for (Employee employee : this.eList) {
            if (employee == null) continue;
            if (employee.getDepartment() == dep) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }

    public double calculateAverageSalary() { // Среднее значение зарплат
        int n = 0;
        for (Employee employee : this.eList) {
            if (employee == null) continue;
            n++;
        }
        return n == 0 ? 0 : this.calculateTotalSalary() / n; // Ноль при пустом списке
    }

    public double calculateAverageSalary(int dep) { // Среднее значение зарплат в отделе dep
        int n = 0;
        for (Employee employee : this.eList) {
            if (employee == null) continue;
            if (employee.getDepartment() == dep) {
                n++;
            }
        }
        return n == 0 ? 0 : calculateTotalSalary(dep) / n;
    }

    public int findMinSalary() { // индекс сотрудника с максимальной зарплатой
        double minSalary = Double.MAX_VALUE;
        int n = -1; // для проверки если сотрудников нет
        for (int i = 1; i < this.eList.length; i++) {
            if (this.eList[i] == null) continue;
            if (this.eList[i].getSalary() < minSalary) {
                minSalary = this.eList[i].getSalary();
                n = i;
            }
        }
        return n;
    }

    public int findMinSalary(int dep) { // индекс сотрудника с максимальной зарплатой в отделе dep
        double minSalary = Double.MAX_VALUE;
        int n = -1;
        for (int i = 1; i < this.eList.length; i++) {
            if (this.eList[i] == null) continue;
            if (this.eList[i].getDepartment() == dep) {
                if (this.eList[i].getSalary() < minSalary) {
                    minSalary = this.eList[i].getSalary();
                    n = i;
                }
            }
        }
        return n;
    }

    public int findMaxSalary() { // индекс сотрудника с min зарплатой
        double maxSalary = -1; // оклад не может быть отрицательным
        int n = -1;
        for (int i = 1; i < this.eList.length; i++) {
            if (this.eList[i] == null) continue;
            if (this.eList[i].getSalary() > maxSalary) {
                maxSalary = this.eList[i].getSalary();
                n = i;
            }
        }
        return n;
    }

    public int findMaxSalary(int dep) { // индекс сотрудника с min зарплатой в отделе dep
        double maxSalary = -1;
        int n = -1;
        for (int i = 1; i < this.eList.length; i++) {
            if (this.eList[i] == null) continue;
            if (this.eList[i].getDepartment() == dep) {
                if (this.eList[i].getSalary() > maxSalary) {
                    maxSalary = this.eList[i].getSalary();
                    n = i;
                }
            }
        }
        return n;
    }

    public void indexSalary(double value) { //индексация зарплаты на value%
        for (Employee employee : this.eList) {
            if (employee == null) continue;
            employee.setSalary(employee.getSalary() * (100 + value) / 100);
        }
    }

    public void findLessList(double value) { // вывод сотрудников с зарплатой меньше value
        int count = 0;
        for (int i = 1; i < this.eList.length; i++) {
            if (this.eList[i] == null) continue;
            if (this.eList[i].getSalary() < value) {
                printEmployee(i);
                count++;
            }
        }
        if (count == 0) printEmployee(-1);
    }

    public void findMoreList(double value) { // вывод сотрудников с зарплатой больше value
        int count = 0;
        for (int i = 1; i < this.eList.length; i++) {
            if (this.eList[i] == null) continue;
            if (this.eList[i].getSalary() >= value) {
                printEmployee(i);
                count++;
            }
        }
        if (count == 0) printEmployee(-1);
    }

    public void deleteEmployee(String name) { // Удаление сотрудника
        int n = checkName(name); // Проверка совпадений имени
        if (n < 0) return;
        this.eList[n] = null;
        System.out.println("Сотрудник " + name + " удален");
    }

    public void deleteEmployee(int id) { // Удаление по id
        for (int i = 1; i < this.eList.length; i++) {
            if (this.eList[i] == null) continue;
            if (this.eList[i].getId() == id) {
                this.eList[i] = null;
                System.out.println("Сотрудник id:" + id + " удален");
                return;
            }
        }
        System.out.println("Сотрудник id:" + id + " не найден");
    }

    public void newEmployee(String name, int dep, double salary) { // Добавление сотрудника
        for (int i = 1; i < this.eList.length; i++) {
            if (this.eList[i] == null) {
                this.eList[i] = new Employee(name, dep, salary);
                return;
            }
        }
        System.out.println("Добавление ещё одного сотрудника не предусмотренно"); // массив (пока) расширять не будем
    }

    public void setDepartment(String name, int newDep) { // изменение отдела
        int n = checkName(name);
        if (n < 0) return;
        this.eList[n].setDepartment(newDep);
        System.out.println("Сотрудник " + name + " переведен в отдел " + newDep);
    }

    public void setSalary(String name, double newSalary) { // изменение зарплаты
        int n = checkName(name);
        if (n < 0) return;
        this.eList[n].setSalary(newSalary);
        System.out.println("Новая зарплата сотрудника " + name + " : " + newSalary);
    }

    private int checkName(String name) { // проверка совпадений по Ф.И.О.
        int count = 0, n = 0;
        for (int i = 1; i < this.eList.length; i++) {
            if (this.eList[i] == null) continue;
            if (this.eList[i].getFullName().equals(name)) {
                n = i;
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Совпадений Ф.И.О не найдено");
            return -1;
        } else if (count > 1) {
            System.out.println("Найдены полные тезки, уточните запрос");
            return -1;
        }
        return n;
    }

    public void printDepList() { // Список Ф. И. О. всех сотрудников по отделам
        for (int i = 1; i < 6; i++) {
            System.out.println("Отдел " + i);
            int count = 0;
            for (Employee employee : this.eList) {
                if (employee == null) continue;
                if (employee.getDepartment() != i) continue;
                System.out.println(employee.getFullName());
                count++;
            }
            if (count == 0) printEmployee(-1);
        }

    }
}


