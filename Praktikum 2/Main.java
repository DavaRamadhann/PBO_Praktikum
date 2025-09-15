
import java.util.Scanner;

public class Main{
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        String nama, nim, jurusan;
        String namaMataKuliah;
        int jumlahSKS;
        System.out.println("Masukkan Nama Mahasiswa: ");
        nama = scanner.nextLine();
        System.out.println("Masukkan NIM Mahasiswa: ");
        nim = scanner.nextLine();
        System.out.println("Masukkan Jurusan Mahasiswa: ");
        jurusan = scanner.nextLine();
        System.out.println("Masukkan Nama Mata Kuliah: ");
        namaMataKuliah = scanner.nextLine();
        System.out.println("Masukkan Jumlah SKS Mata Kuliah: ");
        jumlahSKS = scanner.nextInt();

        mahasiswa1.TampilkanMahasiswa();
        System.out.println();
        matakuliah1.TampilkanMataKuliah();
    }
}