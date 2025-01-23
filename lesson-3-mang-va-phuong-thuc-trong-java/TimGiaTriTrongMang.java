import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.print("Enter student name you want to find: ");
        String name = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equalsIgnoreCase(name)) {
                System.out.println("Student " + name + " is found in: " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student " + name + " not found in the list");
        }
    }
}
