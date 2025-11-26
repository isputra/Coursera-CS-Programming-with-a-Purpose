/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 27, 2025
 **************************************************************************** */

public class Spirographs {
    public static void main(String[] args) {
        double rLarge = Double.parseDouble(args[0]);
        double rSmall = Double.parseDouble(args[1]);
        double a = Double.parseDouble(args[2]);
        int T = 500;
        double[] x = new double[T + 1];
        double[] y = new double[T + 1];

        for (int t = 0; t <= T; t++) {
            x[t] = (rLarge + rSmall) * Math.cos(t) - (rSmall + a) * Math.cos(
                    (rLarge + rSmall) * t / rSmall);
            y[t] = (rLarge + rSmall) * Math.sin(t) - (rSmall + a) * Math.sin(
                    (rLarge + rSmall) * t / rSmall);
        }
        StdDraw.setXscale(-30.0, 30.0);
        StdDraw.setYscale(-30.0, 30.0);
        for (int t = 0; t < T; t++) {
            StdDraw.line(x[t], y[t], x[t + 1], y[t + 1]);
        }
    }
}
