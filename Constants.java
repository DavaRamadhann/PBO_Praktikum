/**
 * Solusi untuk Soal 2: Constants.
 * Menggunakan variabel final lokal di dalam method.
 */
public class Constants {
    public static void main(String[] args) {
        // Variabel final lokal, hanya berlaku di dalam method main
        final double CM_PER_INCH = 2.54;
        double paperWidth = 8.5;
        double paperHeight = 11;
        System.out.println("Paper size in centimeters: " +
                paperWidth * CM_PER_INCH + " by " + paperHeight * CM_PER_INCH);
    }
}