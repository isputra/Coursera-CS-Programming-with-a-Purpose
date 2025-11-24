/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 24, 2025
 **************************************************************************** */

public class BirthdayOther {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] count = new int[n + 1];
        double[] fractions = new double[n + 1];
        boolean isHalf = false;
        int nbPeople = 1;
        while (!isHalf) {
            for (int t = 0; t < trials; t++) {
                int[] peopleInside = new int[nbPeople];
                for (int i = 0; i < nbPeople; i++) {
                    peopleInside[i] = (int) (Math.random() * n);
                }
                for (int i = 0; i < nbPeople - 1; i++) {
                    if (peopleInside[i] == peopleInside[nbPeople - 1]) {
                        count[nbPeople]++;
                        break;
                    }
                }
            }
            long totalCount = 0;
            for (int i = 1; i < nbPeople + 1; i++) {
                totalCount += count[i];
            }
            fractions[nbPeople] = (double) totalCount / trials;
            isHalf = fractions[nbPeople] > 0.5;
            nbPeople++;
        }
        for (int i = 1; i < nbPeople; i++) {
            System.out.printf("%-2d\t %-5d\t %f\n", i, count[i], fractions[i]);
        }
    }
}
