// Nama File: MataKuliah.java
package id.ac.polban.model;

import java.util.ArrayList;
import java.util.List;

public class MataKuliah {
    // Atribut dibuat private untuk enkapsulasi
    private String kodeMk;
    private String namaMk;
    private int sks;
    private String namaDosen;
    private List<String> daftarMahasiswa;
    
    // Variabel static untuk menghitung jumlah objek MataKuliah yang dibuat
    private static int jumlahMataKuliah = 0;

    /**
     * Constructor untuk class MataKuliah.
     * @param kodeMk Kode unik mata kuliah.
     * @param namaMk Nama lengkap mata kuliah.
     * @param sks Jumlah SKS.
     * @param namaDosen Nama dosen pengampu.
     */
    public MataKuliah(String kodeMk, String namaMk, int sks, String namaDosen) {
        this.kodeMk = kodeMk;
        this.namaMk = namaMk;
        this.sks = sks;
        this.namaDosen = namaDosen;
        this.daftarMahasiswa = new ArrayList<>();
        jumlahMataKuliah++; // Setiap kali objek dibuat, counter bertambah
        System.out.println("INFO: Objek MataKuliah ke-" + jumlahMataKuliah + " berhasil dibuat.");
    }

    // Getter methods
    public String getKodeMk() { return this.kodeMk; }
    public String getNamaMk() { return this.namaMk; }
    public int getSks() { return this.sks; }
    public String getNamaDosen() { return this.namaDosen; }
    public List<String> getDaftarMahasiswa() { return this.daftarMahasiswa; }

    // Setter method
    public void setNamaDosen(String dosenBaru) {
        this.namaDosen = dosenBaru;
        System.out.println("INFO: Dosen untuk MK " + this.namaMk + " telah diubah menjadi " + dosenBaru + ".");
    }

    // Method static untuk mendapatkan jumlah total mata kuliah
    public static int getJumlahMataKuliah() {
        return jumlahMataKuliah;
    }
}