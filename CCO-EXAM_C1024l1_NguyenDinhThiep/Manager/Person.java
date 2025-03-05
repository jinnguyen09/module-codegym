package Manager;

abstract class Person {
    protected String name;
    protected String age;
    protected String gender;
    protected int phone;

    public Person(String name, String age, String gender, int phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    public abstract void displayInfo();
}