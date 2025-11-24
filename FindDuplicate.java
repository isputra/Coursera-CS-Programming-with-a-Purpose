/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 22, 2025
 **************************************************************************** */

public class FindDuplicate {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int) (Math.random() * n);
        }

        for (int i = 0; i < n; i++) {
            System.out.printf("%-3d", array[i]);
        }
        System.out.println();

        int idx1 = 0;
        int idx2 = 0;
        boolean finished = false;
        for (int i = 0; i < n && !finished; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] == array[j]) {
                    idx1 = i;
                    idx2 = j;
                    finished = true;
                    break;
                }
            }
        }
        for (int i = 0; i < idx1; i++) {
            System.out.printf("%-3s", "");
        }
        System.out.printf("%-3s", "^");
        for (int i = 0; i < idx2 - idx1 - 1; i++) {
            System.out.printf("%-3s", "");
        }
        System.out.printf("%-3s", "^");
        System.out.println();
        System.out.println("The duplicates are in index: " + idx1 + " and " + idx2);

    }
}
