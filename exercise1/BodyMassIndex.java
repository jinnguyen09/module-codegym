import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your weight (in kilogram): ");
        double weight = sc.nextInt();
        System.out.println("Enter your height (in centimeters or meters): ");
        float height = sc.nextFloat();
        System.out.println("====================");
        double bmi;
        if (height < 10) {
            bmi = weight / Math.pow(height, 2);
        } else {
            height = height / 100;
            bmi = weight / Math.pow(height, 2);
        }

        if (bmi < 18) {
            System.out.println(bmi + " You are Underweight");
        } else if (bmi <= 25) {
            System.out.println(bmi + " You are Normal");
        }
        else if (bmi <= 30) {
            System.out.println(bmi + " You are Overweight");
        }
        else {
            System.out.println(bmi + "You are Obese");
        }
    }
}
