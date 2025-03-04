public class StudentList {
    private int id;
    private String name;
    private String age;
    private String email;
    public static String group = "Vien Ki Thuat Cong Nghe";

    public static String showMessage(String message) {
        return "Message: " + message;
    }

    public StudentList(int id, String name, String age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getInfor() {
        return "ID: " + id + "\nName: " + name + "\nAge: " + age + "\nEmail: " + email + "\nGroup: " + group + "\n";
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }
    public String getName() {
        return name;
    }
}
