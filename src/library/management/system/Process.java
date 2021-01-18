package library.management.system;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Process {

    static Scanner in;
    static Student a;
    static List<Student> StudentsArray = new ArrayList<Student>();
    static List<Book> BooksList = new ArrayList<Book>();

    public void main() {

        in = new Scanner(System.in);
        boolean Cheak = true;
        System.out.println("Welcom in my Project  ^_^ \n");
        //----
        System.out.println(" 1 . Show Books \n" //Done! ضايل الطلاب  الي اشتروا ..
                + " 2 . Add a Book \n" //Done!
                + " 3 . Delete a Book \n" //Done!
                + " 4 . Search for a book \n"//Done!!
                + " 5 . Buy a Book \n"//Done!!
                + " 6 . Show Students \n"//Done!!
                + " 7 . Add a Student \n"//Done!!
                + " 8 . Full Report \n"
                + " 9 . Exit \n");//Done!

        while (Cheak) {
            System.out.print("main: Choose number :  ");

            try {

                int w = in.nextInt();

                switch (w) {
                    case 1:
                        System.out.println("-+-+-+-+-+-+-+-+-+-+");
                        Book.ShowBooks();
                        System.out.println("-+-+-+-+-+-+-+-+-+-+");

                        break;
                    case 2:
                        System.out.println("-+-+--+-+-+-+-++-+-+");
                        Book.AddBook();
                        System.out.println("-+-+--+-+-+-+-++-+-+");
                        break;
                    case 3:
                        System.out.println("-+-+--+-+-+-+-++-+-+");
                        System.out.print(" +-+-+ Delete book +-+-+");
                        System.out.print("Enter ISBN  : ");
                        String ISBN = in.next();
                        DeleteBook(ISBN);

                        System.out.println("-+-+--+-+-+-+-++-+-+");

                        break;
                    case 4:
                        System.out.println("-+-+--+-+-+-+-++-+-+");
                        System.out.println(" +-+-+ Search book +-+-+");
                        System.out.print("Enter ISBN  : ");
                        String ISBN2 = in.next();
                        System.out.print("Enter Category  : ");
                        String Category = in.next();
                        Book.SearchBook(ISBN2, Category);
                        System.out.println("-+-+-+-+-+-+-+-+-+-+");
                        break;
                    case 5:

                        System.out.println("-+-+--+-+-+-+-++-+-+");
                        System.out.println(" +-+-+ Buy book +-+-+");
                        System.out.print("Enter Book Name  : ");
                        String BookName = in.next();
                        System.out.print("Enter Student ID  : ");
                        String StudentID = in.next();
                        BuyBook(BookName, StudentID);
                        System.out.println("-+-+-+-+-+-+-+-+-+-+");
                        break;

                    case 6:
                        System.out.println("-+-+--+-+-+-+-++-+-+");
                        Student.ShowStudents();
                        System.out.println("-+-+-+-+-+-+-+-+-+-+");
                        break;
                    case 7:
                        System.out.println("-+-+-+-+-+-+-+-+-+-+");
                        Student.AddStudent();
                        System.out.println("-+-+-+--+-+-+-+-++-+");

                        break;
                    case 8:
                        reports();
                        break;

                    case 9:
                        System.out.println("Exit");
                        Cheak = false;
                        break;

                }
                ///s
            } catch (InputMismatchException e) {
                System.out.println("there is some Error");
                in.next();
            }

        }

    }

    public static void DeleteBook(String iSBN) {

        for (Book book : BooksList) {
            if (iSBN.equals(book.getiSBN())) {
                BooksList.remove(book);
                break;

            }
        }

    }

    public static void BuyBook(String Bookname, String StudentId) {
//Book Name
//Student ID
        Student st = null;
        Book bk = null;

        for (Student stu : StudentsArray) {
            if (StudentId.equalsIgnoreCase(stu.getId())) {
                st = stu;
                break;

            }
        }

        for (Book book : BooksList) {

            if (Bookname.equalsIgnoreCase(book.getName())) {
                bk = book;

            }
        }
        ///-----
        if (bk == null) {
            System.out.println("there is no book like this name");

        } else if (st == null) {
            System.out.println("there is no Student has this ID ");

        } else {

            if (st.getBudget() < bk.getPrice() || bk.getNumberOfCopies() == 0) {
                System.out.println("Can't Buy this book");
                if (bk.getNumberOfCopies() == 0) {
                    System.out.println("there is No book her");
                } else {

                    System.out.println("you dont have Enough Mony");
                }

            } else {

                Student[] x = bk.getStudents();

                for (int i = 0; i < bk.getStudents().length; i++) {
                    System.out.println("bk Size= : " + (bk.getStudents().length));

                    if (x[i] == null) {
                        x[i] = st;
                        break;
                    }
                }

                bk.setStudents(x);

                st.setBudget(st.getBudget() - bk.getPrice());
                bk.setNumberOfCopies(bk.getNumberOfCopies() - 1);
                System.out.println("After" + Arrays.toString(x));

            }

        }
    }

    public static void reports() {
        FileWriter fileWriter = null;
        try {
            String FileName = "report.txt";
            fileWriter = new FileWriter(FileName, true);
            PrintWriter printWriter = new PrintWriter(fileWriter, true);
            printWriter.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            printWriter.println("+-+-+-+-+Books+-+-+-+");
            for (Book book : BooksList) {
                printWriter.println("+-+-+-+-+-+-+-+-+-+-");

                printWriter.println(book.toString());

                if (book.getStudents().length != 0) {
                    printWriter.println("+-+-+-");
                    printWriter.println(" Student that buy book");
                    printWriter.println("+-+-+-");
                    for (Student str : book.getStudents()) {
                        if (str != null) {
                            printWriter.println(str.toString());
                        } else {
                            break;
                        }
                    }
                } else {
                    printWriter.println("there is no Student By this Book");

                }
            }

            printWriter.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            printWriter.println("--- + All Student + ---");

            printWriter.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
            for (Student st : StudentsArray) {

                printWriter.println(st.toString());

                printWriter.println("+-+-+-+-+-+-+-+-+-+-");
            }
            printWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }

    }

}
