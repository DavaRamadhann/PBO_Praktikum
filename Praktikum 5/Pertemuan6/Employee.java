package Pertemuan6;

public class Employee extends Sortable { // extends Sortable
    private String name;
    private double salary;
    private int hireday;
    private int hiremonth;
    private int hireyear;

    public Employee(String n, double s, int day, int month, int year) {
        name = n;
        salary = s;
        hireday = day;
        hiremonth = month;
        hireyear = year;
    }

    public void print() {
        System.out.println("Name: " + name + ", Salary: " + salary + ", Hire Year: " + hireYear());
    }

    public void raiseSalary(double byPercent) {
        salary *= 1 + byPercent / 100;
    }

    public int hireYear() {
        return hireyear;
    }

    // Implementasi method abstract dari Sortable
    @Override
    public int compare(Sortable b) {
        Employee eb = (Employee) b; // Downcasting
        if (this.salary < eb.salary) {
            return -1; // lebih kecil
        }
        if (this.salary > eb.salary) {
            return 1; // lebih besar
        }
        return 0; // sama
    }
}