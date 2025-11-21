public class GreatCircle {
    public static void main(String[] args) {
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));
        double r = 6371.0;

        double a = Math.sin((x1 - x2) / 2);
        double aa = a * a;
        double b = Math.cos(x1) * Math.cos(x2);
        double c = Math.sin((y2 - y1) / 2);
        double cc = c * c;
        double distance = 2 * r * Math.asin(Math.sqrt(aa + (b * cc)));

        System.out.print(distance);
        System.out.print(" kilometers");
    }
}
