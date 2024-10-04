package src.Lecture4;

import java.util.*;

public class Book {
    String title;
    String pub;
    String isbn;
    int year;
    ArrayList<String> authors = new ArrayList<>();
    int price;

    void read(Scanner scan) {
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

    void print() {
        System.out.printf("%s (%s/%s/%d년)[%d원] 저자:", title, pub, isbn, year, price);
        for (String a : authors) {
            System.out.printf(" %s ", a);
        }
        System.out.println();
    }
    boolean matches(String kwd) {
        return true;
    }
}
