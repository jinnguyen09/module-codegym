import java.util.Scanner;

public class UngDungTinhTienLaiChoVayNganHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money;
        int months;
        double interestRate;

        // Input data
        System.out.println("Input the investment amount: ");
        money = sc.nextDouble();
        System.out.println("Input the interest rate in percentage: ");
        interestRate = sc.nextDouble();
        System.out.println("Input the number of months: ");
        months = sc.nextInt();

        // Calculate total interest
        double totalInterest = money * (interestRate / 100) / 12 * months;

        // Output results
        System.out.printf("Total interest for %d months is: %,.0f\n", months, totalInterest);
        System.out.printf("Total amount after interest: %,.0f\n", money + totalInterest);

        // Close Scanner
        sc.close();
    }
}