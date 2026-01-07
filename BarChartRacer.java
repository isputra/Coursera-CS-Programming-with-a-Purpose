/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     January 6, 2025
 **************************************************************************** */

import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        String filename = args[0];
        int k = Integer.parseInt(args[1]);
        In in = new In(filename);
        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();
        // create the bar chart
        BarChart chart = new BarChart(title, xAxis, source);

        // draw the bar chart
        // StdAudio.playInBackground("bar_chart_race_music.wav");
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        while (in.hasNextLine()) {
            in.readLine();
            int size = Integer.parseInt(in.readLine());
            Bar[] bars = new Bar[size];
            for (int i = 0; i < size; i++) {
                String line = in.readLine();
                if (!line.isEmpty()) {
                    String[] data = line.split(",");
                    if (data.length > 1) {
                        String caption = data[0];
                        String name = data[1];
                        int value = Integer.parseInt(data[3]);
                        String category = data[4];
                        bars[i] = new Bar(name, value, category);
                        chart.setCaption(caption);
                    }
                }
            }
            Arrays.sort(bars);
            int barChartSize = Math.min(size, k);
            for (int i = size - 1; i >= size - barChartSize; i--) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            chart.reset();
            StdDraw.clear();
        }
    }
}
