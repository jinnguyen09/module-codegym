import java.util.Scanner;

public class TimGiaTriLonNhatTrongMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        int[] array;

        do {
            System.out.print("Input size of array: ");
            size = sc.nextInt();
            if (size > 20) {
                System.out.println("Error: size should be less than 20");
            }
        } while (size > 20);

        array = new int[size];
        int i = 0;
        int n = 1;
        while (i < array.length) {
            System.out.println("Input element " + n + ": ");
            array[i] = sc.nextInt();
            i++;
            n++;
        }
        System.out.println("Property list: ");

        for (i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }

        int max = array[0];
        int min = array[0];
        int indexmax = 1;
        int indexmin = 1;
        for (i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                indexmax = i + 1;
            }
        }
        for (i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                indexmin = i + 1;
            }
        }
        System.out.println();
        System.out.println("The largest property value in the list is " + max + ", at position: " + indexmax);
        System.out.println("The lowest property value in the list is " + min + ", at position: " + indexmin);
    }
}
