/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 24, 2025
 **************************************************************************** */

public class Minesweeper {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);

        int[][] grid = new int[m][n];
        char[][] mines = new char[m][n];

        int minesPlanted = 0;
        while (minesPlanted < k) {
            int position = (int) (Math.random() * m * n);
            int row = position / n;
            int col = position - (row * n);
            if (mines[row][col] != '*') {
                mines[row][col] = '*';
                minesPlanted++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j] == '*') {
                    if (i < m - 1) grid[i + 1][j]++;
                    if (i > 0) grid[i - 1][j]++;
                    if (j < n - 1) grid[i][j + 1]++;
                    if (j > 0) grid[i][j - 1]++;
                    if (i < m - 1 && j < n - 1) grid[i + 1][j + 1]++;
                    if (i < m - 1 && j > 0) grid[i + 1][j - 1]++;
                    if (i > 0 && j < n - 1) grid[i - 1][j + 1]++;
                    if (i > 0 && j > 0) grid[i - 1][j - 1]++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mines[i][j] == '*') {
                    System.out.print("*  ");
                }
                else {
                    System.out.printf("%d  ", grid[i][j]);
                }
            }
            System.out.println();
        }
    }
}
