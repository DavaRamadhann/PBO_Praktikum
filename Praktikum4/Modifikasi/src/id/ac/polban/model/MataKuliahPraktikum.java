// Nama File: MataKuliahPraktikum.java
package id.ac.polban.model;

/**
 * INHERITANCE: Kelas MataKuliahPraktikum adalah sebuah MataKuliah.
 * Merepresentasikan mata kuliah yang fokus pada praktek di laboratorium.
 */
public class MataKuliahPraktikum extends MataKuliah {

    private String namaLaboratorium; // Atribut spesifik: nama lab yang digunakan

    /**
     * Constructor untuk subclass MataKuliahPraktikum.
     */
    public MataKuliahPraktikum(String kodeMk, String namaMk, int sks, String namaDosen, String namaLaboratorium) {
        // SUPER: Memanggil constructor dari superclass (MataKuliah)
        super(kodeMk, namaMk, sks, namaDosen);
        this.namaLaboratorium = namaLaboratorium;
    }
    
    /**
     * OVERRIDE: Memberikan implementasi spesifik untuk method dari superclass.
     * @return String yang menunjukkan lokasi pembelajaran di laboratorium.
     */
    @Override
    public String getLokasiPembelajaran() {
        return "Lokasi: " + this.namaLaboratorium;
    }
}