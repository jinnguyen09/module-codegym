import java.util.Scanner;

public class UngDungDocSoThanhChu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số cần đọc (0-999): ");
        int number = sc.nextInt();

        if (number < 0 || number > 999) {
            System.out.println("out of ability");
        } else {
            System.out.println(numberToWords(number));
        }
    }
    private static String numberToWords(int number) {
        String words = "";

        // Xử lý số có 1 chữ số
        if (number < 10) {
            switch (number) {
                case 0: return "zero";
                case 1: return "one";
                case 2: return "two";
                case 3: return "three";
                case 4: return "four";
                case 5: return "five";
                case 6: return "six";
                case 7: return "seven";
                case 8: return "eight";
                case 9: return "nine";
            }
        }

        // Xử lý số có 2 chữ số nhỏ hơn 20
        if (number < 20) {
            switch (number) {
                case 10: return "ten";
                case 11: return "eleven";
                case 12: return "twelve";
                case 13: return "thirteen";
                case 14: return "fourteen";
                case 15: return "fifteen";
                case 16: return "sixteen";
                case 17: return "seventeen";
                case 18: return "eighteen";
                case 19: return "nineteen";

            }
        }

        // Xử lý số có 2 chữ số từ 20-99
        if (number < 100) {
            int tens = number / 10;
            int ones = number % 10;

            switch (tens) {
                case 2: words += "twenty"; break;
                case 3: words += "thirty"; break;
                case 4: words += "forty"; break;
                case 5: words += "fifty"; break;
                case 6: words += "sixty"; break;
                case 7: words += "seventy"; break;
                case 8: words += "eighty"; break;
                case 9: words += "ninety"; break;
            }
            if (ones > 0) {
                words += " " + numberToWords(ones);
            }
            return words;
        }

        // Xử lý số có 3 chữ số từ 100-999
        if (number < 1000) {
            int hundreds = number / 100;
            int ones = number % 100;

            switch (hundreds) {
                case 1: words += "One hundred"; break;
                case 2: words += "Two hundred"; break;
                case 3: words += "Three hundred"; break;
                case 4: words += "Four hundred"; break;
                case 5: words += "Five hundred"; break;
                case 6: words += "Six hundred"; break;
                case 7: words += "Seven hundred"; break;
                case 8: words += "Eight hundred"; break;
                case 9: words += "Nine hundred"; break;
            }
            if (ones > 0) {
                words += " and " + numberToWords(ones);
            }
            return words;
        }
        return numberToWords(number);
    }
}
