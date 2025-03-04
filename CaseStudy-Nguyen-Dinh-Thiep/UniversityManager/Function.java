package UniversityManager;

import java.io.*;
import java.util.*;

public class Function{

    public int getAge(Scanner scanner) {
        int age = -1;
        while (age <= 0) {
            try {
                System.out.print("Enter your age: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    System.out.println("The age must be positive.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        return age;
    }

    public String formatStudentInfo(int studentId, String name, int age, String major) {
        return "Mã số sinh viên " + studentId + "\n" +
                "Họ và tên " + name +
                ", Tuổi " + age +
                ", Ngành học " + major + "\n" +
                "--------------------------------------";
    }

    public boolean isDataExist(String filename, int studentId) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(String.valueOf("Mã số sinh viên " + studentId))) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return false;
    }

    public void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            writer.newLine();
            System.out.println("Student information saved successfully!");
            System.out.println("------------------------");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            System.out.println("------------------------");
        }
    }

    public void readFromFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found! No students have been added yet.");
            System.out.println("------------------------");
            return;
        }
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n=== Student List ===");
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            System.out.println("------------------------");
        }
    }

    public void removeStudentFromFile(String fileName, String studentId) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found! No students to remove.");
            return;
        }
        List<String> lines = new ArrayList<>();
        boolean studentFound = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Mã số sinh viên " + studentId)) {
                    studentFound = true;
                    while (line != null && !line.equals("--------------------------------------")) {
                        line = reader.readLine();
                    }
                } else {
                    lines.add(line);
                }
            }
            if (studentFound) {
                try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))) {
                    for (String dataLine : lines) {
                        fileWriter.write(dataLine);
                        fileWriter.newLine();
                    }
                }
                System.out.println("Student with ID " + studentId + " has been removed.");
            } else {
                System.out.println("Student with ID " + studentId + " not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading or writing to file: " + e.getMessage());
        }
    }

    public void searchStudent(String fileName, String keyword) {
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            StringBuilder studentInfo = new StringBuilder();

            while ((line = br.readLine()) != null) {
                if (!line.equals("--------------------------------------")) {
                    studentInfo.append(line).append("\n");
                } else {
                    if (studentInfo.toString().toLowerCase().contains(keyword.toLowerCase())) {
                        System.out.println("\n- Student found:\n" + studentInfo);
                        found = true;
                    }
                    studentInfo.setLength(0);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        if (!found) {
            System.out.println("No student found with keyword: " + keyword);
        }
    }

    public void editFile(String fileName, int studentID, Scanner scanner) {
        List<String> students = new ArrayList<>();
        boolean studentIDFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("Mã số sinh viên " + studentID)) {
                    studentIDFound = true;

                    while (line != null && !line.equals("--------------------------------------")) {
                        line = reader.readLine();
                    }

                    System.out.println("Student with ID " + studentID + " has been found. Please enter the new information:");
                    scanner.nextLine();
                    System.out.print("Enter new student name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new student age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine(); // Clear buffer
                    System.out.print("Enter new student major: ");
                    String newMajor = scanner.nextLine();

                    String newStudentInfo = formatStudentInfo(studentID, newName, newAge, newMajor);
                    students.add(newStudentInfo);
                } else {
                    students.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        if (!studentIDFound) {
            System.out.println("Student with ID " + studentID + " not found.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
            for (String newData : students) {
                writer.write(newData);
                writer.newLine();
            }
            System.out.println("Student information updated successfully!");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public void sortStudentsByID(String fileName) {
        List<String> students = new ArrayList<>();
        Map<Integer, String> studentMap = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder studentInfo = new StringBuilder();
            String line;
            int studentID = 0;

            while ((line = reader.readLine()) != null) {
                if (!line.equals("--------------------------------------")) {
                    studentInfo.append(line).append("\n");

                    if (line.startsWith("Mã số sinh viên ")) {
                        String[] parts = line.split(" ");
                        studentID = Integer.parseInt(parts[parts.length - 1]);
                    }
                } else {
                    studentInfo.append(line).append("\n");
                    studentMap.put(studentID, studentInfo.toString());
                    studentInfo.setLength(0);
                }
            }
        } catch (IOException e) {
            System.out.println("Error to read file: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String studentData : studentMap.values()) {
                writer.write(studentData);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error to read file: " + e.getMessage());
        }
    }
}
