package src.Lecture4;

import java.util.*;

public class Ebook extends Book {
    String url;
    String format;

    @Override
    void read(Scanner scan) {
        super.read(scan);

        url = scan.next();
        format = scan.next();
    }

    @Override
    void print() {
        super.print();
        System.out.printf("%s [%s]\n", url, format);
    }

    @Override
    boolean matches(String kwd) {
        if (super.matches(kwd)) return true;
        if (url.equals(kwd)) return true;
        if (format.equals(kwd)) return true;
        return false;
    }
}
