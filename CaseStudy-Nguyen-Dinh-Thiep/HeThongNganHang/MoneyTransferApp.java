package HeThongNganHang;

import java.io.*;
import java.util.Scanner;

public class MoneyTransferApp {

    // Định nghĩa lớp Account để lưu thông tin tài khoản
    static class Account {
        String accountNumber;
        String accountHolder;
        double balance;

        // Constructor để tạo tài khoản
        public Account(String accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        // Phương thức chuyển tiền từ tài khoản
        public boolean transferMoney(double amount) {
            if (amount <= 0) {
                System.out.println("❌ Số tiền chuyển không hợp lệ.");
                return false;
            }
            if (amount > this.balance) {
                System.out.println("❌ Số dư không đủ.");
                return false;
            }
            this.balance -= amount;
            return true;
        }

        // Phương thức nạp tiền vào tài khoản
        public void deposit(double amount) {
            if (amount > 0) {
                this.balance += amount;
                System.out.println("✅ Đã nạp " + amount + " vào tài khoản.");
            } else {
                System.out.println("❌ Số tiền nạp không hợp lệ.");
            }
        }

        // In ra thông tin tài khoản
        public void printAccountInfo() {
            System.out.println("Số tài khoản: " + accountNumber);
            System.out.println("Chủ tài khoản: " + accountHolder);
            System.out.println("Số dư: " + balance);
        }

        // Lưu thông tin tài khoản vào file
        public void saveToFile() {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(accountNumber + ".txt"))) {
                writer.write("Số tài khoản: " + accountNumber);
                writer.newLine();
                writer.write("Chủ tài khoản: " + accountHolder);
                writer.newLine();
                writer.write("Số dư: " + balance);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("❌ Lỗi khi lưu thông tin tài khoản vào file.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo các tài khoản mẫu (tải từ file nếu có)
        Account account1 = loadAccountFromFile("123456.txt");
        Account account2 = loadAccountFromFile("654321.txt");

        if (account1 == null) {
            account1 = new Account("123456", "Nguyen Van A", 1000.0); // Tạo mới nếu file không tồn tại
        }
        if (account2 == null) {
            account2 = new Account("654321", "Tran Thi B", 500.0); // Tạo mới nếu file không tồn tại
        }

        // Đăng nhập hoặc tạo tài khoản mới
        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Tạo tài khoản mới");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng (1-3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ dòng thừa

            switch (choice) {
                case 1:
                    // Đăng nhập vào tài khoản
                    System.out.print("Nhập số tài khoản để đăng nhập: ");
                    String loginAccountNumber = scanner.nextLine();

                    Account loggedInAccount = null;

                    if (loginAccountNumber.equals(account1.accountNumber)) {
                        loggedInAccount = account1;
                    } else if (loginAccountNumber.equals(account2.accountNumber)) {
                        loggedInAccount = account2;
                    } else {
                        System.out.println("❌ Tài khoản không hợp lệ.");
                        continue;
                    }

                    System.out.println("✅ Đăng nhập thành công vào tài khoản: " + loggedInAccount.accountHolder);

                    // Chức năng chuyển tiền
                    manageAccount(scanner, loggedInAccount, account1, account2);
                    break;

                case 2:
                    // Tạo tài khoản mới
                    createAccount(scanner);
                    break;

                case 3:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("❌ Chức năng không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    // Phương thức để tải tài khoản từ file
    private static Account loadAccountFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String accountNumber = reader.readLine().split(": ")[1];
            String accountHolder = reader.readLine().split(": ")[1];
            double balance = Double.parseDouble(reader.readLine().split(": ")[1]);

            return new Account(accountNumber, accountHolder, balance);
        } catch (IOException e) {
            return null;  // Trả về null nếu không thể tải tài khoản từ file
        }
    }

    // Phương thức để quản lý tài khoản đã đăng nhập
    private static void manageAccount(Scanner scanner, Account loggedInAccount, Account account1, Account account2) {
        while (true) {
            System.out.println("\n--- Menu Quản Lý Tài Khoản ---");
            System.out.println("1. Xem thông tin tài khoản");
            System.out.println("2. Chuyển tiền");
            System.out.println("3. Nạp tiền");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Đọc bỏ dòng thừa

            switch (choice) {
                case 1:
                    loggedInAccount.printAccountInfo();
                    break;

                case 2:
                    transferMoney(scanner, loggedInAccount, account1, account2);
                    break;

                case 3:
                    depositMoney(scanner, loggedInAccount);
                    break;

                case 4:
                    // Lưu lại thông tin tài khoản vào file trước khi thoát
                    loggedInAccount.saveToFile();
                    System.out.println("Thông tin tài khoản đã được lưu.");
                    return;
                default:
                    System.out.println("❌ Chức năng không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    // Phương thức chuyển tiền
    private static void transferMoney(Scanner scanner, Account loggedInAccount, Account account1, Account account2) {
        System.out.print("Nhập số tài khoản người nhận: ");
        String receiverAccountNumber = scanner.nextLine();
        Account receiverAccount = null;

        // Kiểm tra tài khoản người nhận
        if (receiverAccountNumber.equals(account1.accountNumber)) {
            receiverAccount = account1;
        } else if (receiverAccountNumber.equals(account2.accountNumber)) {
            receiverAccount = account2;
        } else {
            System.out.println("❌ Tài khoản người nhận không hợp lệ.");
            return;
        }

        // Nhập số tiền chuyển
        System.out.print("Nhập số tiền cần chuyển: ");
        double transferAmount = scanner.nextDouble();

        // Thực hiện chuyển tiền
        if (loggedInAccount.transferMoney(transferAmount)) {
            receiverAccount.deposit(transferAmount);
            System.out.println("✅ Đã chuyển " + transferAmount + " vào tài khoản " + receiverAccount.accountHolder);
        }
    }

    // Phương thức nạp tiền vào tài khoản
    private static void depositMoney(Scanner scanner, Account loggedInAccount) {
        System.out.print("Nhập số tiền cần nạp: ");
        double depositAmount = scanner.nextDouble();
        loggedInAccount.deposit(depositAmount);
    }

    // Phương thức tạo tài khoản mới
    private static void createAccount(Scanner scanner) {
        System.out.print("Nhập số tài khoản mới: ");
        String newAccountNumber = scanner.nextLine();
        System.out.print("Nhập tên chủ tài khoản: ");
        String newAccountHolder = scanner.nextLine();
        System.out.print("Nhập số dư ban đầu: ");
        double initialBalance = scanner.nextDouble();

        // Tạo tài khoản mới và lưu vào file
        Account newAccount = new Account(newAccountNumber, newAccountHolder, initialBalance);
        newAccount.saveToFile();
        System.out.println("✅ Tạo tài khoản mới thành công!");
    }
}
