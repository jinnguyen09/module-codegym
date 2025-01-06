import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập a: ");
        int numberA = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập b: ");
        int numberB = Integer.parseInt(scanner.nextLine());

        if (numberA == 0) {
            if (numberB == 0) {
                System.out.println("Phương trình có vô số nghiệm");
            } else {
                System.out.println("Phương trình vô nghiệm");
            }
        } else {
            double x = (double) -numberB / numberA;
            System.out.println("Phương trình có nghiệm là x = " + x);
        }

        scanner.close();
    }
}
