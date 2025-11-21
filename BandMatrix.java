/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 21, 2025
 **************************************************************************** */

public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j >= i - width && j <= i + width)
                    System.out.print("*  ");
                else
                    System.out.print("0  ");
            }
            System.out.println();
        }
    }
}
