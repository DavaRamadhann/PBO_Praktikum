// Nama File: MataKuliahService.java
package id.ac.polban.service;

import id.ac.polban.model.MataKuliah;

public class MataKuliahService {

    /**
     * Method untuk menambahkan mahasiswa ke sebuah mata kuliah.
     * Ini adalah contoh relasi DEPENDENCY, di mana MataKuliahService
     * bergantung pada objek MataKuliah untuk dapat bekerja.
     * @param mk Objek MataKuliah yang akan diubah.
     * @param namaMahasiswa Nama mahasiswa yang akan ditambahkan.
     */
    public void tambahMahasiswa(MataKuliah mk, String namaMahasiswa) {
        if (!mk.getDaftarMahasiswa().contains(namaMahasiswa)) {
            mk.getDaftarMahasiswa().add(namaMahasiswa);
            System.out.println("'" + namaMahasiswa + "' berhasil ditambahkan ke mata kuliah " + mk.getNamaMk() + ".");
        } else {
            System.out.println("'" + namaMahasiswa + "' sudah terdaftar di mata kuliah " + mk.getNamaMk() + ".");
        }
    }

    /**
     * Method untuk menampilkan informasi lengkap dari sebuah mata kuliah.
     * Ini juga merupakan contoh relasi DEPENDENCY.
     * @param mk Objek MataKuliah yang informasinya akan ditampilkan.
     */
    public void tampilkanInfo(MataKuliah mk) {
        System.out.println("==============================");
        System.out.println("   INFORMASI MATA KULIAH");
        System.out.println("==============================");
        System.out.println("Kode Mata Kuliah : " + mk.getKodeMk());
        System.out.println("Nama Mata Kuliah : " + mk.getNamaMk());
        System.out.println("Jumlah SKS       : " + mk.getSks());
        System.out.println("Dosen Pengampu   : " + mk.getNamaDosen());
        System.out.println("------------------------------");
        System.out.println("Daftar Mahasiswa:");
        if (mk.getDaftarMahasiswa().isEmpty()) {
            System.out.println("- Belum ada mahasiswa yang terdaftar.");
        } else {
            for (int i = 0; i < mk.getDaftarMahasiswa().size(); i++) {
                System.out.println((i + 1) + ". " + mk.getDaftarMahasiswa().get(i));
            }
        }
        System.out.println("==============================\n");
    }
}