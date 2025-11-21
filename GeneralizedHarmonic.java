/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 21, 2025
 **************************************************************************** */

public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double h = 0.0;
        for (int i = 0; i < n; i++) {
            h += 1 / Math.pow(i + 1, r);
        }
        System.out.println(h);
    }
}
