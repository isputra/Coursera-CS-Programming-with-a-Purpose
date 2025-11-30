/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 29, 2025
 **************************************************************************** */

public class FunctionsAndLibraries {
    public static int lg(int n) {
        if (n < 2)
            return 0;
        int mul = 2;
        int compare = 1;
        while (compare < n) {
            compare = compare * mul;
        }
        return compare / mul;
    }

    public static int[] histogram(int[] a, int m) {
        int[] result = new int[m];
        for (int i = 0; i < a.length; i++) {
            result[a[i]]++;
        }
        return result;
    }

    public static double[] getT() {
        double tMin = Math.toRadians(-10.0);
        double tMax = Math.toRadians(10.0);
        double tInterval = tMax - tMin;
        int tLength = 500;
        double[] t = new double[tLength];
        for (int i = 0; i < tLength; i++) {
            t[i] = tMin + (tInterval * i) / (tLength - 1);
        }
        return t;
    }

    public static double[] fourierSpikes(double[] t, int n) {
        double[] result = new double[t.length];
        for (int i = 0; i < t.length; i++) {
            double sum = 0.0;
            for (int j = 0; j < n; j++) {
                sum += Math.cos(j * t[i]);
            }
            result[i] = sum / n;
        }
        return result;
    }

    public static void drawDiagram(double[] t, double[] y) {
        // rescale the coordinate system
        StdDraw.setXscale(-0.2, +0.2);
        StdDraw.setYscale(-0.3, +1.2);

        // plot the approximation to the function
        for (int i = 0; i < t.length - 1; i++) {
            StdDraw.line(t[i], y[i], t[i + 1], y[i + 1]);
        }
    }

    public static void main(String[] args) {
        // lg
        int[] n1 = { 2, 3, 5, 7, 9, 11, 16, 17, 31, 32, 33, 63, 64, 65 };
        for (int i = 0; i < n1.length; i++) {
            int exp = (int) Math.floor(Math.log(n1[i] - 1) / Math.log(2));
            int largest = (int) Math.pow(2, exp);
            System.out.println("For n=" + n1[i] + " the result is: " + (lg(n1[i]) == largest));
            // System.out.printf("n=%d | lg=%d | Math=%d\n", n1[i], lg(n1[i]), largest);
        }

        // histogram
        System.out.println("***Histogram***");
        int[] a1 = new int[50];
        int m1 = 10;
        for (int i = 0; i < a1.length; i++) {
            a1[i] = (int) (Math.random() * m1);
            System.out.print(a1[i] + " ");
        }
        System.out.println();
        int[] result1 = histogram(a1, m1);
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + " ");
        }
        System.out.println();

        // fourier spike
        System.out.println("***Fourier spike***");
        double[] t = getT();
        double[] y = fourierSpikes(t, 500);

        for (int i = 0; i < y.length; i++) {
            System.out.printf("%.4f ", y[i]);
        }
        drawDiagram(t, y);
        System.out.println();
    }
}
