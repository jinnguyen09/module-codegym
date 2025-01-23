import java.util.Scanner;

public class UngDungDemSoLuongSinhVienThiDo {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter size of students: ");
            size = sc.nextInt();
            if (size > 30) {
                System.out.println("The size should not exceed 30 students: ");
            }
        } while (size > 30);
        System.out.println("--------------------------------");
        array = new int[size];
        for (int i = 0; i < size; i++) {
            do {
                System.out.println("Enter the score of student " + (i + 1) + ": ");
                array[i] = sc.nextInt();
                if (array[i] > 10 || array[i] < 0) {
                    System.out.println("The score should be between 0 and 10");
                }
            } while (array[i] > 10 || array[i] < 0);
        }
        System.out.println("-------------------------------");
        for (int i = 0; i < size; i++) {
            if (array[i] >= 5 && array[i] <= 10) {
                System.out.println("The student " + (i + 1) + " has passed with a score of " + array[i]);
            }
            if (array[i] <= 5 && array[i] >= 0) {
                System.out.println("The student " + (i + 1) + " has failed with a score of " + array[i]);
            }
        }
        sc.close();
    }
}
