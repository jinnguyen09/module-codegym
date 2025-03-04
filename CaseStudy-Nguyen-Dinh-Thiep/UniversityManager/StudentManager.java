package UniversityManager;

import java.util.Scanner;

public class StudentManager {

    public static void main(String[] args) {
        Function function = new Function();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("------------------------");
            System.out.println("0. Edit Student Information");
            System.out.println("1. Add a Student");
            System.out.println("2. Remove a Student");
            System.out.println("3. Show All Students");
            System.out.println("4. Search Student");
            System.out.println("5. Sorting list of Students");
            System.out.println("6. Exit");
            System.out.println("------------------------");
            System.out.print("Choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Enter Student ID you want to edit: ");
                    int newStudentID = scanner.nextInt();
                    function.editFile("sinhvien.txt", newStudentID, scanner);
                    break;
                case 1:
                    System.out.println("------------------------");
                    System.out.print("Enter the code number of the student: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a number.");
                        scanner.next();
                    }
                    int studentId = scanner.nextInt();
                    while (function.isDataExist("sinhvien.txt", studentId)) {
                        System.out.println("StudentID is already exists! Please choose another studentID.");
                        System.out.print("Enter the code number of the student: ");
                        studentId = scanner.nextInt();
                    }
                    scanner.nextLine();
                    System.out.print("Enter the name of the student: ");
                    String name = scanner.nextLine();
                    int age = function.getAge(scanner);
                    System.out.print("Enter the name of the course: ");
                    String major = scanner.nextLine();
                    System.out.println("------------------------");

                    String studentInfo = function.formatStudentInfo(studentId, name, age, major);
                    function.writeToFile("sinhvien.txt", studentInfo);
                    break;
                case 2:
                    System.out.println("Enter the code student number need to remove: ");
                    String studentID = scanner.nextLine();
                    function.removeStudentFromFile("sinhvien.txt", studentID);
                    break;
                case 3:
                    function.readFromFile("sinhvien.txt");
                    break;
                case 4:
                    System.out.println("Enter the student ID or student name to search: ");
                    String studentKeyword = scanner.nextLine();
                    function.searchStudent("sinhvien.txt", studentKeyword);
                    break;
                case 5:
                    function.sortStudentsByID("sinhvien.txt");
                    System.out.println("The list has been sorted by ID");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1-4.");
            }
        } while (choice != 6);
        scanner.close();
    }
}
