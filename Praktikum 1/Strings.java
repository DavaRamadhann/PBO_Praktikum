import java.util.Scanner;

/**
 * Solusi untuk Soal 5: Strings.
 * Melakukan beberapa operasi pada dua string.
 */
public class Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next(); // Membaca string pertama [cite: 145]
        String B = sc.next(); // Membaca string kedua [cite: 145]
        sc.close();

        // 1. Menjumlahkan panjang kedua string 
        int totalLength = A.length() + B.length();
        System.out.println(totalLength);

        // 2. Membandingkan secara leksikografis [cite: 142]
        // A.compareTo(B) akan menghasilkan nilai > 0 jika A > B
        if (A.compareTo(B) > 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        // 3. Mengapitalisasi huruf pertama dan mencetaknya [cite: 143]
        String capA = A.substring(0, 1).toUpperCase() + A.substring(1);
        String capB = B.substring(0, 1).toUpperCase() + B.substring(1);
        System.out.println(capA + " " + capB);
    }
}