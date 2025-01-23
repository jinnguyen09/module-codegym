import java.util.ArrayList;
import java.util.Scanner;

public class ThemPhanTuTrongMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add an element to the array");
            System.out.println("2. Remove an element from the array");
            System.out.println("3. Exit");
            System.out.println("---------------------------");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("How many elements you want to add: ");
                    int size = sc.nextInt();
                    int n = 1;
                    for (int i = 0; i < size; i++) {
                        System.out.print(n + ". Enter element: ");
                        int addArray = sc.nextInt();
                        array.add(addArray);
                        n++;
                    }
                    System.out.println("Current elements in the array: " + array);
                    System.out.println("---------------------------");
                    break;
                case 2:
                    removeElementArray(array);
                    System.out.println("---------------------------");
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                    break;
            }
        }
    }

    private static void removeElementArray(ArrayList<Integer> array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("-------------------------------");
        System.out.print("Input the element to be removed: ");
        int x = scanner.nextInt();

        if (array.remove(Integer.valueOf(x))) {
            System.out.println("Element " + x + " removed successfully.");
        } else {
            System.out.println("Element " + x + " not found in the array.");
        }

        System.out.println("Current elements in the array: " + array);
    }
}