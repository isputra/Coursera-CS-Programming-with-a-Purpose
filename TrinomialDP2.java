/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     December 3, 2025
 **************************************************************************** */

public class TrinomialDP2 {
    private static final int N_MAX = 100;
    private static final int K_MAX = 100;
    private static long[][] memo = new long[N_MAX][K_MAX];
    private static boolean[][] isMemo = new boolean[N_MAX][K_MAX];
    private static final int OFFSET = N_MAX / 2;
    private static int[][] minmax = new int[N_MAX][2];

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        // System.out.printf("n:%d k:%d\n", n, k);
        minmax[n][0] = Math.min(minmax[n][0], k);
        minmax[n][1] = Math.max(minmax[n][1], k);
        int offsetK = k + OFFSET;
        if (isMemo[n][offsetK]) return memo[n][offsetK];
        if (n == 0 && k == 0) {
            memo[n][offsetK] = 1;
        }
        else if (k < -n || k > n) {
            memo[n][offsetK] = 0;
        }
        else {
            memo[n][offsetK] = trinomial(n - 1, k - 1) + trinomial(n - 1, k)
                    + trinomial(n - 1, k + 1);
        }
        isMemo[n][offsetK] = true;
        return memo[n][offsetK];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        for (int i = 0; i < n + 1; i++) {
            minmax[i][0] = k;
        }
        System.out.println(trinomial(n, k));
        for (int i = n; i >= 0; i--) {
            // System.out.printf("n:%d min:%d max:%d interval:%d\n", i, minmax[i][0], minmax[i][1], minmax[i][1] - minmax[i][0] + 1);
            System.out.printf("%d\t%d\t%d\t%d\n", i, minmax[i][0], minmax[i][1],
                              minmax[i][1] - minmax[i][0] + 1);
        }
    }

}
