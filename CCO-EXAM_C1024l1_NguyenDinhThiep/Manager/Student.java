package Manager;

public class Student extends Person {
    private final String studentId;
    protected final String idClass;

    public Student(String studentId, String name, String age, String gender, String phone, String idClass) {
        super(name, age, gender, Integer.parseInt(phone));
        this.studentId = studentId;
        this.idClass = idClass;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public void displayInfo() {
        System.out.println("MSSV: " + studentId + ", Tên: " + name + ", Tuổi: " + age + ", Giới tính: " + gender + ", SĐT: " + phone + ", Mã lớp học: " + idClass);
    }

    public String toCSV() {
        return studentId + "," + name + "," + age + "," + gender + "," + phone + "," + idClass;
    }

    public Object getPhoneNumber() {
        return phone;
    }
}
