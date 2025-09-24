package Pertemuan6;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);
        staff[1] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[2] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);

        System.out.println("--- Before Sorting ---");
        for (Employee e : staff) {
            e.print();
        }
        
        // Memanggil method static shell_sort dari kelas Sortable
        Sortable.shell_sort(staff);

        System.out.println("\n--- After Sorting by Salary ---");
        for (Employee e : staff) {
            e.print();
        }
    }
}   