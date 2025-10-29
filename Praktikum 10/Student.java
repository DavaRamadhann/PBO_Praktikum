// Student.java

// Mengimpor interface Comparable untuk fungsionalitas sorting
import java.util.Objects;

public class Student implements Comparable<Student> {

    // 1. Atribut (dibuat private untuk enkapsulasi)
    private String studentID;
    private String name;
    private int departmentID;
    private String departmentName;
    private String address;

    // 2. Constructor untuk inisialisasi objek
    public Student(String studentID, String name, int departmentID, String departmentName, String address) {
        this.studentID = studentID;
        this.name = name;
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.address = address;
    }

    // 3. Getter dan Setter (Konsep Enkapsulasi)
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // 4. Override compareTo (untuk sorting berdasarkan nama)
    @Override
    public int compareTo(Student other) {
        // Mengurutkan berdasarkan abjad nama (A-Z)
        return this.name.compareTo(other.name);
    }

    // 5. Override toString (untuk kemudahan saat mencetak objek)
    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}