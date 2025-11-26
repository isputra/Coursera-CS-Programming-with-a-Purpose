/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 26, 2025
 **************************************************************************** */

import java.awt.Font;

public class Histogram {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);

        double interval = (hi - lo) / n;
        double[] range = new double[n + 1];
        int[] count = new int[n + 1];
        range[0] = lo;

        for (int i = 1; i < n + 1; i++) {
            range[i] = range[i - 1] + interval;
        }

        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            for (int i = 1; i < n + 1; i++) {
                if (value < range[i]) {
                    count[i - 1]++;
                    break;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n + 1; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.printf("%d : %f => %d\n", i, range[i], count[i]);
        }

        // draw
        double offsetX = hi / n;
        double offsetY = max * 0.1;
        double maxX = hi + offsetX * 2;
        double maxY = max + offsetY * 2;
        StdDraw.setTitle("Histogram");
        StdDraw.setCanvasSize(800, 400);
        StdDraw.setXscale(0, maxX);
        StdDraw.setYscale(0, maxY);
        StdDraw.line(0, offsetY, maxX, offsetY);
        StdDraw.line(offsetX, 0, offsetX, maxY);
        Font font = new Font("Sans Serif", Font.PLAIN, 10);
        StdDraw.setFont(font);

        for (int i = 0; i < max; i++) {
            StdDraw.line(offsetX * 0.8, offsetY + i + 1, offsetX, offsetY + i + 1);
            StdDraw.text(offsetX * 0.6, offsetY + i + 1, String.format("%d", i + 1));
        }

        for (int i = 0; i < n; i++) {
            double midX = offsetX + (range[i] + range[i + 1]) / 2;
            double midY = offsetY + (double) count[i] / 2;
            StdDraw.setPenRadius(0.005);
            StdDraw.setPenColor(0, 0, 0);
            StdDraw.line(offsetX + range[i + 1], offsetY * 0.9, offsetX + range[i + 1], offsetY);
            StdDraw.text(offsetX + range[i + 1], offsetY / 2, String.format("%.2f", range[i + 1]));
            StdDraw.rectangle(midX, midY, interval / 2, (double) count[i] / 2);
            StdDraw.setPenColor(0, 127, (255 / n) * i);
            StdDraw.filledRectangle(midX, midY, (interval / 2) * 0.95, (double) count[i] / 2);
        }
    }
}
