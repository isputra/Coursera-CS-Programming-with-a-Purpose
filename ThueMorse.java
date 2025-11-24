/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 23, 2025
 **************************************************************************** */

public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int pmax = 0; // get the upper bound of the power of 2 of the input
        while ((int) (Math.pow(2, pmax)) < n) {
            pmax++;
        }
        int max = (int) (Math.pow(2, pmax));
        boolean[] sequence = new boolean[max];
        for (int p = 0; p < pmax; p++) {
            int iLower = (int) (Math.pow(2, p));
            int iUpper = (int) (Math.pow(2, p + 1));
            for (int i = iLower; i < iUpper; i++) {
                sequence[i] = !sequence[i - iLower];
            }
        }
        char[][] weave = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (sequence[i] == sequence[j]) {
                    weave[i][j] = '+';
                }
                else {
                    weave[i][j] = '-';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%s  ", weave[i][j]);
            }
            System.out.println();
        }
    }
}
