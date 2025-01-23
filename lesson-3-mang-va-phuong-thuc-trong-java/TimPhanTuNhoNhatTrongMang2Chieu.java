import java.util.Arrays;
import java.util.Scanner;

public class TimPhanTuNhoNhatTrongMang2Chieu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number of rows of array: ");
        int rows = sc.nextInt();
        System.out.println("Input the number of columns of array: ");
        int cols = sc.nextInt();

        double[][] matrix = new double[rows][cols];

        int min = 0;
        int minrows = -1, mincols = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Input [" + (i+1) + "][" + (j+1) + "] of array: ");
                matrix[i][j] = sc.nextDouble();
                if (matrix[i][j] < min) {
                    min = (int) matrix[i][j];
                    minrows = i;
                    mincols = j;
                }
            }
        }
        System.out.println("The total elements in the array is: ");
        System.out.println(Arrays.deepToString(matrix));
        System.out.println("The highest element in the array is: " + min + ". At the position [" + (minrows + 1) + "][" + (mincols + 1) + "]");
    }
}
