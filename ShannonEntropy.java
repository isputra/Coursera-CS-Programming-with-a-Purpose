/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 27, 2025
 **************************************************************************** */

public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);

        int[] freq = new int[m + 1];
        int count = 0;
        while (!StdIn.isEmpty()) {
            int value = StdIn.readInt();
            if (value <= m) {
                freq[value]++;
                count++;
            }
        }
        double shannon = 0;
        for (int i = 1; i < m + 1; i++) {
            double p = (double) freq[i] / count;
            double plog = 0;
            if (p != 0) {
                plog = p * (Math.log(p) / Math.log(2));
            }
            shannon += plog;
        }
        StdOut.printf("%.4f\n", shannon * -1);
    }
}
