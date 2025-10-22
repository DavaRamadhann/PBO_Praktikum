public class MathUtils {
    public static int factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Negative integer: " + n);
        if (n > 16)
            throw new IllegalArgumentException("Value too large: " + n);
        int fac = 1;
        for (int i = n; i > 0; i--)
            fac *= i;
        return fac;
    }
}
