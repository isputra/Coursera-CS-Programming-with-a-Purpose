/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 26, 2025
 **************************************************************************** */

public class LongestRun {
    public static void main(String[] args) {
        if (StdIn.isEmpty()) {
            StdOut.println("no longest consecutive run");
            return;
        }

        int countPrevious = 0;
        int previous = 0;
        int countLongest = 0;
        int longest = 0;
        boolean init = true;
        while (!StdIn.isEmpty()) {
            int current = StdIn.readInt();
            if (init) {
                init = false;
                previous = current;
            }
            if (previous == current) {
                countPrevious++;
            }
            else {
                previous = current;
                countPrevious = 1;
            }
            if (countPrevious > countLongest) {
                longest = previous;
                countLongest = countPrevious;
            }
        }

        System.out.printf("Longest run: %d consecutive %ds", longest, countLongest);
    }
}
