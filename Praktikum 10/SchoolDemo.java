// SchoolDemo.java

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class SchoolDemo {

    public static void main(String[] args) {

        // ==========================================================
        // Tugas 1.2: ArrayList dan Sorting
        // ==========================================================
        System.out.println("--- Bagian 1: ArrayList (Sort By Name) ---");

        // Membuat 5 objek Student
        Student s1 = new Student("S001", "Budi", 101, "Computer Science", "Bandung");
        Student s2 = new Student("S002", "Eka", 102, "Electrical Engineering", "Jakarta");
        Student s3 = new Student("S003", "Ani", 101, "Computer Science", "Surabaya");
        Student s4 = new Student("S004", "Deni", 103, "Mechanical Engineering", "Medan");
        Student s5 = new Student("S005", "Citra", 102, "Electrical Engineering", "Yogyakarta");

        // Membuat ArrayList dan menambahkan 5 student
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);

        // Menampilkan data SEBELUM di-sort
        System.out.println("\nData (Sebelum diurutkan):");
        for (Student s : studentList) {
            System.out.println(s);
        }

        // Melakukan sorting berdasarkan nama (menggunakan compareTo di kelas Student)
        Collections.sort(studentList);

        // Menampilkan data SETELAH di-sort
        System.out.println("\nData (Setelah diurutkan berdasarkan nama):");
        for (Student s : studentList) {
            System.out.println(s);
        }

        // ==========================================================
        // Tugas 1.3: Vector dan Filtering
        // ==========================================================
        System.out.println("\n\n--- Bagian 2: Vector (Filter by Department) ---");

        // Membuat 5 objek Student (bisa menggunakan objek yang sama atau baru)
        // Kita gunakan objek yang sama untuk contoh ini.
        Vector<Student> studentVector = new Vector<>();
        studentVector.add(s1); // Computer Science
        studentVector.add(s2); // Electrical Engineering
        studentVector.add(s3); // Computer Science
        studentVector.add(s4); // Mechanical Engineering
        studentVector.add(s5); // Electrical Engineering

        // Menampilkan student yang ada di "Computer Science"
        System.out.println("\nSiswa di jurusan 'Computer Science':");
        for (Student s : studentVector) {
            // Memfilter berdasarkan nama departemen
            if (s.getDepartmentName().equalsIgnoreCase("Computer Science")) {
                System.out.println(s);
            }
        }
    }
}