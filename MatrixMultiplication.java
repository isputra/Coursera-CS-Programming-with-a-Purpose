/* *****************************************************************************
 *  Name:              Ikhsan Sigma Putra
 *  Coursera User ID:  ikhsanputra@gmail.com
 *  Last modified:     November 22, 2025
 **************************************************************************** */

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] matrix1 = new int[4][5];
        int[][] matrix2 = new int[5][3];

        if (matrix1[0].length != matrix2.length) {
            System.out.println(
                    "The number of columns in the first matrix is not equal to the number of rows in the second matrix");
            System.exit(1);
        }

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = (int) (Math.random() * 10);
            }
        }
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                matrix2[i][j] = (int) (Math.random() * 10);
            }
        }
        System.out.println("Matrix 1 :");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.printf("%-3d", matrix1[i][j]);
            }
            System.out.println();
        }
        System.out.println("Matrix 2 :");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.printf("%-3d", matrix2[i][j]);
            }
            System.out.println();
        }
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix1[i].length; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        System.out.println("Multiplication result :");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.printf("%-4d", result[i][j]);
            }
            System.out.println();
        }
    }
}
