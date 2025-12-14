/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     December 4, 2025
 **************************************************************************** */

public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        if (Math.abs(k) > n) return 0L; // outside valid range

        int size = 2 * n + 1;          // indices 0 .. 2n correspond to k = -n .. +n
        long[][] dp = new long[n + 1][size];

        // Base case T(0,0) -> index 0 + n = n
        dp[0][n] = 1L;

        // Build bottom-up
        for (int i = 1; i <= n; i++) {
            // only k in [-i, i] can be nonzero at row i
            int start = n - i;    // index corresponding to k = -i
            int end = n + i;    // index corresponding to k = +i
            for (int idx = start; idx <= end; idx++) {
                long sum = 0L;
                // dp[i-1][idx-1] if valid
                if (idx - 1 >= 0) sum += dp[i - 1][idx - 1];
                // dp[i-1][idx]
                sum += dp[i - 1][idx];
                // dp[i-1][idx+1] if valid
                if (idx + 1 < size) sum += dp[i - 1][idx + 1];
                dp[i][idx] = sum;
            }
        }

        return dp[n][k + n];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}
