/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     December 15, 2025
 **************************************************************************** */

public class Ramanujan {
    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        long max = (long) Math.cbrt(n);
        int count = 0;
        for (long a = 0; a < max + 1; a++) {
            double bDouble = Math.cbrt(n - a * a * a);
            if (bDouble % 1 == 0) {
                // System.out.printf("%d=%d^3+%.0f^3\n", n, a, bDouble);
                count++;
            }
        }

        return count / 2 > 1;
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        System.out.println(isRamanujan(n));
    }
}
