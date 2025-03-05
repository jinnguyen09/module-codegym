package Manager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private final List<Student> students;
    private static final String FILE_PATH = "students.csv";

    public StudentManager() {
        students = new ArrayList<>();
        loadStudentsFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudentsToFile();
        System.out.println("Sinh viên đã được thêm thành công!");
    }

    public void displayStudents() {
        for (Student student : students) {
            student.displayInfo();
        }
    }

    public void deleteStudent(String studentId) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                studentToRemove = student;
                System.out.println("Sinh viên tên " + student.name + " với mã số ID " + studentId + " đã được xóa!");
                break;
            }
        }
        if (studentToRemove == null) {
            System.out.println("Sinh viên không tồn tại!");
        }
        students.remove(studentToRemove);
        saveStudentsToFile();
    }

    public void searchStudentByID(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().toLowerCase().contains(studentId)) {
                student.displayInfo();
            } else {
                System.out.println("Không tìm thấy sinh viên với ID " + studentId);
            }
        }
    }

    private void saveStudentsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student student : students) {
                writer.write(student.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu file: " + e.getMessage());
        }
    }

    private void loadStudentsFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    students.add(new Student(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
    public boolean isPhoneNumberExists(String phoneNumber) {
        for (Student s : students) {
            if (s.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
