import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the width of the rectangle: ");
        width = scanner.nextFloat();
        System.out.print("Enter the height of the rectangle: ");
        height = scanner.nextFloat();
        float area = width * height;
        System.out.println("The area of the rectangle is " + area);

    }
}
