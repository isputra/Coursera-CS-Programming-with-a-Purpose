/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     December 3, 2025
 **************************************************************************** */

public class Combinations {
    public static void subset(int n, char c, String s) {
        if (n == 0) {
            return;
        }
        subset(n - 1, (char) (c + 1), s + String.valueOf((char) (c + 1)));
        subset(n - 1, (char) (c + 1),
               s.substring(0, s.length() - 1) + String.valueOf((char) (c + 1)));
        System.out.printf("%s ", s);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        char c = 'a';
        subset(n, c, String.valueOf(c));
    }
}
