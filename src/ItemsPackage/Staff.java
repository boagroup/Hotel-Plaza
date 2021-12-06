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
        return  "  ||  " + "NAME: " + name + "  ||  " +
                "POSITION:  " + position + "  ||  " +
                "MONTHLY SALARY: " + salary + "  ||  " +
                "GENDER: " + gender + "  ||  " +
                "AGE: " + age + "  ||  " ;
    }

    public boolean edit(Scanner sc) {
        System.out.println("1. Employee Name: " + name);
        System.out.println("2. Position: " + position);
        System.out.println("3. Salary: " + salary + " DKK");
        System.out.println("4. Gender: " + gender);
        System.out.println("5. Age: " + age);
        System.out.println("0. Go back");
        String answer = sc.nextLine();
        switch (answer) {
            case "1":
                System.out.println("Please enter the employee's name: ");
                name = sc.nextLine();
                break;
            case "2":
                System.out.println("Please enter the employee's position: ");
                position = sc.nextLine();
                break;
            case "3":
                System.out.println("Please enter the salary: ");
                try {
                    salary = Double.parseDouble(sc.nextLine());
                } catch (Exception e) {
                    System.out.println(e instanceof NumberFormatException? "You need to put in a number!" : e.getMessage());
                }
                break;
            case "4":
                System.out.println("Please enter the gender:");
                gender = sc.nextLine();
                break;
            case "5":
                System.out.println("Please enter the age: ");
                try {
                    age = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println(e instanceof NumberFormatException? "You need to put in a number!" : e.getMessage());
                }
                break;
            default:
                generateTags();
                return false;
        }
        generateTags();
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
