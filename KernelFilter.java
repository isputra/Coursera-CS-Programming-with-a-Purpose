/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     December 21, 2025
 **************************************************************************** */

import java.awt.Color;

public class KernelFilter {
    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        double[][] weights = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        double[][] weights = {
                { (double) 1 / 16, (double) 2 / 16, (double) 1 / 16 },
                { (double) 2 / 16, (double) 4 / 16, (double) 2 / 16 },
                { (double) 1 / 16, (double) 2 / 16, (double) 1 / 16 },
                };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        double[][] weights = {
                { 0, -1, 0 },
                { -1, 5, -1 },
                { 0, -1, 0 },
                };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        double[][] weights = {
                { -1, -1, -1 },
                { -1, 8, -1 },
                { -1, -1, -1 },
                };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        double[][] weights = {
                { -2, -1, 0 },
                { -1, 1, 1 },
                { 0, 1, 2 },
                };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        double[][] weights = {
                { (double) 1 / 9, 0, 0, 0, 0, 0, 0, 0, 0, },
                { 0, (double) 1 / 9, 0, 0, 0, 0, 0, 0, 0, },
                { 0, 0, (double) 1 / 9, 0, 0, 0, 0, 0, 0, },
                { 0, 0, 0, (double) 1 / 9, 0, 0, 0, 0, 0, },
                { 0, 0, 0, 0, (double) 1 / 9, 0, 0, 0, 0, },
                { 0, 0, 0, 0, 0, (double) 1 / 9, 0, 0, 0, },
                { 0, 0, 0, 0, 0, 0, (double) 1 / 9, 0, 0, },
                { 0, 0, 0, 0, 0, 0, 0, (double) 1 / 9, 0, },
                { 0, 0, 0, 0, 0, 0, 0, 0, (double) 1 / 9, },
                };
        return kernel(picture, weights);
    }

    // Returns a new picture that applies an arbitrary kernel filter to the given picture.
    private static Picture kernel(Picture picture, double[][] weights) {
        Picture newPicture = new Picture(picture.width(), picture.height());
        int wiMax = weights.length;
        int wjMax = weights[0].length;
        int offsetWi = (wiMax - 1) / 2;
        int offsetWj = (wjMax - 1) / 2;
        int iMax = picture.height();
        int jMax = picture.width();
        for (int i = 0; i < iMax; i++) {
            for (int j = 0; j < jMax; j++) {
                double red = 0, green = 0, blue = 0;
                for (int wi = 0; wi < wiMax; wi++) {
                    for (int wj = 0; wj < wjMax; wj++) {
                        int col = Math.floorMod(j + wj - offsetWj, jMax);
                        int row = Math.floorMod(i + wi - offsetWi, iMax);
                        Color color = picture.get(col, row);
                        red = red + (color.getRed() * weights[wi][wj]);
                        green = green + (color.getGreen() * weights[wi][wj]);
                        blue = blue + (color.getBlue() * weights[wi][wj]);
                    }
                }
                newPicture.set(j, i, new Color(normalizeRGB(red), normalizeRGB(green),
                                               normalizeRGB(blue)));
            }
        }
        return newPicture;
    }

    private static int normalizeRGB(double valueDouble) {
        int value = (int) Math.round(valueDouble);
        if (value < 0) value = 0;
        else if (value > 255) value = 255;
        return value;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        String filename = args[0];
        Picture picture = new Picture(filename);
        identity(picture).show();
        gaussian(picture).show();
        sharpen(picture).show();
        laplacian(picture).show();
        emboss(picture).show();
        motionBlur(picture).show();
    }
}
