import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sizeArray;
        int[] array;

        System.out.println("Enter the size of the array: ");
        sizeArray = sc.nextInt();
        array = new int[sizeArray];
        System.out.println("----------------------------");

        int n = 1;
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter the " + n + " element: ");
            array[i] = sc.nextInt();
            n = n + 1;
        }

        System.out.println("----------------------------");
        System.out.print("The property of the array is: ");
        System.out.println();
        for (int i : array) {
            System.out.print(i + "\t");
        }

        removeElementArray(array);

    }
    private static void removeElementArray(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("Input the element to be removed: ");
        int x = scanner.nextInt();
        int index_del = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                index_del = i;
            }
        }
        for (int i = index_del; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
        for (int number : array) {
            System.out.print(number + " ");
        }
    }
}
