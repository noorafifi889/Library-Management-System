package library.management.system;

import java.util.InputMismatchException;
import java.util.Scanner;
import static library.management.system.Process.BooksList;
import static library.management.system.Process.in;

public class Book {

    private String iSBN, name, category, publisher, editionYear;
    private Author author;
    private int numberOfCopies;
    private double price;
    private Student[] students;

    public Book() {
    }

    public Book(String iSBN, String name, String category, String publisher, String editionYear, Author author, int numberOfCopies, double price) {
        this.iSBN = iSBN;
        this.name = name;
        this.category = category;
        this.publisher = publisher;
        this.editionYear = editionYear;
        this.author = author;
        this.numberOfCopies = numberOfCopies;
        this.price = price;
        students = new Student[numberOfCopies];
    }

    public String search(String n, String cat) {
        return "";
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEditionYear() {
        return editionYear;
    }

    public void setEditionYear(String editionYear) {
        this.editionYear = editionYear;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public static void AddBook() {
        //Author :(String email, String workplace, String identityNum, String name, String gender, String phone)
        //Book :String iSBN, String name, String category, String publisher, String editionYear, Author author, int numberOfCopies, double price
        in = new Scanner(System.in);
        try {

            System.out.println("please Enter Book Info");
            System.out.print("Enter Book iSBN: ");
            String iSBN = in.next();
            System.out.print("Enter Book name: ");
            String name = in.next();
            System.out.print("Enter Book category: ");
            String category = in.next();
            System.out.print("Enter Book publisher: ");
            String publisher = in.next();
            System.out.print("Enter Book editionYear: ");
            String editionYear = in.next();
            System.out.print("Enter Book numberOfCopies: ");
            int numberOfCopies = in.nextInt();
            System.out.print("Enter Book price: ");
            double price = in.nextDouble();

            System.out.println("----Auther For This Book");
            System.out.print("Enter Student Authorname: ");
            String AuthorName = in.next();
            System.out.print("Enter Author email: ");
            String email = in.next();
            System.out.print("Enter Author workplace: ");
            String workplace = in.next();
            System.out.print("Enter Author identityNum: ");
            String identityNum = in.next();
            System.out.print("Enter Author gender: ");
            String gender = in.next();
            System.out.print("Enter Book phone: ");
            String phone = in.next();
            BooksList.add(new Book(iSBN, name, category, publisher, editionYear, new Author(email, workplace, identityNum, AuthorName, gender, phone), numberOfCopies, price));
        } catch (InputMismatchException e) {
            System.out.println("there is some Error");
            in.next();
        }

    }

    public static void ShowBooks() {
        if (BooksList.isEmpty()) {
            System.out.println("+-+-+-+-+-+-+-+-+-+-");
            System.out.println("there is no Books !!");
            System.out.println("+-+-+-+-+-+-+-+-+-+-");
        } else {
            for (Book book : BooksList) {
                System.out.println("+-+-+-+-+-+-+-+-+-+-");

                System.out.println(book.toString());
                ///
                System.out.println("-----");
                System.out.println("Student that by book");

                try {
                    if (book.getStudents().length != 0) {
                        for (Student str : book.getStudents()) {
                            System.out.println(str.toString());
                            System.out.println("-----");

                        }
                    } else {
                        System.out.println("there is no Student By this Book");

                    }
                } catch (Exception e) {
                    System.err.println("");

                }

                System.out.println("+-+-+-+-+-+-+-+-+-+-");
            }

        }
    }

    public static void SearchBook(String iSBN, String category) {
        Book C = null;
        for (Book book : BooksList) {
            if (iSBN.equals(book.getiSBN()) && category.equals(book.getCategory())) {
                System.out.println(book.toString());

                C = book;
            }
        }
        if (C != null) {
        } else {
            System.out.println("+-+-+-+-+-+-+-+-+-+-");

            System.out.println("Cant Find This Book");
        }
    }

    @Override
    public String toString() {

        return "\niSBN : " + iSBN + "\nBookName : " + name + "\nCategory : " + category + "\nPublisher: " + publisher + "\nEditionYear: " + editionYear + "\nAuthor: " + author + "\nNumberOfCopies: " + numberOfCopies + "\nprice: " + price;
    }

}
