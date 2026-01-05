/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     January 5, 2026
 **************************************************************************** */

public class ColorHSB {
    private static final int MAX_HUE = 359;
    private static final int MAX_SATURATION = 100;
    private static final int MAX_BRIGHTNESS = 100;
    private final int hue;
    private final int saturation;
    private final int brightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > MAX_HUE)
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        if (s < 0 || s > MAX_SATURATION)
            throw new IllegalArgumentException("the saturation must be between 0 and 100");
        if (b < 0 || b > MAX_BRIGHTNESS)
            throw new IllegalArgumentException("the brightness must be between 0 and 100");
        hue = h;
        saturation = s;
        brightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return String.format("(%d, %d, %d)", hue, saturation, brightness);
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        if (saturation == 0 || brightness == 0) return true;
        return false;
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        int hDist = Math.min((int) Math.pow(hue - that.hue, 2),
                             (int) Math.pow(360 - Math.abs(hue - that.hue), 2));
        int sDist = (int) Math.pow(saturation - that.saturation, 2);
        int bDist = (int) Math.pow(brightness - that.brightness, 2);
        return hDist + sDist + bDist;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int hue = Integer.parseInt(args[0]);
        int saturation = Integer.parseInt(args[1]);
        int brightness = Integer.parseInt(args[2]);

        ColorHSB colorHSB = new ColorHSB(hue, saturation, brightness);
        String closestColorName = "";
        int closestDistance = Integer.MAX_VALUE;
        ColorHSB closestColorHSB = new ColorHSB(hue, saturation, brightness);
        while (!StdIn.isEmpty()) {
            String name = StdIn.readString();
            int h = StdIn.readInt();
            int s = StdIn.readInt();
            int b = StdIn.readInt();
            ColorHSB otherColorHSB = new ColorHSB(h, s, b);
            int newDistance = colorHSB.distanceSquaredTo(otherColorHSB);
            if (closestDistance > newDistance) {
                closestDistance = newDistance;
                closestColorName = name;
                closestColorHSB = otherColorHSB;
            }
        }

        System.out.printf("%s %s\n", closestColorName, closestColorHSB.toString());
    }
}
