import Manager.StudentManager;
import Manager.Student;

import java.util.*;

public class StudentManagement {
    public static <NotFoundStudentException extends Throwable> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("-------------------------");
            System.out.println("=== Quản lý sinh viên ===");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Hiển thị danh sách sinh viên");
            System.out.println("4. Tìm kiếm sinh viên theo MSSV");
            System.out.println("5. Thoát");
            System.out.println("-------------------------");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập MSSV: ");
                    String id = scanner.nextLine();
                    String name;
                    while (true) {
                        System.out.print("Nhập tên (4 - 50 ký tự): ");
                        name = scanner.nextLine();
                        if (name.length() >= 4 && name.length() <= 50) {
                            break;
                        }
                        System.out.println("Tên không hợp lệ! Vui lòng nhập lại.");
                    }
                    String birthDate;
                    while (true) {
                        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
                        birthDate = scanner.nextLine();
                        if (birthDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
                            break;
                        }
                        System.out.println("Ngày sinh không hợp lệ! Vui lòng nhập đúng định dạng dd/MM/yyyy.");
                    }
                    System.out.print("Nhập giới tính: (Nam/Nữ) ");
                    String gender = scanner.nextLine();
                    String phoneNumber;
                    while (true) {
                        System.out.print("Nhập số điện thoại (10 số, bắt đầu bằng 090 hoặc 091): ");
                        phoneNumber = scanner.nextLine();
                        if (phoneNumber.matches("^(090|091)\\d{7}$") && !manager.isPhoneNumberExists(phoneNumber)) {
                            break;
                        }
                        System.out.println("Số điện thoại không hợp lệ hoặc đã tồn tại! Vui lòng nhập lại.");
                    }
                    System.out.println("Mã lớp học: ");
                    String idClass = scanner.nextLine();
                    manager.addStudent(new Student(id, name, birthDate, gender, phoneNumber, idClass));
                    System.out.println("Đã thêm sinh viên!");
                    break;
                case 2:
                    System.out.print("Nhập MSSV cần xóa: ");
                    String deleteId = scanner.nextLine();
                    try {
                        manager.deleteStudent(deleteId);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    manager.displayStudents();
                    break;
                case 4:
                    System.out.print("Nhập MSSV cần tìm: ");
                    String searchID = scanner.nextLine();
                    manager.searchStudentByID(searchID);
                    break;
                case 5:
                    System.out.println("Thoát chương trình!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
