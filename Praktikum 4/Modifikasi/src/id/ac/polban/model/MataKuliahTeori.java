// Nama File: MataKuliahTeori.java
package id.ac.polban.model;

/**
 * INHERITANCE: Kelas MataKuliahTeori adalah sebuah MataKuliah.
 * Merepresentasikan mata kuliah yang fokus pada teori di dalam kelas.
 */
public class MataKuliahTeori extends MataKuliah {

    private String ruangKelas; // Atribut spesifik untuk subclass ini

    /**
     * Constructor untuk subclass MataKuliahTeori.
     */
    public MataKuliahTeori(String kodeMk, String namaMk, int sks, String namaDosen, String ruangKelas) {
        // SUPER: Memanggil constructor dari superclass (MataKuliah)
        super(kodeMk, namaMk, sks, namaDosen);
        this.ruangKelas = ruangKelas;
    }

    /**
     * OVERRIDE: Memberikan implementasi spesifik untuk method dari superclass.
     * @return String yang menunjukkan lokasi pembelajaran di ruang kelas spesifik.
     */
    @Override
    public String getLokasiPembelajaran() {
        return "Lokasi: Ruang Kelas " + this.ruangKelas;
    }
}