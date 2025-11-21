/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 21, 2025
 **************************************************************************** */

public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int x = 0;
        int y = 0;
        int steps = 0;
        System.out.printf("(%d, %d)\n", x, y);
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
            System.out.printf("(%d, %d)\n", x, y);
        }
        System.out.println("steps = " + steps);
    }
}
