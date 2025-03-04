import java.util.Scanner;

public class QuanLiSinhVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList student1 = new StudentList(1, "Nguyen Dinh Thiep", "2003", "thiepthanhx37@gmail.com");
        StudentList student2 = new StudentList(2, "Nguyen Dinh Thang", "1999", "thangthanhx99@gmail.com");
        StudentList student3 = new StudentList(3, "Nguyen Dinh Dat", "1995", "datthanh95@gmail.com");


        System.out.println(student1.getInfor());
        System.out.println(student2.getInfor());
        System.out.println(student3.getInfor());
    }
}

