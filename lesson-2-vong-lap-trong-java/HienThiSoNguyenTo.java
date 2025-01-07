import java.util.Scanner;

public class HienThiSoNguyenTo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of prime numbers you would like to check: ");
        int limit = sc.nextInt();

        System.out.println("The prime numbers are: ");
        for (int number = 2; number < limit; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
        sc.close();
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
