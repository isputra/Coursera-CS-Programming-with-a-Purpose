/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 23, 2025
 **************************************************************************** */

public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = args.length - 1;
        int[] a = new int[n + 1];
        a[0] = 0;
        int[] s = new int[n + 1];
        s[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            a[i] = Integer.parseInt(args[i]);
            for (int j = 1; j < i + 1; j++) {
                s[i] += a[j];
            }
        }
        int[] dist = new int[m];
        for (int i = 0; i < m; i++) {
            int r = (int) (s[n] * Math.random());

            int index = 1;
            for (int j = index; j < n + 2; j++) {
                index = j;
                if (r < s[j]) {
                    break;
                }
            }
            dist[i] = index;
        }

        for (int i = 0; i < m; i++) {
            System.out.printf("%-2d ", dist[i]);
        }
    }
}
