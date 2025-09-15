// Nama File: MainApp.java
import id.ac.polban.model.MataKuliah;
import id.ac.polban.model.MataKuliahPraktikum;
import id.ac.polban.model.MataKuliahTeori;
import id.ac.polban.service.MataKuliahService; // Untuk mengakses static method

public class MainApp {
    public static void main(String[] args) {
        MataKuliahService service = new MataKuliahService();

        System.out.println(">>> Membuat objek Mata Kuliah Teori (subclass)...");
        MataKuliahTeori mkTeori = new MataKuliahTeori("20IF2110", "Struktur Data (Teori)", 2, "Zulkifli Arsyad", "701A");

        System.out.println("\n>>> Menambahkan mahasiswa ke MK Teori...");
        service.tambahMahasiswa(mkTeori, "Najwa Sintia");
        service.tambahMahasiswa(mkTeori, "Fandi Baskara");

        System.out.println("\n>>> Menampilkan informasi lengkap MK Teori...");
        service.tampilkanInfoLengkap(mkTeori);

        System.out.println("====================================================\n");

        System.out.println(">>> Membuat objek Mata Kuliah Praktikum (subclass)...");
        MataKuliahPraktikum mkPraktikum = new MataKuliahPraktikum("25IF2113", "Pemrograman Berorientasi Objek (Praktek)", 2, "Ardhian Ekawijana", "Laboratorium Komputer 3");

        System.out.println("\n>>> Menambahkan mahasiswa ke MK Praktikum...");
        service.tambahMahasiswa(mkPraktikum, "Dava Ramadhan");
        service.tambahMahasiswa(mkPraktikum, "Anggitha Safitri");
        service.tambahMahasiswa(mkPraktikum, "Abdan Syakuro");
        
        System.out.println("\n>>> Menampilkan informasi lengkap MK Praktikum...");
        service.tampilkanInfoLengkap(mkPraktikum);

        System.out.println(">>> Menampilkan jumlah total objek MataKuliah yang telah dibuat...");
        System.out.println("Total Mata Kuliah: " + MataKuliah.getJumlahMataKuliah());
    }
}