/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 23, 2025
 **************************************************************************** */

public class BinomialCoefficients {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[][] a = new double[n + 1][];
        for (int i = 0; i < n + 1; i++) {
            a[i] = new double[i + 2];
        }
        a[1][1] = 1.0;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                a[i][j] = (a[i - 1][j] + a[i - 1][j - 1]) / 2;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                System.out.printf("%1.2f ", a[i][j]);
            }
            System.out.println();
        }
    }
}
