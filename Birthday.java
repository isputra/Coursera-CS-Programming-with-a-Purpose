/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 24, 2025
 **************************************************************************** */

public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] count = new int[n + 2];
        for (int t = 0; t < trials; t++) {
            boolean[] hasBirthday = new boolean[n];
            boolean next = true;
            int people = 0;
            while (next) {
                people++;
                int day = (int) (Math.random() * n);
                if (hasBirthday[day]) {
                    next = false;
                }
                else {
                    hasBirthday[day] = true;
                }
            }
            count[people]++;
        }
        double fraction = 0.0;
        int k = 1;
        long totalCount = 0;
        while (fraction < 0.5) {
            totalCount += count[k];
            fraction = (double) totalCount / trials;
            System.out.printf("%-2d\t %-5d\t %f\n", k, count[k], fraction);
            k++;
        }

    }
}
