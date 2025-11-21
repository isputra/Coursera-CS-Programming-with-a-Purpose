public class RightTriangle {
    public static void main(String[] args) {
        long a = Long.parseLong(args[0]);
        long b = Long.parseLong(args[1]);
        long c = Long.parseLong(args[2]);

        long aSquare = a * a;
        long bSquare = b * b;
        long cSquare = c * c;
        boolean arePositive = (a > 0 && b > 0 && c > 0);
        boolean isRightTriangle = (aSquare == bSquare + cSquare || bSquare == aSquare + cSquare
                || cSquare == aSquare + bSquare);
        boolean result = arePositive && isRightTriangle;

        System.out.println(result);
    }
}
