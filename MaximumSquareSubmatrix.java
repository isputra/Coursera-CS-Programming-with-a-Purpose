/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     December 15, 2025
 **************************************************************************** */

public class MaximumSquareSubmatrix {
    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int size = a.length;
        int[][] counts = new int[size][size];
        int max = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (a[i][j] == 1) {
                    counts[i][j] = 1;
                    if (i - 1 >= 0 && j - 1 >= 0 && counts[i - 1][j - 1] > 0) {
                        int n = 0;
                        while (n < counts[i - 1][j - 1]) {
                            n++;
                            if (a[i][j - n] == 0 || a[i - n][j] == 0) {
                                n--;
                                break;
                            }
                        }
                        counts[i][j] = n + 1;
                    }
                    max = Math.max(max, counts[i][j]);
                }
            }
        }
        return max;
    }
    /*
    public static int size2(int[][] a) {
        int size = a.length;
        int[][] counts = new int[size][size];
        int max = 0;
        for (int i = size - 1; i >= 0; i--) {
            for (int j = size - 1; j >= 0; j--) {
                if (a[i][j] == 1) {
                    counts[i][j] = 1 + count(a, i - 1, j - 1, 1);
                    max = Math.max(max, counts[i][j]);
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d ", counts[i][j]);
            }
            System.out.println();
        }

        return max;
    }

    private static int count(int[][] a, int iMin, int jMin, int delta) {
        if (iMin < 0 || jMin < 0) return 0;
        if (a[iMin][jMin] == 0) return 0;
        int n = 1;
        while (n <= delta) {
            if (a[iMin][jMin + n] == 0 || a[iMin + n][jMin] == 0) return 0;
            n++;
        }

        return 1 + count(a, iMin - 1, jMin - 1, delta + 1);
    }
    */

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int[] input = StdIn.readAllInts();
        int size = input[0];
        int[][] a = new int[size][size];
        for (int idx = 1; idx < input.length; idx++) {
            int i = (idx - 1) / size;
            int j = (idx - 1) % size;
            a[i][j] = input[idx];
        }
        System.out.println(size(a));
    }
}
