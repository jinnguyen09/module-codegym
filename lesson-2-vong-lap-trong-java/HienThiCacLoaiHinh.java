import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        while (choice != 4) {
            System.out.println("Menu");
            System.out.println("----------------------");
            System.out.println("Choose an option: ");
            System.out.println("1. Draw the triangle");
            System.out.println("2. Draw the rectangle");
            System.out.println("3. draw a square");
            System.out.println("4. Exit");
            System.out.println("----------------------");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("----------------------");
                    System.out.println("Choose an option: ");
                    System.out.println("1. Draw the bottom-left triangle");
                    System.out.println("2. Draw the top-left triangle");
                    System.out.println("3. draw the middle triangle");
                    System.out.println("4. draw the bottom-right triangle");
                    System.out.println("5. draw the top-right triangle");
                    System.out.println("6. Exit");
                    System.out.println("----------------------");
                    int choice2 = sc.nextInt();
                    switch (choice2) {
                        case 1:
                            for (int i = 1; i <= 5; i++) {
                                for (int j = 1; j <= i; j++) {
                                    System.out.print(" * ");
                                }
                                System.out.println();
                            }
                            break;
                        case 2:
                            for (int i = 1; i <= 5; i++) {
                                for (int j = 5; j >= i; j--) {
                                    System.out.print(" * ");
                                }
                                System.out.println();
                            }
                            break;
                        case 3:
                            for (int i = 5; i >= 1; i--) {
                                for (int j = 1; j <= i; j++) {
                                    System.out.print(" ");
                                }
                                for (int j = 5; j >= i; j--) {
                                    System.out.print(" *");
                                }
                                System.out.println();
                            }
                            break;
                        case 4:
                            for (int i = 5; i >= 1; i--) {
                                for (int j = 1; j <= i; j++) {
                                    System.out.print("  ");
                                }
                                for (int j = 5; j >= i; j--) {
                                    System.out.print(" *");
                                }
                                System.out.println();
                            }
                            break;
                        case 5:
                            for (int i = 1; i <= 5; i++) {
                                for (int j = 1; j < i; j++) {
                                    System.out.print("  ");
                                }
                                for (int j = 5; j >= i; j--) {
                                    System.out.print(" *");
                                }
                                System.out.println();
                            }
                            break;
                        case 6:
                            break;
                    }
                    break;

                // Case 2 menu 1
                case 2:
                    for (int i = 1; i <= 3; i++) {
                        for (int j = 1; j <= 5; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println(" * ");
                    }
                    break;
                case 3:
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= 4; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println(" * ");
                    }
                    break;
                case 4:
                    break;
            }
        }
    }
}
