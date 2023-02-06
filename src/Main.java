public class Main {
    public static void main(String[] args) {
        EmployeeBook eBook = new EmployeeBook();

        System.out.println("Полные данные сотрудников:");
        eBook.printList();
        System.out.println("\nСписок Ф.И.О. сотрудников:");
        eBook.printNameList();
        System.out.println("\nСумма затрат в месяц: " + eBook.calculateTotalSalary());
        System.out.println("\nСумма затрат в месяц в 1-м отделе: " + eBook.calculateTotalSalary(1));
        System.out.println("\nСотрудник с минимальной зарплатой: ");
        eBook.printEmployee(eBook.findMinSalary());
        System.out.println("\nСотрудник с максимальной зарплатой: ");
        eBook.printEmployee(eBook.findMaxSalary());
        System.out.println("\nСотрудник с максимальной зарплатой в 4-м отделе: ");
        eBook.printEmployee(eBook.findMaxSalary(4));
        System.out.println("\nСотрудник с минимальной зарплатой в 5-м отделе: ");
        eBook.printEmployee(eBook.findMinSalary(5));
        System.out.println("\nСредняя зарплата: " + eBook.calculateAverageSalary());
        System.out.println("\nСредняя зарплата в 3-м отделе: " + eBook.calculateAverageSalary(3));
        System.out.println("\nИндексация на 15 %");
        eBook.indexSalary(15);
        eBook.printList();
        System.out.println("\nСотрудники с зарплатой меньше 5 000:");
        eBook.findLessList(5_000);
        System.out.println("\nСотрудники с зарплатой от 150 000:");
        eBook.findMoreList(150000);
        System.out.println("\nУдаление сотрудников и добавление новых");
        eBook.deleteEmployee(12);
        eBook.deleteEmployee(10);
        eBook.deleteEmployee(7);
        eBook.newEmployee("Алексеев Алексей Алексеевич", 3, 123123);
        eBook.newEmployee("Иван Иванович Иванов", 5, 123456);
        eBook.printList();
        eBook.deleteEmployee("Алексеев Алексей Алексеевич");
        System.out.println("\nИзменение отдела и зарплаты");
        eBook.setDepartment("Иван Иванович Иванов", 1);
        eBook.setSalary("Иван Иванович Иванов", 100_000);
        eBook.printList();
        System.out.println("\nВывод по отделам");
        eBook.printDepList();
    }
}