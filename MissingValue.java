/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 26, 2025
 **************************************************************************** */

public class MissingValue {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (StdIn.isEmpty()) {
            StdOut.println("no distinct value");
            return;
        }
        int[] mapValues = new int[n + 1];
        for (int i = 1; i < n; i++) {
            int value = StdIn.readInt();
            if (value < 1 || value > n) {
                System.out.printf("Value entered must be between 1 and %d\n", n);
                System.exit(1);
            }
            mapValues[value]++;
        }
        for (int i = 1; i < n + 1; i++) {
            if (mapValues[i] == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

    }
}
