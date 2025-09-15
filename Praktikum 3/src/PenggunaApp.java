// File: ProyekPenggunaJar/src/PenggunaApp.java
import id.ac.polban.model.MataKuliah;
import id.ac.polban.service.MataKuliahService;

public class PenggunaApp {
    public static void main(String[] args) {
        System.out.println(">>> Proyek ini menggunakan library JAR!");

        // Membuat objek dari kelas yang ada di dalam JAR
        MataKuliah mkBaru = new MataKuliah("CS101", "Dasar Ilmu Komputer", 3, "Dr. Elara");
        MataKuliahService service = new MataKuliahService();

        // Menggunakan method dari objek tersebut
        service.tambahMahasiswa(mkBaru, "Budi");
        service.tambahMahasiswa(mkBaru, "Citra");

        service.tampilkanInfo(mkBaru);

        System.out.println("Total Mata Kuliah Dibuat: " + MataKuliah.getJumlahMataKuliah());
    }
}