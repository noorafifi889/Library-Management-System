
package library.management.system;

import java.util.InputMismatchException;
import java.util.Scanner;
import static library.management.system.Process.StudentsArray;

public class Student  extends  Person{
private String id,major;
private double budget;

    public Student() {
    }

    public Student(String id, String major, double budget, String identityNum, String name, String gender, String phone) {
        super(identityNum, name, gender, phone);
        this.id = id;
        this.major = major;
        this.budget = budget;
    }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
     public static void AddStudent() {
        // String id, String major, double budget, String identityNum, String name, String gender, String phone

      Scanner  in = new Scanner(System.in);
        try {

            System.out.println("please Enter Student Info");
            System.out.print("Enter Student ID: ");
            String ID = in.next();
            System.out.print("Enter Student name: ");
            String name = in.next();
            System.out.print("Enter Student major: ");
            String major = in.next();
            System.out.print("Enter Student budget: ");
            double budget = in.nextDouble();
            System.out.print("Enter Student identityNum: ");
            String identityNum = in.next();
            System.out.print("Enter Student gender: ");
            String gender = in.next();
            System.out.print("Enter Student phone: ");
            String phone = in.next();
            //new Student(ID, major, budget, identityNum, name, gender, phone)
            StudentsArray.add(new Student(ID, major, budget, identityNum, name, gender, phone));
        } catch (InputMismatchException e) {
            System.out.println("there is some Error");
            // in.next();
        }
    }
        public static void ShowStudents() {
        if (StudentsArray.isEmpty()) {
            System.out.println("+-+-+-+-+-+-+-+-+-+-");
            System.out.println("there is no Student !!");
            System.out.println("+-+-+-+-+-+-+-+-+-+-");
        } else {
            for (Student st : StudentsArray) {
                System.out.println("+-+-+-+-+-+-+-+-+-+-");

                System.out.println(st.toString());

                System.out.println("+-+-+-+-+-+-+-+-+-+-");
            }

        }
    }
 @Override
    public String toString(){
    
        return super.toString()+"\n ID: "+id+"\nMagor"+major+"\nBudget"+budget ;
    }
   
}
