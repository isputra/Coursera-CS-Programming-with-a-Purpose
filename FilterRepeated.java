/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 26, 2025
 **************************************************************************** */

public class FilterRepeated {
    public static void main(String[] args) {
        if (StdIn.isEmpty()) {
            StdOut.println("no repeated value");
            return;
        }

        int previous = StdIn.readInt();
        StdOut.print(previous);
        while (!StdIn.isEmpty()) {
            int current = StdIn.readInt();

            if (previous != current) {
                StdOut.print(current);
                previous = current;
            }
        }
    }
}
