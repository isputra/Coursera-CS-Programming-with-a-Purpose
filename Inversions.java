/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     December 15, 2025
 **************************************************************************** */

public class Inversions {
    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        int n = a.length;
        long count = 0;
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (a[i] > a[j])
                    count++;
        return count;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] p = new int[n];
        boolean[] pBool = new boolean[n];
        int i = 0;
        while (k > 0) {
            int val = n - i - 1;
            int offset = Math.toIntExact(k > val ? val : k);
            int idx = n - 1 - offset;
            p[idx] = val;
            pBool[idx] = true;
            k = k - val;
            i++;
        }
        int pRem = 0;
        for (int j = 0; j < n; j++) {
            if (!pBool[j]) {
                p[j] = pRem;
                pRem++;
            }
        }
        return p;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        if (k > (long) n * (n - 1) / 2)
            throw new IllegalArgumentException();
        int[] a = generate(n, k);
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.println();
        // System.out.println("Inversion: " + count(a));
    }
}
