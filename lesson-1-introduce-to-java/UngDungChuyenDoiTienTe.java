import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String loaiTien;

        while (true) {
            System.out.println("Vui lòng chọn loại tiền cần quy đổi:");
            System.out.println("1. VND");
            System.out.println("2. USD");
            System.out.println("3. Exit");
            loaiTien = sc.nextLine();

            // Check for exit condition
            if (loaiTien.equals("3") || loaiTien.equalsIgnoreCase("exit")) {
                System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                break;
            }

            // Validate currency type
            if (!loaiTien.equalsIgnoreCase("VND") && !loaiTien.equalsIgnoreCase("USD") &&
                    !loaiTien.equals("1") && !loaiTien.equals("2")) {
                System.out.println("Loại tiền không hợp lệ, vui lòng thử lại: VND hoặc USD");
                continue; // Restart the loop for invalid input
            }

            // Currency conversion
            if (loaiTien.equalsIgnoreCase("VND") || loaiTien.equals("1")) {
                System.out.println("Nhập số tiền VND: ");
                double toUSD = sc.nextDouble();
                double vndToUSD = toUSD / 24000.0;
                System.out.println(toUSD + " VND = " + vndToUSD + " USD");
            } else if (loaiTien.equalsIgnoreCase("USD") || loaiTien.equals("2")) {
                System.out.println("Nhập số tiền USD: ");
                double toVND = sc.nextDouble();
                double usdToVND = toVND * 24000.0;
                System.out.println(toVND + " USD = " + usdToVND + " VND");
            }

            sc.nextLine(); // Clear the scanner buffer
        }

        sc.close();
    }
}