package ItemsPackage;

import java.io.Serializable;
import java.util.Scanner;

public class Staff extends Item implements Serializable {
    protected String name;
    protected String position;
    protected double salary; // Hourly base salary in DKK
    protected String gender;
    protected int age;

    public Staff(String name) {
        this.name = name;
        generateTags();
    }

    public Staff(String name, String position) {
        this.name = name;
        this.position = position;
        generateTags();
    }

    public Staff(String name, String position, double salary, String gender, int age) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.gender = gender;
        this.age = age;
        generateTags();
    }

    public boolean search() {
        return false;
    }

    public void generateTags() {
        this.tag =
                name + " "
                + position + " "
                + salary + " "
                + gender + " "
                + age;

    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public boolean edit() {
        return true;
    }
    // Getters

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }


    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
