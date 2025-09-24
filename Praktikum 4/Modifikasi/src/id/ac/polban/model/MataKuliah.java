// Nama File: MataKuliah.java
package id.ac.polban.model;

import java.util.ArrayList;
import java.util.List;

public class MataKuliah {
    // Atribut diubah ke protected agar dapat diakses oleh subclass
    protected String kodeMk;
    protected String namaMk;
    protected int sks;
    protected String namaDosen;
    protected List<String> daftarMahasiswa;
    
    private static int jumlahMataKuliah = 0;

    public MataKuliah(String kodeMk, String namaMk, int sks, String namaDosen) {
        this.kodeMk = kodeMk;
        this.namaMk = namaMk;
        this.sks = sks;
        this.namaDosen = namaDosen;
        this.daftarMahasiswa = new ArrayList<>();
        jumlahMataKuliah++;
        System.out.println("INFO: Objek MataKuliah ke-" + jumlahMataKuliah + " berhasil dibuat.");
    }

    /**
     * Method ini akan di-override oleh subclass untuk memberikan informasi
     * spesifik mengenai lokasi atau jenis mata kuliah.
     * @return String deskripsi lokasi default.
     */
    public String getLokasiPembelajaran() {
        return "Lokasi: Ruang Kelas Umum";
    }

    // --- Getter dan Setter lainnya (tidak berubah) ---
    public String getKodeMk() { return this.kodeMk; }
    public String getNamaMk() { return this.namaMk; }
    public int getSks() { return this.sks; }
    public String getNamaDosen() { return this.namaDosen; }
    public List<String> getDaftarMahasiswa() { return this.daftarMahasiswa; }

    public void setNamaDosen(String dosenBaru) {
        this.namaDosen = dosenBaru;
        System.out.println("INFO: Dosen untuk MK " + this.namaMk + " telah diubah menjadi " + dosenBaru + ".");
    }
    
    public static int getJumlahMataKuliah() {
        return jumlahMataKuliah;
    }
}