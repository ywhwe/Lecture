package src.Store;

import src.Manager.Manageable;

import java.util.*;

public class Book implements Manageable {
    String title;
    String pub;
    String isbn;
    int year;
    ArrayList<String> authors = new ArrayList<>();
    int price;

    public void read(Scanner scan) {
        title = scan.next();
        pub = scan.next();
        isbn = scan.next();
        year = scan.nextInt();
        String tok;
        while(true) {
            tok = scan.next();
            if (tok.equals("0")) break;
            authors.add(tok);
        }

        price = scan.nextInt();

    }

    String getBookType() {
        return "[일반책]";
    }

    public void print() {
        System.out.printf("%s %s (%s/%s/%d년) [%d원] 저자:",getBookType(), title, pub, isbn, year, price);
        for (String a : authors) {
            System.out.printf(" %s ", a);
        }
        System.out.println();
    }

    public boolean matches(String kwd) {
        return title.contains(kwd);
    }
}
