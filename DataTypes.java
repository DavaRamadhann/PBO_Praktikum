import java.util.Scanner;

/**
 * Solusi untuk Soal 1: Data Types
 * Program ini mengecek tipe data primitif yang bisa menampung angka masukan.
 */
public class DataTypes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Membaca jumlah test case [cite: 28]

        for (int i = 0; i < t; i++) {
            try {
                // Membaca input sebagai long untuk menampung rentang angka yang luas
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");

                // Cek apakah muat di tipe data byte
                if (x >= Byte.MIN_VALUE && x <= Byte.MAX_VALUE) {
                    System.out.println("* byte");
                }
                // Cek apakah muat di tipe data short
                if (x >= Short.MIN_VALUE && x <= Short.MAX_VALUE) {
                    System.out.println("* short");
                }
                // Cek apakah muat di tipe data int
                if (x >= Integer.MIN_VALUE && x <= Integer.MAX_VALUE) {
                    System.out.println("* int");
                }
                // Cek apakah muat di tipe data long (selalu muat jika berhasil dibaca sebagai long)
                if (x >= Long.MIN_VALUE && x <= Long.MAX_VALUE) {
                    System.out.println("* long");
                }
            } catch (Exception e) {
                // Jika input tidak bisa dibaca sebagai long, berarti terlalu besar [cite: 36]
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
        }
        sc.close();
    }
}