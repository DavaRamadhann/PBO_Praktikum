// Nama File: MainApp.java
import id.ac.polban.service.MataKuliahService;
import id.ac.polban.model.MataKuliah;

public class MainApp {
    public static void main(String[] args) {
        // Membuat service object
        MataKuliahService service = new MataKuliahService();

        System.out.println(">>> Membuat objek mata kuliah pertama...");
        MataKuliah mkPemrograman = new MataKuliah("25IF2113", "Pemrograman Berorientasi Objek (Praktek)", 2, "Ardhian Ekawijana");

        System.out.println("\n>>> Menambahkan mahasiswa ke MK Pemrograman Berorientasi Objek (Praktek)...");
        service.tambahMahasiswa(mkPemrograman, "Dava Ramadhan");
        service.tambahMahasiswa(mkPemrograman, "Anggitha Safitri");
        service.tambahMahasiswa(mkPemrograman, "Abdan Syakuro");

        System.out.println("\n>>> Menampilkan informasi lengkap MK pertama...");
        service.tampilkanInfo(mkPemrograman);

        System.out.println("====================================================\n");

        System.out.println(">>> Membuat objek mata kuliah kedua...");
        MataKuliah mkPBOT = new MataKuliah("25IF2113", "Pemrograman Berorientasi Objek (Teori)", 2, "Zulkifli Arsyad");

        System.out.println("\n>>> Menambahkan mahasiswa ke MK Pemrograman Berorientasi Objek (Teori)...");
        service.tambahMahasiswa(mkPBOT, "Najwa Sintia");
        service.tambahMahasiswa(mkPBOT, "Fandi Baskara");

        System.out.println("\n>>> Menampilkan informasi lengkap MK kedua...");
        service.tampilkanInfo(mkPBOT);

        System.out.println(">>> Melakukan perubahan data dosen pada MK Pemrograman Berorientasi Objek (Praktek)...");
        mkPemrograman.setNamaDosen("Zulkifli Arsyad");

        System.out.println("\n>>> Menampilkan kembali informasi MK pertama setelah diubah...");
        service.tampilkanInfo(mkPemrograman);
        
        System.out.println("\n>>> Menampilkan jumlah total objek MataKuliah yang telah dibuat...");
        System.out.println("Total Mata Kuliah: " + MataKuliah.getJumlahMataKuliah());
    }
}