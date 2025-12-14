/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     December 4, 2025
 **************************************************************************** */

public class RevesPuzzle {
    // move n smallest discs from one pole to another, using the temp pole
    private static void move3pole(int n, int k, String from, String temp, String to) {
        if (n < k) return;
        move3pole(n - 1, k, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        move3pole(n - 1, k, temp, from, to);
    }

    private static void move4pole(int n, int k, String from, String temp1, String temp2,
                                  String to, boolean first) {
        if (n == k) return;
        if (first)
            move4pole(k, k + 1 - (int) Math.round(Math.sqrt(2 * k + 1)),
                      from, temp2, to, temp1, true);
        move4pole(n - 1, k, from, to, temp1, temp2, false);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        move4pole(n - 1, k, temp2, temp1, from, to, false);
        if (first)
            move4pole(k, k + 1 - (int) Math.round(Math.sqrt(2 * k + 1)),
                      temp1, temp2, from, to, true);
    }

    private static void move(int n, int k, String from, String temp1, String temp2,
                             String to) {
        int knext = k + 1 - (int) Math.round(Math.sqrt(2 * k + 1));
        move4pole(k, knext, from, to, temp2, temp1, true);
        move3pole(n, k + 1, from, temp2, to);
        move4pole(k, knext, temp1, from, temp2, to, true);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = n + 1 - (int) Math.round(Math.sqrt(2 * n + 1));
        move(n, k, "A", "B", "C", "D");
    }
}
