package src.Lecture4;

import java.io.*;
import java.util.*;

public class BookStore {
    Scanner scan = new Scanner(System.in);
    ArrayList<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        BookStore main = new BookStore();
        main.newMain();
    }

    void newMain() {
        readAllBooks("book2.txt");
        printAllBooks();
    }
    void readAllBooks(String filename) {
        Scanner filein = openFile(filename);
        Book b = null;
        while (filein.hasNext()) {
            int n = filein.nextInt();

            switch(n) {
                case 1: b = new Book(); break;
                case 2: b = new Ebook(); break;
                default: break;
            }

            if (b == null) {
                System.out.println("Error occurred");
                break;
            }

            b.read(filein);
            bookList.add(b);
        }

        filein.close();
    }

    void printAllBooks() {
        for(Book b : bookList) {
            b.print();
        }
    }

    Scanner openFile(String filename) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (IOException e) {
            System.out.println("File open failed : " + filename);
            throw new RuntimeException(e);
        }
        return filein;
    }
}
