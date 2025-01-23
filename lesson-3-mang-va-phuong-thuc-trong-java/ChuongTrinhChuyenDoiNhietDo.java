import java.util.Scanner;

public class ChuongTrinhChuyenDoiNhietDo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("----------------------");
            System.out.println("Select menu: ");
            System.out.println("1. Fahrenheit to Celsius ");
            System.out.println("2. Celsius to Fahrenheit ");
            System.out.println("3. Exit ");
            System.out.println("---------------------");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Input Fahrenheit: ");
                double fahrenheit = sc.nextDouble();
                System.out.println(fahrenheit + " Fahrenheit to Celsius is: " + FahrenheitToCelsius(fahrenheit));
            }
            else if (choice == 2) {
                System.out.println("Input Celsius: ");
                double celsius = sc.nextDouble();
                System.out.println(celsius + " Celsius to Fahrenheit is: " + CelsiusToFahrenheit(celsius));
            }
            else if (choice > 3) {
                System.out.println("Invalid choice, please try again");
            }
        } while (choice != 3);

    }

    public static double FahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static double CelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
}
