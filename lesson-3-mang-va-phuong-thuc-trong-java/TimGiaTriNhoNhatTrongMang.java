import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        int[] arr;

        System.out.print("Input the size of the array: ");
        size = sc.nextInt();
        arr = new int[size];

        int i = 0;
        int n = 1;
        while (i < arr.length) {
            System.out.print("Input element "+ n +": ");
            arr[i] = sc.nextInt();
            i++;
            n++;
        }

        System.out.println("----------------------");
        System.out.println("The total array is: ");
        for (i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        int indexmin = 0;
        int min = arr[0];
        for (i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                indexmin = i + 1;
            }
        }

        int minArr = ArrayMin(arr);
        System.out.println();
        System.out.println("The minimum element is: " + arr[minArr] + ", at the position: " + indexmin);
    }

    public static int ArrayMin(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[index]) {
                arr[index] = arr[i];
            }
        }
        return index;
    }
}
