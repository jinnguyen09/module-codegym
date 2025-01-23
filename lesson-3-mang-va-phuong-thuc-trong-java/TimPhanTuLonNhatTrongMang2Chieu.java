import java.util.Arrays;
import java.util.Scanner;

public class TimPhanTuLonNhatTrongMang2Chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the number of rows of array: ");
        int rows = scanner.nextInt();
        System.out.println("Input the number of columns of array: ");
        int cols = scanner.nextInt();

        double[][] matrix = new double[rows][cols];

        int max = 0;
        int maxrows = -1, maxcols = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Input [" + (i+1) + "][" + (j+1) + "] of array: ");
                matrix[i][j] = scanner.nextDouble();
                if (matrix[i][j] > max) {
                    max = (int) matrix[i][j];
                    maxrows = i;
                    maxcols = j;
                }
            }
        }
        System.out.println("The total elements in the array is: ");
        System.out.println(Arrays.deepToString(matrix));
        System.out.println("The highest element in the array is: " + max + ". At the position [" + (maxrows + 1) + "][" + (maxcols + 1) + "]");
    }
}
