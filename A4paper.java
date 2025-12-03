/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     December 3, 2025
 **************************************************************************** */

public class A4paper {
    public static void cutSheet(int n, double x, double y, double w, double h,
                                boolean isHorizontal) {
        if (n == 0) return;
        if (isHorizontal) {
            StdDraw.line(x + (w / 2), y, x + (w / 2), y + h);
            cutSheet(n - 1, x, y, w / 2, h, !isHorizontal);
            cutSheet(n - 1, x + (w / 2), y, w / 2, h, !isHorizontal);
        }
        else {
            StdDraw.line(x, y + (h / 2), x + w, y + (h / 2));
            cutSheet(n - 1, x, y, w, h / 2, !isHorizontal);
            cutSheet(n - 1, x, y + (h / 2), w, h / 2, !isHorizontal);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double width = 118.9;
        double height = 84.1;
        double x = 0;
        double y = 0;
        StdDraw.setTitle("A0 Paper");
        StdDraw.setCanvasSize(800, 400);
        StdDraw.setXscale(-(width / 10), width + (width / 10));
        StdDraw.setYscale(-(height / 10), height + (height / 10));
        StdDraw.rectangle(x + width / 2, y + height / 2, width / 2, height / 2);
        cutSheet(n, x, y, width, height, true);
    }
}
