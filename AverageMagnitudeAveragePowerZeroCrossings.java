/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 26, 2025
 **************************************************************************** */

public class AverageMagnitudeAveragePowerZeroCrossings {
    public static void main(String[] args) {
        int zeroCrossing = 0;
        double previous = StdIn.readDouble();
        double averageMagnitude = Math.abs(previous);
        double averagePower = Math.pow(previous, 2);
        int count = 1;
        while (!StdIn.isEmpty()) {
            double number = StdIn.readDouble();
            count++;
            averageMagnitude = Math.abs(number) / count;
            averagePower = Math.pow(number, 2) / count;
            if ((number < 0 && previous > 0) || (number > 0 && previous < 0)) {
                zeroCrossing++;
            }
            previous = number;
        }
        System.out.printf("Average Magnitude: %f, Average Power: %f, Number of zero crossings: %d",
                          averageMagnitude, averagePower, zeroCrossing);
    }
}
