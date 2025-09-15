// Nama File: MataKuliahService.java
package id.ac.polban.service;

import id.ac.polban.model.MataKuliah;

public class MataKuliahService {

    public void tambahMahasiswa(MataKuliah mk, String namaMahasiswa) {
        if (!mk.getDaftarMahasiswa().contains(namaMahasiswa)) {
            mk.getDaftarMahasiswa().add(namaMahasiswa);
            System.out.println("'" + namaMahasiswa + "' berhasil ditambahkan ke mata kuliah " + mk.getNamaMk() + ".");
        } else {
            System.out.println("'" + namaMahasiswa + "' sudah terdaftar di mata kuliah " + mk.getNamaMk() + ".");
        }
    }

    /**
     * Method ini menampilkan info lengkap, termasuk lokasi pembelajaran
     * yang diambil secara polimorfik dari objek yang diberikan.
     */
    public void tampilkanInfoLengkap(MataKuliah mk) {
        System.out.println("==============================");
        System.out.println("   INFORMASI MATA KULIAH");
        System.out.println("==============================");
        System.out.println("Kode             : " + mk.getKodeMk());
        System.out.println("Nama             : " + mk.getNamaMk());
        System.out.println("SKS              : " + mk.getSks());
        System.out.println("Dosen            : " + mk.getNamaDosen());
        
        // POLIMORFISME: Memanggil method yang sudah di-override.
        // Java akan otomatis memilih versi yang benar (dari Teori atau Praktikum).
        System.out.println(mk.getLokasiPembelajaran());
        
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