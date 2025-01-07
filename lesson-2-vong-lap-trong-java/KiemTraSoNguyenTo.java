import java.util.Scanner;

public class KiemTraSoNguyenTo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        boolean invalidNumber = false;

        // Kiểm tra dữ liệu nhập vào cos phai số hay không?
        while (!invalidNumber) {
            System.out.println("Please enter a number: ");
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                invalidNumber = true;
            } else {
                System.out.println("Invalid number, please enter a number again: ");
                sc.next();
            }
        }

        // Kiểm tra số nguyên
        if (number < 2) {
            System.out.println(number + " is not a prime number");
        } else {
            int i = 2;
            boolean isPrime = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
                i++;
            }
            if (isPrime) {
                System.out.println(number + " is a prime number");
            } else {
                System.out.println(number + " is not a prime number");
            }
        }
    }
}
