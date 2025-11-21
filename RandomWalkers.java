/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 21, 2025
 **************************************************************************** */

public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        long total = 0;

        for (int t = 0; t < trials; t++) {
            int x = 0;
            int y = 0;
            int steps = 0;

            while (Math.abs(x) + Math.abs(y) < r) {
                double probs = Math.random();
                if (probs < 0.25) {
                    x++;
                }
                else if (probs < 0.5) {
                    y++;
                }
                else if (probs < 0.75) {
                    x--;
                }
                else {
                    y--;
                }
                steps++;
            }
            total += steps;
        }
        System.out.println("average number of steps = " + (double) total / trials);
    }
}
